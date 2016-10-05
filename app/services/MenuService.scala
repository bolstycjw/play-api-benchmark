package services

import javax.inject.{Inject, Singleton}

import dtos._
import models._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.collection.mutable
import scala.concurrent.Future

@Singleton
class MenuService @Inject()(menuRepository: MenuRepository,
                            categoryRepository: CategoryRepository,
                            itemRepository: ItemRepository,
                            subitemRepository: SubitemRepository,
                            variantRepository: VariantRepository,
                            itemImageRepository: ItemImageRepository) {
  def retrieveMenu(menuId: String): Future[MenuDto] = {
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
        val subitemVariantLists =
          subitemRows.map(_._2.id -> new mutable.ListBuffer[VariantDto]).toMap
        subitemVariantDtos.foreach { dto =>
          subitemVariantLists(dto.subitemId.getOrElse("")) += dto
        }
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
        val itemImageLists =
          items.map(_._2.id -> new mutable.ListBuffer[Option[String]]).toMap
        itemImageRows.foreach { dto =>
          itemImageLists(dto.itemId.getOrElse("")) += dto.filename
        }

        val subitemLists =
          items.map(_._2.id -> new mutable.ListBuffer[SubitemDto]).toMap
        subitemDtos.foreach { dto =>
          subitemLists(dto.itemId) += dto
        }

        val variantLists =
          items.map(_._2.id -> new mutable.ListBuffer[VariantDto]).toMap
        variantDtos.foreach { dto =>
          variantLists(dto.itemId.getOrElse("")) += dto
        }

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
      val itemLists =
        categoryRows.map(_.id -> new mutable.ListBuffer[ItemDto]).toMap
      itemDtos.foreach { dto =>
        itemLists(dto.tagId) += dto
      }

      val categoryDtos = categoryRows map { tag =>
        CategoryDto.toCategoryDto(tag, itemLists(tag.id))
      }
      MenuDto(categoryDtos)
    }
  }
}
