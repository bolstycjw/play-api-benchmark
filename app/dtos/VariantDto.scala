package dtos

import models.database.Tables.{SubitemVariantRow, VariantRow}

case class VariantDto(
  id: String,
  itemId: Option[String] = None,
  subitemId: Option[String] = None,
  variantName: Option[String] = None,
  price: Option[Float] = None
)

object VariantDto {
  def toItemVariantDto(variantRow: VariantRow): VariantDto = {
    VariantDto(
      id = variantRow.id,
      itemId = variantRow.itemId,
      variantName = variantRow.variantName,
      price = variantRow.price
    )
  }

  def toSubitemVariantDto(subitemVariantRow: (SubitemVariantRow, VariantRow)): VariantDto = {
    VariantDto(
      id = subitemVariantRow._2.id,
      subitemId = subitemVariantRow._1.subitemId,
      variantName = subitemVariantRow._2.variantName,
      price = subitemVariantRow._2.price
    )
  }
}