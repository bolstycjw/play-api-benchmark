package dtos

import models.database.Tables.{CategoryItemRow, ItemImageRow, ItemRow}

import scala.collection.parallel.ParSeq

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
      subitems = subitemDtos filter { _.itemId == itemRow._2.id },
      variants = variantDtos filter {_.itemId.getOrElse("") == itemRow._2.id },
      images = itemImages filter {_.itemId.getOrElse("") == itemRow._2.id } map { _.filename }
    )
  }
}
