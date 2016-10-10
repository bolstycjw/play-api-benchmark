package services

import javax.inject.{Inject, Singleton}

import dtos._
import models._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

@Singleton
class MenuService @Inject()(menuRepository: MenuRepository,
                            categoryRepository: CategoryRepository,
                            itemRepository: ItemRepository,
                            subitemRepository: SubitemRepository,
                            variantRepository: VariantRepository,
                            itemImageRepository: ItemImageRepository) {
  def retrieveMenu(menuId: String): Future[MenuDto] = {
    def assignToMap[A, B](as: Seq[A])(f: A => String)(bs: Seq[B])(g: B => String): Map[String, Seq[B]] = {
      import scala.collection.mutable.ListBuffer

      val cs = as.map(f(_) -> new ListBuffer[B]).toMap
      bs foreach { b => cs(g(b)) += b}
      cs mapValues { _.toList }
    }

    val categoryRowsFuture = categoryRepository.getByMenu(menuId)

    // ItemDtos
    val itemRows = categoryRowsFuture flatMap { tags =>
      itemRepository.getByCategories(tags map {
        _.id
      })
    }
    val itemDtosFuture = itemRows flatMap { items =>
      val itemIds = items.map(_._2.id)

      // VariantDtos
      val variantRowsFuture = variantRepository.getByItems(itemIds)
      val variantDtosFuture = variantRowsFuture map {
        _.map(VariantDto.toItemVariantDto)
      }

      // SubitemDtos
      val subitemDtosFuture = for {
        subitemRows <- subitemRepository.getByItems(itemIds)
        subitemVariantRows <- variantRepository.getBySubitems(
          subitemRows.map(_._2.id))
      } yield {
        val subitemVariantDtos = subitemVariantRows map { s =>
          VariantDto.toSubitemVariantDto(s._1, s._2)
        }

        val subitemVariantLists = assignToMap(subitemRows)(_._2.id)(subitemVariantDtos)(_.subitemId.getOrElse(""))
        subitemRows map { subitemRow =>
          val subitemId = subitemRow._2.id
          SubitemDto.toSubitemDto(subitemRow, subitemVariantLists(subitemId))
        }
      }

      // Build ItemDtos with VariantDtos and SubitemDtos
      for {
        itemImageRows <- itemImageRepository.getByItems(itemIds)
        variantDtos <- variantDtosFuture
        subitemDtos <- subitemDtosFuture
      } yield {

        def assignToItemsMap[A](as: Seq[A])(f: A => String) = assignToMap(items)(_._2.id)(as)(f)

        val itemImageLists = assignToItemsMap(itemImageRows)(_.itemId.getOrElse(""))
        val subitemLists = assignToItemsMap(subitemDtos)(_.itemId)
        val variantLists = assignToItemsMap(variantDtos)(_.itemId.getOrElse(""))

        items map { item =>
          val itemId = item._2.id
          ItemDto.toItemDto(item,
                            subitemLists(itemId),
                            variantLists(itemId),
                            itemImageLists(itemId))
        }
      }
    }

    // Build CategoryDtos and MenuDto
    for {
      categoryRows <- categoryRowsFuture
      itemDtos <- itemDtosFuture
    } yield {
      val itemLists = assignToMap(categoryRows)(_.id)(itemDtos)(_.tagId)

      val categoryDtos = categoryRows map { tag =>
        CategoryDto.toCategoryDto(tag, itemLists(tag.id))
      }
      MenuDto(categoryDtos)
    }
  }
}
