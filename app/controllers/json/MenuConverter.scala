package controllers.json

import dtos._
import play.api.libs.json.Json

class MenuConverter {
  implicit val variantWrites = Json.writes[VariantDto]
  implicit val subitemWrites = Json.writes[SubitemDto]
  implicit val itemWrites = Json.writes[ItemDto]
  implicit val categoryWrites = Json.writes[CategoryDto]
  implicit val menuWrites = Json.writes[MenuDto]
}
