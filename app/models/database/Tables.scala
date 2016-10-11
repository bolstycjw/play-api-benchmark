package models.database

import org.joda.time.DateTime

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import com.github.tototoshi.slick.MySQLJodaSupport._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Address.schema, Category.schema, CategoryItem.schema, Item.schema, ItemImage.schema, ItemSubitem.schema, Subitem.schema, SubitemVariant.schema, Variant.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema


  /** GetResult implicit for fetching AddressRow objects using plain SQL queries */
  implicit def GetResultAddressRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Float]], e3: GR[Option[Int]], e4: GR[Option[DateTime]]): GR[AddressRow] = GR{
    prs => import prs._
    AddressRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Float], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String]))
  }
  /** Table description of table address. Objects of this class serve as prototypes for rows in queries. */
  class Address(_tableTag: Tag) extends Table[AddressRow](_tableTag, "address") {
    def * = (id, address, addressTwo, city, state, postal, latitude, longitude, country, customerId, version, createdBy, updatedBy, createdOn, updatedOn, autoCompleteAddress) <> (AddressRow.tupled, AddressRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), address, addressTwo, city, state, postal, latitude, longitude, country, customerId, version, createdBy, updatedBy, createdOn, updatedOn, autoCompleteAddress).shaped.<>({r=>import r._; _1.map(_=> AddressRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column address SqlType(TEXT), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Default(None))
    /** Database column address_two SqlType(TEXT), Default(None) */
    val addressTwo: Rep[Option[String]] = column[Option[String]]("address_two", O.Default(None))
    /** Database column city SqlType(VARCHAR), Length(255,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(255,varying=true), O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column postal SqlType(VARCHAR), Length(255,true), Default(None) */
    val postal: Rep[Option[String]] = column[Option[String]]("postal", O.Length(255,varying=true), O.Default(None))
    /** Database column latitude SqlType(FLOAT), Default(None) */
    val latitude: Rep[Option[Float]] = column[Option[Float]]("latitude", O.Default(None))
    /** Database column longitude SqlType(FLOAT), Default(None) */
    val longitude: Rep[Option[Float]] = column[Option[Float]]("longitude", O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(None))
    /** Database column customer_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val customerId: Rep[Option[String]] = column[Option[String]]("customer_id", O.Length(32,varying=true), O.Default(None))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column auto_complete_address SqlType(VARCHAR), Length(255,true), Default(None) */
    val autoCompleteAddress: Rep[Option[String]] = column[Option[String]]("auto_complete_address", O.Length(255,varying=true), O.Default(None))

    /** Index over (customerId) (database name fk_customer_idx) */
    val index1 = index("fk_customer_idx", customerId)
  }
  /** Collection-like TableQuery object for table Address */
  lazy val Address = new TableQuery(tag => new Address(tag))


  /** GetResult implicit for fetching CategoryRow objects using plain SQL queries */
  implicit def GetResultCategoryRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[CategoryRow] = GR{
    prs => import prs._
    CategoryRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[DateTime], <<?[Int]))
  }
  /** Table description of table tag. Objects of this class serve as prototypes for rows in queries. */
  class Category(_tableTag: Tag) extends Table[CategoryRow](_tableTag, "tag") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, description, displayPosition, displayToPublic, availableType, startDateTime, endDateTime, menuId, name, collectionStartDate, collectionEndDate, dayInWeek, muteUntil, productType) <> (CategoryRow.tupled, CategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, description, displayPosition, displayToPublic, availableType, startDateTime, endDateTime, menuId, name, collectionStartDate, collectionEndDate, dayInWeek, muteUntil, productType).shaped.<>({r=>import r._; _1.map(_=> CategoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))
    /** Database column display_to_public SqlType(INT), Default(None) */
    val displayToPublic: Rep[Option[Int]] = column[Option[Int]]("display_to_public", O.Default(None))
    /** Database column available_type SqlType(INT), Default(None) */
    val availableType: Rep[Option[Int]] = column[Option[Int]]("available_type", O.Default(None))
    /** Database column start_date_time SqlType(DATETIME), Default(None) */
    val startDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date_time", O.Default(None))
    /** Database column end_date_time SqlType(DATETIME), Default(None) */
    val endDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date_time", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column name SqlType(TEXT), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column collection_start_date SqlType(DATETIME), Default(None) */
    val collectionStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("collection_start_date", O.Default(None))
    /** Database column collection_end_date SqlType(DATETIME), Default(None) */
    val collectionEndDate: Rep[Option[DateTime]] = column[Option[DateTime]]("collection_end_date", O.Default(None))
    /** Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None) */
    val dayInWeek: Rep[Option[String]] = column[Option[String]]("day_in_week", O.Length(255,varying=true), O.Default(None))
    /** Database column mute_until SqlType(DATETIME), Default(None) */
    val muteUntil: Rep[Option[DateTime]] = column[Option[DateTime]]("mute_until", O.Default(None))
    /** Database column product_type SqlType(INT), Default(None) */
    val productType: Rep[Option[Int]] = column[Option[Int]]("product_type", O.Default(None))

    /** Index over (menuId) (database name fk_tag_1_idx) */
    val index1 = index("fk_tag_1_idx", menuId)
  }
  /** Collection-like TableQuery object for table Category */
  lazy val Category = new TableQuery(tag => new Category(tag))


  /** GetResult implicit for fetching CategoryItemRow objects using plain SQL queries */
  implicit def GetResultCategoryItemRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[CategoryItemRow] = GR{
    prs => import prs._
    CategoryItemRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table tag_item. Objects of this class serve as prototypes for rows in queries. */
  class CategoryItem(_tableTag: Tag) extends Table[CategoryItemRow](_tableTag, "tag_item") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, tagId, itemId) <> (CategoryItemRow.tupled, CategoryItemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, tagId, itemId).shaped.<>({r=>import r._; _1.map(_=> CategoryItemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))
    /** Database column tag_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val tagId: Rep[Option[String]] = column[Option[String]]("tag_id", O.Length(32,varying=true), O.Default(None))
    /** Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val itemId: Rep[Option[String]] = column[Option[String]]("item_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Item (database name fk_tag_item_2) */
    lazy val itemFk = foreignKey("fk_tag_item_2", itemId, Item)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Category (database name fk_tag_item_1) */
    lazy val categoryFk = foreignKey("fk_tag_item_1", tagId, Category)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table CategoryItem */
  lazy val CategoryItem = new TableQuery(tag => new CategoryItem(tag))


  /** GetResult implicit for fetching ItemRow objects using plain SQL queries */
  implicit def GetResultItemRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[ItemRow] = GR{
    prs => import prs._
    ItemRow.tupled((<<[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[String], <<?[DateTime], <<?[Int], <<?[Int]))
  }
  /** Table description of table item. Objects of this class serve as prototypes for rows in queries. */
  class Item(_tableTag: Tag) extends Table[ItemRow](_tableTag, "item") {
    def * = (id, createdOn, updatedOn, createdBy, updatedBy, description, name, version, availableType, orderId, startDateTime, endDateTime, menuId, isCompositeItem, collectionStartDate, collectionEndDate, dayInWeek, muteUntil, displayToPublic, productType) <> (ItemRow.tupled, ItemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdOn, updatedOn, createdBy, updatedBy, description, name, version, availableType, orderId, startDateTime, endDateTime, menuId, isCompositeItem, collectionStartDate, collectionEndDate, dayInWeek, muteUntil, displayToPublic, productType).shaped.<>({r=>import r._; _1.map(_=> ItemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(Some(NULL)) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(Some("NULL")))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column available_type SqlType(INT), Default(None) */
    val availableType: Rep[Option[Int]] = column[Option[Int]]("available_type", O.Default(None))
    /** Database column order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val orderId: Rep[Option[String]] = column[Option[String]]("order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column start_date_time SqlType(DATETIME), Default(None) */
    val startDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date_time", O.Default(None))
    /** Database column end_date_time SqlType(DATETIME), Default(None) */
    val endDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date_time", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column is_composite_item SqlType(INT), Default(Some(0)) */
    val isCompositeItem: Rep[Option[Int]] = column[Option[Int]]("is_composite_item", O.Default(Some(0)))
    /** Database column collection_start_date SqlType(DATETIME), Default(None) */
    val collectionStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("collection_start_date", O.Default(None))
    /** Database column collection_end_date SqlType(DATETIME), Default(None) */
    val collectionEndDate: Rep[Option[DateTime]] = column[Option[DateTime]]("collection_end_date", O.Default(None))
    /** Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None) */
    val dayInWeek: Rep[Option[String]] = column[Option[String]]("day_in_week", O.Length(255,varying=true), O.Default(None))
    /** Database column mute_until SqlType(DATETIME), Default(None) */
    val muteUntil: Rep[Option[DateTime]] = column[Option[DateTime]]("mute_until", O.Default(None))
    /** Database column display_to_public SqlType(INT), Default(Some(1)) */
    val displayToPublic: Rep[Option[Int]] = column[Option[Int]]("display_to_public", O.Default(Some(1)))
    /** Database column product_type SqlType(INT), Default(None) */
    val productType: Rep[Option[Int]] = column[Option[Int]]("product_type", O.Default(None))

    /** Index over (orderId) (database name fk_item_1_idx) */
    val index1 = index("fk_item_1_idx", orderId)
    /** Index over (menuId) (database name fk_item_2_idx) */
    val index2 = index("fk_item_2_idx", menuId)
  }
  /** Collection-like TableQuery object for table Item */
  lazy val Item = new TableQuery(tag => new Item(tag))


  /** GetResult implicit for fetching ItemImageRow objects using plain SQL queries */
  implicit def GetResultItemImageRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[ItemImageRow] = GR{
    prs => import prs._
    ItemImageRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table item_image. Objects of this class serve as prototypes for rows in queries. */
  class ItemImage(_tableTag: Tag) extends Table[ItemImageRow](_tableTag, "item_image") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, filename, itemId) <> (ItemImageRow.tupled, ItemImageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, filename, itemId).shaped.<>({r=>import r._; _1.map(_=> ItemImageRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))
    /** Database column filename SqlType(VARCHAR), Length(255,true), Default(None) */
    val filename: Rep[Option[String]] = column[Option[String]]("filename", O.Length(255,varying=true), O.Default(None))
    /** Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val itemId: Rep[Option[String]] = column[Option[String]]("item_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Item (database name fk_item_image_1) */
    lazy val itemFk = foreignKey("fk_item_image_1", itemId, Item)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ItemImage */
  lazy val ItemImage = new TableQuery(tag => new ItemImage(tag))


  /** GetResult implicit for fetching ItemSubitemRow objects using plain SQL queries */
  implicit def GetResultItemSubitemRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[ItemSubitemRow] = GR{
    prs => import prs._
    ItemSubitemRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table item_subitem. Objects of this class serve as prototypes for rows in queries. */
  class ItemSubitem(_tableTag: Tag) extends Table[ItemSubitemRow](_tableTag, "item_subitem") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, itemId, subitemId, displayPosition) <> (ItemSubitemRow.tupled, ItemSubitemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, itemId, subitemId, displayPosition).shaped.<>({r=>import r._; _1.map(_=> ItemSubitemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val itemId: Rep[Option[String]] = column[Option[String]]("item_id", O.Length(32,varying=true), O.Default(None))
    /** Database column subitem_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val subitemId: Rep[Option[String]] = column[Option[String]]("subitem_id", O.Length(32,varying=true), O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))

    /** Foreign key referencing Item (database name fk_item_subitem_1) */
    lazy val itemFk = foreignKey("fk_item_subitem_1", itemId, Item)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Subitem (database name fk_item_subitem_2) */
    lazy val subitemFk = foreignKey("fk_item_subitem_2", subitemId, Subitem)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ItemSubitem */
  lazy val ItemSubitem = new TableQuery(tag => new ItemSubitem(tag))


  /** GetResult implicit for fetching SubitemRow objects using plain SQL queries */
  implicit def GetResultSubitemRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[SubitemRow] = GR{
    prs => import prs._
    SubitemRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table subitem. Objects of this class serve as prototypes for rows in queries. */
  class Subitem(_tableTag: Tag) extends Table[SubitemRow](_tableTag, "subitem") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, displayToPublic, minimumQuantity, maximumQuantity, defaultSubitemVariantId, description, menuId, selectableOnce) <> (SubitemRow.tupled, SubitemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, displayPosition, displayToPublic, minimumQuantity, maximumQuantity, defaultSubitemVariantId, description, menuId, selectableOnce).shaped.<>({r=>import r._; _1.map(_=> SubitemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))
    /** Database column display_to_public SqlType(INT), Default(None) */
    val displayToPublic: Rep[Option[Int]] = column[Option[Int]]("display_to_public", O.Default(None))
    /** Database column minimum_quantity SqlType(INT), Default(None) */
    val minimumQuantity: Rep[Option[Int]] = column[Option[Int]]("minimum_quantity", O.Default(None))
    /** Database column maximum_quantity SqlType(INT), Default(None) */
    val maximumQuantity: Rep[Option[Int]] = column[Option[Int]]("maximum_quantity", O.Default(None))
    /** Database column default_subitem_variant_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val defaultSubitemVariantId: Rep[Option[String]] = column[Option[String]]("default_subitem_variant_id", O.Length(32,varying=true), O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column selectable_once SqlType(INT), Default(Some(0)) */
    val selectableOnce: Rep[Option[Int]] = column[Option[Int]]("selectable_once", O.Default(Some(0)))

    /** Index over (menuId) (database name fk_subitem_1_idx) */
    val index1 = index("fk_subitem_1_idx", menuId)
    /** Index over (defaultSubitemVariantId) (database name fk_subitem_2_idx) */
    val index2 = index("fk_subitem_2_idx", defaultSubitemVariantId)
  }
  /** Collection-like TableQuery object for table Subitem */
  lazy val Subitem = new TableQuery(tag => new Subitem(tag))


  /** GetResult implicit for fetching SubitemVariantRow objects using plain SQL queries */
  implicit def GetResultSubitemVariantRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[SubitemVariantRow] = GR{
    prs => import prs._
    SubitemVariantRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Float], <<?[Int], <<?[Int]))
  }
  /** Table description of table subitem_variant. Objects of this class serve as prototypes for rows in queries. */
  class SubitemVariant(_tableTag: Tag) extends Table[SubitemVariantRow](_tableTag, "subitem_variant") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, variantId, subitemId, priceUnderMinimumSelection, preselect, displayPosition) <> (SubitemVariantRow.tupled, SubitemVariantRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, variantId, subitemId, priceUnderMinimumSelection, preselect, displayPosition).shaped.<>({r=>import r._; _1.map(_=> SubitemVariantRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val variantId: Rep[Option[String]] = column[Option[String]]("variant_id", O.Length(32,varying=true), O.Default(None))
    /** Database column subitem_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val subitemId: Rep[Option[String]] = column[Option[String]]("subitem_id", O.Length(32,varying=true), O.Default(None))
    /** Database column price_under_minimum_selection SqlType(FLOAT), Default(None) */
    val priceUnderMinimumSelection: Rep[Option[Float]] = column[Option[Float]]("price_under_minimum_selection", O.Default(None))
    /** Database column preselect SqlType(INT), Default(Some(0)) */
    val preselect: Rep[Option[Int]] = column[Option[Int]]("preselect", O.Default(Some(0)))
    /** Database column display_position SqlType(INT), Default(Some(0)) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(Some(0)))

    /** Foreign key referencing Subitem (database name fk_subitem_variant_1) */
    lazy val subitemFk = foreignKey("fk_subitem_variant_1", subitemId, Subitem)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Variant (database name fk_subitem_variant_2) */
    lazy val variantFk = foreignKey("fk_subitem_variant_2", variantId, Variant)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table SubitemVariant */
  lazy val SubitemVariant = new TableQuery(tag => new SubitemVariant(tag))


  /** GetResult implicit for fetching VariantRow objects using plain SQL queries */
  implicit def GetResultVariantRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[VariantRow] = GR{
    prs => import prs._
    VariantRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table variant. Objects of this class serve as prototypes for rows in queries. */
  class Variant(_tableTag: Tag) extends Table[VariantRow](_tableTag, "variant") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, variant1, variant2, variant3, itemId, price, belongsToCompositeItem, variantName, displayPosition) <> (VariantRow.tupled, VariantRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, variant1, variant2, variant3, itemId, price, belongsToCompositeItem, variantName, displayPosition).shaped.<>({r=>import r._; _1.map(_=> VariantRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column variant1 SqlType(TEXT), Default(None) */
    val variant1: Rep[Option[String]] = column[Option[String]]("variant1", O.Default(None))
    /** Database column variant2 SqlType(TEXT), Default(None) */
    val variant2: Rep[Option[String]] = column[Option[String]]("variant2", O.Default(None))
    /** Database column variant3 SqlType(TEXT), Default(None) */
    val variant3: Rep[Option[String]] = column[Option[String]]("variant3", O.Default(None))
    /** Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val itemId: Rep[Option[String]] = column[Option[String]]("item_id", O.Length(32,varying=true), O.Default(None))
    /** Database column price SqlType(FLOAT), Default(None) */
    val price: Rep[Option[Float]] = column[Option[Float]]("price", O.Default(None))
    /** Database column belongs_to_composite_item SqlType(INT), Default(Some(0)) */
    val belongsToCompositeItem: Rep[Option[Int]] = column[Option[Int]]("belongs_to_composite_item", O.Default(Some(0)))
    /** Database column variant_name SqlType(VARCHAR), Length(32,true), Default(None) */
    val variantName: Rep[Option[String]] = column[Option[String]]("variant_name", O.Length(32,varying=true), O.Default(None))
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))

    /** Foreign key referencing Item (database name fk_variant_1) */
    lazy val itemFk = foreignKey("fk_variant_1", itemId, Item)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Variant */
  lazy val Variant = new TableQuery(tag => new Variant(tag))
}
/** Entity class storing rows of table Address
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param address Database column address SqlType(TEXT), Default(None)
   *  @param addressTwo Database column address_two SqlType(TEXT), Default(None)
   *  @param city Database column city SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param postal Database column postal SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param latitude Database column latitude SqlType(FLOAT), Default(None)
   *  @param longitude Database column longitude SqlType(FLOAT), Default(None)
   *  @param country Database column country SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param customerId Database column customer_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param autoCompleteAddress Database column auto_complete_address SqlType(VARCHAR), Length(255,true), Default(None) */
  case class AddressRow(id: String, address: Option[String] = None, addressTwo: Option[String] = None, city: Option[String] = None, state: Option[String] = None, postal: Option[String] = None, latitude: Option[Float] = None, longitude: Option[Float] = None, country: Option[String] = None, customerId: Option[String] = None, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, autoCompleteAddress: Option[String] = None)

  /** Entity class storing rows of table Category
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None)
   *  @param displayToPublic Database column display_to_public SqlType(INT), Default(None)
   *  @param availableType Database column available_type SqlType(INT), Default(None)
   *  @param startDateTime Database column start_date_time SqlType(DATETIME), Default(None)
   *  @param endDateTime Database column end_date_time SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param name Database column name SqlType(TEXT), Default(None)
   *  @param collectionStartDate Database column collection_start_date SqlType(DATETIME), Default(None)
   *  @param collectionEndDate Database column collection_end_date SqlType(DATETIME), Default(None)
   *  @param dayInWeek Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param muteUntil Database column mute_until SqlType(DATETIME), Default(None)
   *  @param productType Database column product_type SqlType(INT), Default(None) */
  case class CategoryRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, description: Option[String] = None, displayPosition: Option[Int] = None, displayToPublic: Option[Int] = None, availableType: Option[Int] = None, startDateTime: Option[DateTime] = None, endDateTime: Option[DateTime] = None, menuId: Option[String] = None, name: Option[String] = None, collectionStartDate: Option[DateTime] = None, collectionEndDate: Option[DateTime] = None, dayInWeek: Option[String] = None, muteUntil: Option[DateTime] = None, productType: Option[Int] = None)

  /** Entity class storing rows of table CategoryItem
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None)
   *  @param tagId Database column tag_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param itemId Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class CategoryItemRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, displayPosition: Option[Int] = None, tagId: Option[String] = None, itemId: Option[String] = None)

  /** Entity class storing rows of table Item
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(Some(NULL))
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param availableType Database column available_type SqlType(INT), Default(None)
   *  @param orderId Database column order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param startDateTime Database column start_date_time SqlType(DATETIME), Default(None)
   *  @param endDateTime Database column end_date_time SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param isCompositeItem Database column is_composite_item SqlType(INT), Default(Some(0))
   *  @param collectionStartDate Database column collection_start_date SqlType(DATETIME), Default(None)
   *  @param collectionEndDate Database column collection_end_date SqlType(DATETIME), Default(None)
   *  @param dayInWeek Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param muteUntil Database column mute_until SqlType(DATETIME), Default(None)
   *  @param displayToPublic Database column display_to_public SqlType(INT), Default(Some(1))
   *  @param productType Database column product_type SqlType(INT), Default(None) */
  case class ItemRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, description: Option[String] = None, name: Option[String] = Some("NULL"), version: Option[Int] = None, availableType: Option[Int] = None, orderId: Option[String] = None, startDateTime: Option[DateTime] = None, endDateTime: Option[DateTime] = None, menuId: Option[String] = None, isCompositeItem: Option[Int] = Some(0), collectionStartDate: Option[DateTime] = None, collectionEndDate: Option[DateTime] = None, dayInWeek: Option[String] = None, muteUntil: Option[DateTime] = None, displayToPublic: Option[Int] = Some(1), productType: Option[Int] = None)

  /** Entity class storing rows of table ItemImage
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None)
   *  @param filename Database column filename SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param itemId Database column item_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class ItemImageRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, displayPosition: Option[Int] = None, filename: Option[String] = None, itemId: Option[String] = None)

  /** Entity class storing rows of table ItemSubitem
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param itemId Database column item_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param subitemId Database column subitem_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None) */
  case class ItemSubitemRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, itemId: Option[String] = None, subitemId: Option[String] = None, displayPosition: Option[Int] = None)

  /** Entity class storing rows of table Subitem
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None)
   *  @param displayToPublic Database column display_to_public SqlType(INT), Default(None)
   *  @param minimumQuantity Database column minimum_quantity SqlType(INT), Default(None)
   *  @param maximumQuantity Database column maximum_quantity SqlType(INT), Default(None)
   *  @param defaultSubitemVariantId Database column default_subitem_variant_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param selectableOnce Database column selectable_once SqlType(INT), Default(Some(0)) */
  case class SubitemRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, displayPosition: Option[Int] = None, displayToPublic: Option[Int] = None, minimumQuantity: Option[Int] = None, maximumQuantity: Option[Int] = None, defaultSubitemVariantId: Option[String] = None, description: Option[String] = None, menuId: Option[String] = None, selectableOnce: Option[Int] = Some(0))

  /** Entity class storing rows of table SubitemVariant
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param variantId Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param subitemId Database column subitem_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param priceUnderMinimumSelection Database column price_under_minimum_selection SqlType(FLOAT), Default(None)
   *  @param preselect Database column preselect SqlType(INT), Default(Some(0))
   *  @param displayPosition Database column display_position SqlType(INT), Default(Some(0)) */
  case class SubitemVariantRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, variantId: Option[String] = None, subitemId: Option[String] = None, priceUnderMinimumSelection: Option[Float] = None, preselect: Option[Int] = Some(0), displayPosition: Option[Int] = Some(0))

  /** Entity class storing rows of table Variant
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param variant1 Database column variant1 SqlType(TEXT), Default(None)
   *  @param variant2 Database column variant2 SqlType(TEXT), Default(None)
   *  @param variant3 Database column variant3 SqlType(TEXT), Default(None)
   *  @param itemId Database column item_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param price Database column price SqlType(FLOAT), Default(None)
   *  @param belongsToCompositeItem Database column belongs_to_composite_item SqlType(INT), Default(Some(0))
   *  @param variantName Database column variant_name SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None) */
  case class VariantRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, variant1: Option[String] = None, variant2: Option[String] = None, variant3: Option[String] = None, itemId: Option[String] = None, price: Option[Float] = None, belongsToCompositeItem: Option[Int] = Some(0), variantName: Option[String] = None, displayPosition: Option[Int] = None)
