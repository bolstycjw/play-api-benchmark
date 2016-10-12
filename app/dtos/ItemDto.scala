package dtos

import models.database.{ItemRow, VariantRow}

case class ItemDto(
    itemRow: ItemRow,
    variants: Seq[VariantRow] = Nil,
    subitems: Seq[SubitemDto] = Nil,
    images: Seq[Option[String]] = Nil
)
