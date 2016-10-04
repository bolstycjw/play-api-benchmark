package dtos

case class MenuDto(categories: Seq[CategoryDto])

object MenuDto {
  def toMenuDto(categoryDtos: Seq[CategoryDto]): MenuDto = {
    MenuDto(
      categories = categoryDtos
    )
  }
}