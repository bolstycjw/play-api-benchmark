package dtos

import models.database.CategoryRow

case class CategoryDto(
    categoryRow: CategoryRow,
    items: Seq[ItemDto] = Nil
)
