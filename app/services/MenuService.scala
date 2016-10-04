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
    val categoryRowsFuture = categoryRepository.getByMenu(menuId)

    // ItemDtos
    val itemRows = categoryRowsFuture flatMap { tags =>
      itemRepository.getByCategories(tags map { _.id })
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
        subitemRows map { SubitemDto.toSubitemDto(_, subitemVariantDtos) }
      }

      // Build ItemDtos with VariantDtos and SubitemDtos
      for {
        itemImageRows <- itemImageRepository.getByItems(itemIds)
        variantDtos <- variantDtosFuture
        subitemDtos <- subitemDtosFuture
      } yield {
        items map {
          ItemDto.toItemDto(_, subitemDtos, variantDtos, itemImageRows)
        }
      }
    }

    // Build CategoryDtos and MenuDto
    for {
      categoryRows <- categoryRowsFuture
      itemDtos <- itemDtosFuture
    } yield {
      val categoryDtos = categoryRows map {
        CategoryDto.toCategoryDto(_, itemDtos)
      }
      MenuDto(categoryDtos)
    }
  }
}
