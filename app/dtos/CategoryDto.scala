package dtos

import models.database.Tables.CategoryRow

import scala.collection.parallel.ParSeq

case class CategoryDto(
    id: String,
    name: Option[String] = None,
    description: Option[String] = None,
    status: Option[Int] = None,
    items: Seq[ItemDto] = Nil
)

object CategoryDto {
  def toCategoryDto(categoryRow: CategoryRow, itemDtos: Seq[ItemDto]) = {
    CategoryDto(
      id = categoryRow.id,
      name = categoryRow.name,
      description = categoryRow.description,
      status = categoryRow.displayToPublic,
      items = itemDtos filter { _.tagId == categoryRow.id }
    )
  }
}
