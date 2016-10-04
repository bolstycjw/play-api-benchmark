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
    for {
      categoryRows <- categoryRepository.getByMenu(menuId)
      itemRows <- itemRepository.getByCategories(categoryRows map { _.id })
      subitemRows <- subitemRepository.getByItems(itemRows map { _._2.id })
      subitemVariantRows <- variantRepository.getBySubitems(subitemRows map { _._2.id })
      variantRows <- variantRepository.getByItems(itemRows map { _._2.id })
      itemImageRows <- itemImageRepository.getByItems(itemRows map { _._2.id })

      variantDtos <- Future { variantRows.par map { VariantDto.toItemVariantDto } }
      subitemVariantDtos <- Future { subitemVariantRows.par map { s => VariantDto.toSubitemVariantDto(s._1, s._2) } }
      subitemDtos <- Future { subitemRows.par map { SubitemDto.toSubitemDto(_, subitemVariantDtos) } }
      itemDtos <- Future { itemRows.par map { ItemDto.toItemDto(_, subitemDtos, variantDtos, itemImageRows) } }
      categoryDtos <- Future { categoryRows map { CategoryDto.toCategoryDto(_, itemDtos) } }
      menuDto <- Future { MenuDto(categoryDtos) }
    } yield menuDto
  }
}
