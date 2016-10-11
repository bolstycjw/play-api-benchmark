package services

import javax.inject.{Inject, Singleton}

import dtos._
import models._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

@Singleton
class MenuService @Inject()(categoryRepository: CategoryRepository,
                            itemRepository: ItemRepository,
                            subitemRepository: SubitemRepository,
                            variantRepository: VariantRepository,
                            itemImageRepository: ItemImageRepository) {
  def retrieveMenu(menuId: String): Future[MenuDto] = {
    def assignToMap[A, B](as: Seq[A])(f: A => String)(bs: Seq[B])(
        g: B => String): Map[String, Seq[B]] = {
      import scala.collection.mutable.ListBuffer

      val cs = as.map(f(_) -> new ListBuffer[B]).toMap
      bs foreach { b =>
        cs(g(b)) += b
      }
      cs mapValues { _.toList }
    }

    val categoryRowsFuture = categoryRepository.getByMenu(menuId)

    // ItemDtos
    val itemRowsFuture = categoryRowsFuture flatMap { tags =>
      itemRepository.getByCategories(tags map {
        _.id
      })
    }
    val itemDtosFuture = itemRowsFuture flatMap { itemRows =>
      val itemIds = itemRows.map(_._2.id)

      // VariantDtos
      val variantRowsFuture = variantRepository.getByItems(itemIds)

      // SubitemDtos
      val subitemDtosFuture = for {
        subitemRows <- subitemRepository.getByItems(itemIds)
        subitemVariantRows <- variantRepository.getBySubitems(
          subitemRows.map(_._2.id))
      } yield {
        val subitemVariantLists = assignToMap(subitemRows)(_._2.id)(
          subitemVariantRows)(_._1.subitemId.getOrElse(""))
        subitemRows map { subitemRow =>
          val (itemSubitem, subitem) = subitemRow
          (itemSubitem.itemId,
           SubitemDto(subitem, subitemVariantLists(subitem.id).map(_._2)))
        }
      }

      // Build ItemDtos with VariantDtos and SubitemDtos
      for {
        itemImageRows <- itemImageRepository.getByItems(itemIds)
        variantRows <- variantRowsFuture
        subitemDtos <- subitemDtosFuture
      } yield {

        def assignToItemsMap[A](as: Seq[A])(f: A => String) =
          assignToMap(itemRows)(_._2.id)(as)(f)

        val itemImageLists =
          assignToItemsMap(itemImageRows)(_.itemId.getOrElse(""))
        val subitemLists = assignToItemsMap(subitemDtos)(_._1.getOrElse(""))
        val variantLists =
          assignToItemsMap(variantRows)(_.itemId.getOrElse(""))

        itemRows map { itemRow =>
          val (categoryItem, item) = itemRow
          (categoryItem.tagId, ItemDto(item,
                  variantLists(item.id),
                  subitemLists(item.id).map(_._2),
                  itemImageLists(item.id).map(_.filename)))
        }
      }
    }

    // Build CategoryDtos and MenuDto
    for {
      categoryRows <- categoryRowsFuture
      itemDtos <- itemDtosFuture
    } yield {
      val itemLists = assignToMap(categoryRows)(_.id)(itemDtos)(_._1.getOrElse(""))

      val categoryDtos = categoryRows map { tag =>
        CategoryDto(tag, itemLists(tag.id).map(_._2))
      }
      MenuDto(categoryDtos)
    }
  }
}
