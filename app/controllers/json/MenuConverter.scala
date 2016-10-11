package controllers.json

import dtos.{CategoryDto, ItemDto, MenuDto, SubitemDto}
import models.database.VariantRow
import play.api.libs.json.{Json, Writes}

class MenuConverter {
  implicit val subitemWrites: Writes[SubitemDto] = Writes[SubitemDto] {
    subitemDto =>
      val subitemRow = subitemDto.subitemRow
      Json.obj(
        "id" -> subitemRow.id,
        "version" -> subitemRow.version,
        "createdBy" -> subitemRow.createdBy,
        "updatedBy" -> subitemRow.updatedBy,
        "createdOn" -> subitemRow.createdOn,
        "updatedOn" -> subitemRow.updatedOn,
        "displayPosition" -> subitemRow.displayPosition,
        "displayToPublic" -> subitemRow.displayToPublic,
        "minimumQuantity" -> subitemRow.minimumQuantity,
        "maximumQuantity" -> subitemRow.maximumQuantity,
        "defaultSubitemVariantId" -> subitemRow.defaultSubitemVariantId,
        "description" -> subitemRow.description,
        "menuId" -> subitemRow.menuId,
        "variants" -> subitemDto.variants
      )
  }
  implicit val variantWrites: Writes[VariantRow] = Writes[VariantRow] {
    variantRow =>
      Json.obj(
        "id" -> variantRow.id,
        "version" -> variantRow.version,
        "createdBy" -> variantRow.createdBy,
        "updatedBy" -> variantRow.updatedBy,
        "createdOn" -> variantRow.updatedOn,
        "variant1" -> variantRow.variant1,
        "variant2" -> variantRow.variant2,
        "variant3" -> variantRow.variant3,
        "itemId" -> variantRow.itemId,
        "price" -> variantRow.price,
        "belongsToCompositeItem" -> variantRow.belongsToCompositeItem,
        "variantName" -> variantRow.variantName,
        "displayPosition" -> variantRow.displayPosition
      )
  }
  implicit val itemWrites: Writes[ItemDto] = Writes[ItemDto] { itemDto =>
    val itemRow = itemDto.itemRow
    Json.obj(
      "id" -> itemRow.id,
      "createdOn" -> itemRow.createdOn,
      "updatedOn" -> itemRow.updatedOn,
      "createdBy" -> itemRow.createdBy,
      "updatedBy" -> itemRow.updatedBy,
      "description" -> itemRow.description,
      "name" -> itemRow.name,
      "version" -> itemRow.version,
      "availableType" -> itemRow.availableType,
      "orderId" -> itemRow.orderId,
      "startDateTime" -> itemRow.startDateTime,
      "endDateTime" -> itemRow.endDateTime,
      "menuId" -> itemRow.menuId,
      "isCompositeItem" -> itemRow.isCompositeItem,
      "collectionStartDate" -> itemRow.collectionStartDate,
      "collectionEndDate" -> itemRow.collectionEndDate,
      "dayInWeek" -> itemRow.dayInWeek,
      "muteUntil" -> itemRow.muteUntil,
      "displayToPublic" -> itemRow.displayToPublic,
      "productType" -> itemRow.productType,
      "variants" -> itemDto.variants,
      "subitems" -> itemDto.subitems,
      "images" -> itemDto.images
    )
  }
  implicit val categoryWrites: Writes[CategoryDto] = Writes[CategoryDto] {
    categoryDto =>
      val categoryRow = categoryDto.categoryRow
      Json.obj(
        "id" -> categoryRow.id,
        "version" -> categoryRow.version,
        "createdBy" -> categoryRow.createdBy,
        "updatedBy" -> categoryRow.updatedBy,
        "createdOn" -> categoryRow.createdOn,
        "updatedOn" -> categoryRow.updatedOn,
        "description" -> categoryRow.description,
        "displayPosition" -> categoryRow.displayPosition,
        "displayToPublic" -> categoryRow.displayToPublic,
        "availableType" -> categoryRow.availableType,
        "startDateTime" -> categoryRow.startDateTime,
        "endDateTime" -> categoryRow.endDateTime,
        "menuId" -> categoryRow.menuId,
        "name" -> categoryRow.name,
        "collectionStartDate" -> categoryRow.collectionStartDate,
        "collectionEndDate" -> categoryRow.collectionEndDate,
        "dayInWeek" -> categoryRow.dayInWeek,
        "muteUntil" -> categoryRow.muteUntil,
        "productType" -> categoryRow.productType,
        "items" -> categoryDto.items
      )
  }
  implicit val menuWrites = Json.writes[MenuDto]
}
