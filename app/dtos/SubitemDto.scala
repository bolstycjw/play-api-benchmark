package dtos

import models.database.Tables.{ItemSubitemRow, SubitemRow}

case class SubitemDto(
    id: String,
    itemId: String,
    description: Option[String] = None,
    minimumQuantity: Option[Int] = None,
    maximumQuantity: Option[Int] = None,
    selectableOnce: Option[Int] = None,
    variants: Seq[VariantDto] = Nil
)

object SubitemDto {
  def toSubitemDto(subitemRow: (ItemSubitemRow, SubitemRow), variantDtos: Seq[VariantDto]): SubitemDto = {
    SubitemDto(
      id = subitemRow._2.id,
      itemId = subitemRow._1.itemId.getOrElse(""),
      description = subitemRow._2.description,
      minimumQuantity = subitemRow._2.minimumQuantity,
      maximumQuantity = subitemRow._2.maximumQuantity,
      selectableOnce = subitemRow._2.selectableOnce,
      variants = variantDtos filter { _.subitemId.getOrElse("") == subitemRow._2.id }
    )
  }
}