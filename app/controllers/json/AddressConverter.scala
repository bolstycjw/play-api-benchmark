package controllers.json

import dtos.AddressDto
import models.database.AddressRow
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Json, Reads, Writes}

class AddressConverter {
  implicit val addressReads: Reads[AddressDto] = (
    (JsPath \ "addressId").readNullable[String] and
      (JsPath \ "addressOne").readNullable[String] and
      (JsPath \ "userId").readNullable[String] and
      (JsPath \ "timestamp").readNullable[Long]
  )(AddressDto.apply _)

  implicit val addressWrites: Writes[AddressRow] = Json.writes[AddressRow]
}
