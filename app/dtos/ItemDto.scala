package dtos

import models.database.Tables.{CategoryItemRow, ItemImageRow, ItemRow}

case class ItemDto(
    id: String,
    tagId: String,
    name: Option[String] = None,
    description: Option[String] = None,
    status: Option[Int] = None,
    variants: Seq[VariantDto] = Nil,
    subitems: Seq[SubitemDto] = Nil,
    images: Seq[Option[String]] = Nil
)

object ItemDto {
  def toItemDto(itemRow: (CategoryItemRow, ItemRow),
                subitemDtos: Seq[SubitemDto],
                variantDtos: Seq[VariantDto], itemImages: Seq[ItemImageRow]): ItemDto = {
    ItemDto(
      id = itemRow._2.id,
      tagId = itemRow._1.tagId.getOrElse(""),
      subitems = subitemDtos,
      variants = variantDtos,
      images = itemImages map { _.filename }
    )
  }
}
