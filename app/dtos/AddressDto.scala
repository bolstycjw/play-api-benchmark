package dtos

import java.sql.Timestamp

case class AddressDto(
    id: Option[String],
    addressOne: Option[String],
    userId: Option[String],
    timestamp: Option[Long]
)
