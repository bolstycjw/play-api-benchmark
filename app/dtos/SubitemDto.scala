package dtos

import models.database.{SubitemRow, VariantRow}

case class SubitemDto(
    subitemRow: SubitemRow,
    variants: Seq[VariantRow] = Nil
)

