package models.database

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
  import org.joda.time.DateTime
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Account.schema, AccountPermission.schema, Address.schema, Category.schema, CategoryItem.schema, Changes.schema, Customer.schema, CustomPaymentRate.schema, DeliveryLog.schema, DeliveryPartnerAllocation.schema, DeliveryRequest.schema, DeliveryZone.schema, DevicePushNotificationStatus.schema, EmailBlacklist.schema, EmailLog.schema, FaxBlacklist.schema, FaxLog.schema, Ff4jFeatures.schema, Ff4jRoles.schema, GlobalPaymentRate.schema, Ingredient.schema, Item.schema, ItemImage.schema, ItemSubitem.schema, LargeOrderLeadTime.schema, LastOrderNumberTracker.schema, Localization.schema, LocalizationExternalAccess.schema, Location.schema, Menu.schema, MenuNotification.schema, NotificationTemplate.schema, OrderDiscount.schema, OrderForm.schema, OrderIngredient.schema, OrderItem.schema, OrderPromotionv3.schema, OrderTag.schema, OrderTaxAndCharge.schema, Partner.schema, PartnerRequest.schema, PartnerResponse.schema, Payment.schema, PaymentOption.schema, PaymentRateHistory.schema, Permission.schema, PersistentLogins.schema, Promotion.schema, Promotionv3.schema, ShoppingCartScript.schema, ShoppingCartTracker.schema, SmsBlacklist.schema, SmsLog.schema, Store.schema, StoreOrder.schema, StoreOrderLog.schema, StoreOrderPaymentDetails.schema, StoreOrderPaymentDetailsHistory.schema, StoreVariant.schema, Subitem.schema, SubitemVariant.schema, TaxAndCharge.schema, ThirdPartyTracker.schema, TimeOption.schema, TimeOptionBooking.schema, Token.schema, Tracker.schema, User.schema, UserNotification.schema, UserPermission.schema, UserStore.schema, Variant.schema, VariantIngredient.schema, VariantSubitem.schema, Version.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Account
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(Some())
   *  @param maxUsers Database column max_users SqlType(INT), Default(None)
   *  @param maxMenus Database column max_menus SqlType(INT), Default(Some(1))
   *  @param maxStores Database column max_stores SqlType(INT), Default(Some(1))
   *  @param startDate Database column start_date SqlType(DATETIME), Default(None)
   *  @param endDate Database column end_date SqlType(DATETIME), Default(None)
   *  @param gmtOffset Database column gmt_offset SqlType(FLOAT), Default(Some(8.0))
   *  @param activatedStartDate Database column activated_start_date SqlType(DATETIME), Default(None)
   *  @param freeCartStartDate Database column free_cart_start_date SqlType(DATETIME), Default(None)
   *  @param country Database column country SqlType(VARCHAR), Length(255,true), Default(Some(Singapore)) */
  case class AccountRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, name: Option[String] = Some(""), maxUsers: Option[Int] = None, maxMenus: Option[Int] = Some(1), maxStores: Option[Int] = Some(1), startDate: Option[DateTime] = None, endDate: Option[DateTime] = None, gmtOffset: Option[Float] = Some(8.0F), activatedStartDate: Option[DateTime] = None, freeCartStartDate: Option[DateTime] = None, country: Option[String] = Some("Singapore"))
  /** GetResult implicit for fetching AccountRow objects using plain SQL queries */
  implicit def GetResultAccountRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[AccountRow] = GR{
    prs => import prs._
    AccountRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[Float], <<?[DateTime], <<?[DateTime], <<?[String]))
  }
  /** Table description of table account. Objects of this class serve as prototypes for rows in queries. */
  class Account(_tableTag: Tag) extends Table[AccountRow](_tableTag, "account") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, name, maxUsers, maxMenus, maxStores, startDate, endDate, gmtOffset, activatedStartDate, freeCartStartDate, country) <> (AccountRow.tupled, AccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, name, maxUsers, maxMenus, maxStores, startDate, endDate, gmtOffset, activatedStartDate, freeCartStartDate, country).shaped.<>({r=>import r._; _1.map(_=> AccountRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(Some()) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(Some("")))
    /** Database column max_users SqlType(INT), Default(None) */
    val maxUsers: Rep[Option[Int]] = column[Option[Int]]("max_users", O.Default(None))
    /** Database column max_menus SqlType(INT), Default(Some(1)) */
    val maxMenus: Rep[Option[Int]] = column[Option[Int]]("max_menus", O.Default(Some(1)))
    /** Database column max_stores SqlType(INT), Default(Some(1)) */
    val maxStores: Rep[Option[Int]] = column[Option[Int]]("max_stores", O.Default(Some(1)))
    /** Database column start_date SqlType(DATETIME), Default(None) */
    val startDate: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date", O.Default(None))
    /** Database column end_date SqlType(DATETIME), Default(None) */
    val endDate: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date", O.Default(None))
    /** Database column gmt_offset SqlType(FLOAT), Default(Some(8.0)) */
    val gmtOffset: Rep[Option[Float]] = column[Option[Float]]("gmt_offset", O.Default(Some(8.0F)))
    /** Database column activated_start_date SqlType(DATETIME), Default(None) */
    val activatedStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("activated_start_date", O.Default(None))
    /** Database column free_cart_start_date SqlType(DATETIME), Default(None) */
    val freeCartStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("free_cart_start_date", O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(Some(Singapore)) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(Some("Singapore")))
  }
  /** Collection-like TableQuery object for table Account */
  lazy val Account = new TableQuery(tag => new Account(tag))

  /** Entity class storing rows of table AccountPermission
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param accountId Database column account_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param permissionId Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param version Database column version SqlType(INT), Default(None) */
  case class AccountPermissionRow(id: String, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, accountId: Option[String] = None, permissionId: Option[String] = None, version: Option[Int] = None)
  /** GetResult implicit for fetching AccountPermissionRow objects using plain SQL queries */
  implicit def GetResultAccountPermissionRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[DateTime]], e3: GR[Option[Int]]): GR[AccountPermissionRow] = GR{
    prs => import prs._
    AccountPermissionRow.tupled((<<[String], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table account_permission. Objects of this class serve as prototypes for rows in queries. */
  class AccountPermission(_tableTag: Tag) extends Table[AccountPermissionRow](_tableTag, "account_permission") {
    def * = (id, createdBy, updatedBy, createdOn, updatedOn, accountId, permissionId, version) <> (AccountPermissionRow.tupled, AccountPermissionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdBy, updatedBy, createdOn, updatedOn, accountId, permissionId, version).shaped.<>({r=>import r._; _1.map(_=> AccountPermissionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val permissionId: Rep[Option[String]] = column[Option[String]]("permission_id", O.Length(32,varying=true), O.Default(None))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))

    /** Foreign key referencing Account (database name fk_account_permission_1) */
    lazy val accountFk = foreignKey("fk_account_permission_1", accountId, Account)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Permission (database name fk_account_permission_2) */
    lazy val permissionFk = foreignKey("fk_account_permission_2", permissionId, Permission)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AccountPermission */
  lazy val AccountPermission = new TableQuery(tag => new AccountPermission(tag))

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

    /** Foreign key referencing Customer (database name fk_customer_id) */
    lazy val customerFk = foreignKey("fk_customer_id", customerId, Customer)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Address */
  lazy val Address = new TableQuery(tag => new Address(tag))

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

    /** Foreign key referencing Menu (database name fk_tag_1) */
    lazy val menuFk = foreignKey("fk_tag_1", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Category */
  lazy val Category = new TableQuery(tag => new Category(tag))

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

  /** Entity class storing rows of table Changes
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param deltas Database column deltas SqlType(LONGBLOB), Default(None)
   *  @param referenceId Database column reference_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class ChangesRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, version: Option[Int] = None, deltas: Option[java.sql.Blob] = None, referenceId: Option[String] = None)
  /** GetResult implicit for fetching ChangesRow objects using plain SQL queries */
  implicit def GetResultChangesRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[java.sql.Blob]]): GR[ChangesRow] = GR{
    prs => import prs._
    ChangesRow.tupled((<<[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Blob], <<?[String]))
  }
  /** Table description of table changes. Objects of this class serve as prototypes for rows in queries. */
  class Changes(_tableTag: Tag) extends Table[ChangesRow](_tableTag, "changes") {
    def * = (id, createdOn, updatedOn, createdBy, updatedBy, version, deltas, referenceId) <> (ChangesRow.tupled, ChangesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdOn, updatedOn, createdBy, updatedBy, version, deltas, referenceId).shaped.<>({r=>import r._; _1.map(_=> ChangesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column deltas SqlType(LONGBLOB), Default(None) */
    val deltas: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("deltas", O.Default(None))
    /** Database column reference_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val referenceId: Rep[Option[String]] = column[Option[String]]("reference_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Changes */
  lazy val Changes = new TableQuery(tag => new Changes(tag))

  /** Row type of table Customer */
  type CustomerRow = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[Int],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for CustomerRow providing default values if available in the database schema. */
  def CustomerRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, password: Option[String] = None, lastName: Option[String] = None, firstName: Option[String] = None, phone: Option[String] = None, email: Option[String] = None, address: Option[String] = None, addressTwo: Option[String] = None, city: Option[String] = None, state: Option[String] = None, postal: Option[String] = None, country: Option[String] = None, latitude: Option[Float] = None, longitude: Option[Float] = None, resetPasswordKey: Option[String] = None, accountActivated: Option[Int] = None, receiveEmail: Option[Int] = None, resetPasswordExpiryDate: Option[DateTime] = None, accountId: Option[String] = None, organisationName: Option[String] = None, billingAddress: Option[String] = None, billingAddressTwo: Option[String] = None, billingCity: Option[String] = None, billingCountry: Option[String] = None, billingState: Option[String] = None, billingPostal: Option[String] = None, receiveNotification: Option[Int] = Some(1), preferredDeliveryAddressId: Option[String] = None, preferredBillingAddressId: Option[String] = None, pin: Option[String] = None, pinExpiryDate: Option[DateTime] = None, isBanned: Option[Int] = Some(0), facebookId: Option[String] = None): CustomerRow = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: password :: lastName :: firstName :: phone :: email :: address :: addressTwo :: city :: state :: postal :: country :: latitude :: longitude :: resetPasswordKey :: accountActivated :: receiveEmail :: resetPasswordExpiryDate :: accountId :: organisationName :: billingAddress :: billingAddressTwo :: billingCity :: billingCountry :: billingState :: billingPostal :: receiveNotification :: preferredDeliveryAddressId :: preferredBillingAddressId :: pin :: pinExpiryDate :: isBanned :: facebookId :: HNil
  }
  /** GetResult implicit for fetching CustomerRow objects using plain SQL queries */
  implicit def GetResultCustomerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[CustomerRow] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[Int] :: <<?[String] :: HNil
  }
  /** Table description of table customer. Objects of this class serve as prototypes for rows in queries. */
  class Customer(_tableTag: Tag) extends Table[CustomerRow](_tableTag, "customer") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: password :: lastName :: firstName :: phone :: email :: address :: addressTwo :: city :: state :: postal :: country :: latitude :: longitude :: resetPasswordKey :: accountActivated :: receiveEmail :: resetPasswordExpiryDate :: accountId :: organisationName :: billingAddress :: billingAddressTwo :: billingCity :: billingCountry :: billingState :: billingPostal :: receiveNotification :: preferredDeliveryAddressId :: preferredBillingAddressId :: pin :: pinExpiryDate :: isBanned :: facebookId :: HNil

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
    /** Database column password SqlType(VARCHAR), Length(255,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(255,varying=true), O.Default(None))
    /** Database column last_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("last_name", O.Length(255,varying=true), O.Default(None))
    /** Database column first_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val firstName: Rep[Option[String]] = column[Option[String]]("first_name", O.Length(255,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(20,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
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
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(None))
    /** Database column latitude SqlType(FLOAT), Default(None) */
    val latitude: Rep[Option[Float]] = column[Option[Float]]("latitude", O.Default(None))
    /** Database column longitude SqlType(FLOAT), Default(None) */
    val longitude: Rep[Option[Float]] = column[Option[Float]]("longitude", O.Default(None))
    /** Database column reset_password_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val resetPasswordKey: Rep[Option[String]] = column[Option[String]]("reset_password_key", O.Length(45,varying=true), O.Default(None))
    /** Database column account_activated SqlType(INT), Default(None) */
    val accountActivated: Rep[Option[Int]] = column[Option[Int]]("account_activated", O.Default(None))
    /** Database column receive_email SqlType(INT), Default(None) */
    val receiveEmail: Rep[Option[Int]] = column[Option[Int]]("receive_email", O.Default(None))
    /** Database column reset_password_expiry_date SqlType(DATETIME), Default(None) */
    val resetPasswordExpiryDate: Rep[Option[DateTime]] = column[Option[DateTime]]("reset_password_expiry_date", O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column organisation_name SqlType(TEXT), Default(None) */
    val organisationName: Rep[Option[String]] = column[Option[String]]("organisation_name", O.Default(None))
    /** Database column billing_address SqlType(TEXT), Default(None) */
    val billingAddress: Rep[Option[String]] = column[Option[String]]("billing_address", O.Default(None))
    /** Database column billing_address_two SqlType(TEXT), Default(None) */
    val billingAddressTwo: Rep[Option[String]] = column[Option[String]]("billing_address_two", O.Default(None))
    /** Database column billing_city SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingCity: Rep[Option[String]] = column[Option[String]]("billing_city", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_country SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingCountry: Rep[Option[String]] = column[Option[String]]("billing_country", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_state SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingState: Rep[Option[String]] = column[Option[String]]("billing_state", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_postal SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingPostal: Rep[Option[String]] = column[Option[String]]("billing_postal", O.Length(255,varying=true), O.Default(None))
    /** Database column receive_notification SqlType(INT), Default(Some(1)) */
    val receiveNotification: Rep[Option[Int]] = column[Option[Int]]("receive_notification", O.Default(Some(1)))
    /** Database column preferred_delivery_address_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val preferredDeliveryAddressId: Rep[Option[String]] = column[Option[String]]("preferred_delivery_address_id", O.Length(32,varying=true), O.Default(None))
    /** Database column preferred_billing_address_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val preferredBillingAddressId: Rep[Option[String]] = column[Option[String]]("preferred_billing_address_id", O.Length(32,varying=true), O.Default(None))
    /** Database column pin SqlType(VARCHAR), Length(6,true), Default(None) */
    val pin: Rep[Option[String]] = column[Option[String]]("pin", O.Length(6,varying=true), O.Default(None))
    /** Database column pin_expiry_date SqlType(DATETIME), Default(None) */
    val pinExpiryDate: Rep[Option[DateTime]] = column[Option[DateTime]]("pin_expiry_date", O.Default(None))
    /** Database column is_banned SqlType(INT), Default(Some(0)) */
    val isBanned: Rep[Option[Int]] = column[Option[Int]]("is_banned", O.Default(Some(0)))
    /** Database column facebook_id SqlType(VARCHAR), Length(45,true), Default(None) */
    val facebookId: Rep[Option[String]] = column[Option[String]]("facebook_id", O.Length(45,varying=true), O.Default(None))

    /** Foreign key referencing Account (database name fk_customer_1) */
    lazy val accountFk = foreignKey("fk_customer_1", accountId :: HNil, Account)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Address (database name fk_preferred_delivery_address_id) */
    lazy val addressFk = foreignKey("fk_preferred_delivery_address_id", preferredDeliveryAddressId :: HNil, Address)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Customer */
  lazy val Customer = new TableQuery(tag => new Customer(tag))

  /** Entity class storing rows of table CustomPaymentRate
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param percentCut Database column percent_cut SqlType(FLOAT), Default(None)
   *  @param dollarCut Database column dollar_cut SqlType(FLOAT), Default(None)
   *  @param paymentOptionId Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentRateType Database column payment_rate_type SqlType(INT), Default(None)
   *  @param currentPaymentRateHistoryId Database column current_payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class CustomPaymentRateRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, percentCut: Option[Float] = None, dollarCut: Option[Float] = None, paymentOptionId: Option[String] = None, paymentRateType: Option[Int] = None, currentPaymentRateHistoryId: Option[String] = None)
  /** GetResult implicit for fetching CustomPaymentRateRow objects using plain SQL queries */
  implicit def GetResultCustomPaymentRateRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[CustomPaymentRateRow] = GR{
    prs => import prs._
    CustomPaymentRateRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Float], <<?[Float], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table custom_payment_rate. Objects of this class serve as prototypes for rows in queries. */
  class CustomPaymentRate(_tableTag: Tag) extends Table[CustomPaymentRateRow](_tableTag, "custom_payment_rate") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, percentCut, dollarCut, paymentOptionId, paymentRateType, currentPaymentRateHistoryId) <> (CustomPaymentRateRow.tupled, CustomPaymentRateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, percentCut, dollarCut, paymentOptionId, paymentRateType, currentPaymentRateHistoryId).shaped.<>({r=>import r._; _1.map(_=> CustomPaymentRateRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column percent_cut SqlType(FLOAT), Default(None) */
    val percentCut: Rep[Option[Float]] = column[Option[Float]]("percent_cut", O.Default(None))
    /** Database column dollar_cut SqlType(FLOAT), Default(None) */
    val dollarCut: Rep[Option[Float]] = column[Option[Float]]("dollar_cut", O.Default(None))
    /** Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentOptionId: Rep[Option[String]] = column[Option[String]]("payment_option_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_rate_type SqlType(INT), Default(None) */
    val paymentRateType: Rep[Option[Int]] = column[Option[Int]]("payment_rate_type", O.Default(None))
    /** Database column current_payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val currentPaymentRateHistoryId: Rep[Option[String]] = column[Option[String]]("current_payment_rate_history_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing PaymentOption (database name pr_fk_2) */
    lazy val paymentOptionFk = foreignKey("pr_fk_2", paymentOptionId, PaymentOption)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table CustomPaymentRate */
  lazy val CustomPaymentRate = new TableQuery(tag => new CustomPaymentRate(tag))

  /** Entity class storing rows of table DeliveryLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param log Database column log SqlType(TEXT), Default(None)
   *  @param deliveryRequestId Database column delivery_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class DeliveryLogRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, log: Option[String] = None, deliveryRequestId: Option[String] = None)
  /** GetResult implicit for fetching DeliveryLogRow objects using plain SQL queries */
  implicit def GetResultDeliveryLogRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[DeliveryLogRow] = GR{
    prs => import prs._
    DeliveryLogRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String]))
  }
  /** Table description of table delivery_log. Objects of this class serve as prototypes for rows in queries. */
  class DeliveryLog(_tableTag: Tag) extends Table[DeliveryLogRow](_tableTag, "delivery_log") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, log, deliveryRequestId) <> (DeliveryLogRow.tupled, DeliveryLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, log, deliveryRequestId).shaped.<>({r=>import r._; _1.map(_=> DeliveryLogRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column log SqlType(TEXT), Default(None) */
    val log: Rep[Option[String]] = column[Option[String]]("log", O.Default(None))
    /** Database column delivery_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val deliveryRequestId: Rep[Option[String]] = column[Option[String]]("delivery_request_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table DeliveryLog */
  lazy val DeliveryLog = new TableQuery(tag => new DeliveryLog(tag))

  /** Entity class storing rows of table DeliveryPartnerAllocation
   *  @param id Database column id SqlType(VARCHAR), Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param partnerId Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param allocatedId Database column allocated_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param strategyType Database column strategy_type SqlType(SMALLINT), Default(Some(0))
   *  @param deliveryPartnerAccessKey Database column delivery_partner_access_key SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param deliveryPartnerSecretKey Database column delivery_partner_secret_key SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param deliveryContactName Database column delivery_contact_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param deliveryContactEmail Database column delivery_contact_email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param deliveryContactPhone Database column delivery_contact_phone SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param autoDeliveryLimit Database column auto_delivery_limit SqlType(FLOAT), Default(None)
   *  @param enableAutoDelivery Database column enable_auto_delivery SqlType(INT), Default(None)
   *  @param comment Database column comment SqlType(TEXT), Default(None) */
  case class DeliveryPartnerAllocationRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, partnerId: Option[String] = None, allocatedId: Option[String] = None, strategyType: Option[Short] = Some(0), deliveryPartnerAccessKey: Option[String] = None, deliveryPartnerSecretKey: Option[String] = None, deliveryContactName: Option[String] = None, deliveryContactEmail: Option[String] = None, deliveryContactPhone: Option[String] = None, autoDeliveryLimit: Option[Float] = None, enableAutoDelivery: Option[Int] = None, comment: Option[String] = None)
  /** GetResult implicit for fetching DeliveryPartnerAllocationRow objects using plain SQL queries */
  implicit def GetResultDeliveryPartnerAllocationRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Short]], e5: GR[Option[Float]]): GR[DeliveryPartnerAllocationRow] = GR{
    prs => import prs._
    DeliveryPartnerAllocationRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Short], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Int], <<?[String]))
  }
  /** Table description of table delivery_partner_allocation. Objects of this class serve as prototypes for rows in queries. */
  class DeliveryPartnerAllocation(_tableTag: Tag) extends Table[DeliveryPartnerAllocationRow](_tableTag, "delivery_partner_allocation") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, partnerId, allocatedId, strategyType, deliveryPartnerAccessKey, deliveryPartnerSecretKey, deliveryContactName, deliveryContactEmail, deliveryContactPhone, autoDeliveryLimit, enableAutoDelivery, comment) <> (DeliveryPartnerAllocationRow.tupled, DeliveryPartnerAllocationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, partnerId, allocatedId, strategyType, deliveryPartnerAccessKey, deliveryPartnerSecretKey, deliveryContactName, deliveryContactEmail, deliveryContactPhone, autoDeliveryLimit, enableAutoDelivery, comment).shaped.<>({r=>import r._; _1.map(_=> DeliveryPartnerAllocationRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), Length(32,true) */
    val id: Rep[String] = column[String]("id", O.Length(32,varying=true))
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
    /** Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val partnerId: Rep[Option[String]] = column[Option[String]]("partner_id", O.Length(32,varying=true), O.Default(None))
    /** Database column allocated_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val allocatedId: Rep[Option[String]] = column[Option[String]]("allocated_id", O.Length(32,varying=true), O.Default(None))
    /** Database column strategy_type SqlType(SMALLINT), Default(Some(0)) */
    val strategyType: Rep[Option[Short]] = column[Option[Short]]("strategy_type", O.Default(Some(0)))
    /** Database column delivery_partner_access_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryPartnerAccessKey: Rep[Option[String]] = column[Option[String]]("delivery_partner_access_key", O.Length(45,varying=true), O.Default(None))
    /** Database column delivery_partner_secret_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryPartnerSecretKey: Rep[Option[String]] = column[Option[String]]("delivery_partner_secret_key", O.Length(45,varying=true), O.Default(None))
    /** Database column delivery_contact_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val deliveryContactName: Rep[Option[String]] = column[Option[String]]("delivery_contact_name", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_contact_email SqlType(VARCHAR), Length(255,true), Default(None) */
    val deliveryContactEmail: Rep[Option[String]] = column[Option[String]]("delivery_contact_email", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_contact_phone SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryContactPhone: Rep[Option[String]] = column[Option[String]]("delivery_contact_phone", O.Length(45,varying=true), O.Default(None))
    /** Database column auto_delivery_limit SqlType(FLOAT), Default(None) */
    val autoDeliveryLimit: Rep[Option[Float]] = column[Option[Float]]("auto_delivery_limit", O.Default(None))
    /** Database column enable_auto_delivery SqlType(INT), Default(None) */
    val enableAutoDelivery: Rep[Option[Int]] = column[Option[Int]]("enable_auto_delivery", O.Default(None))
    /** Database column comment SqlType(TEXT), Default(None) */
    val comment: Rep[Option[String]] = column[Option[String]]("comment", O.Default(None))

    /** Foreign key referencing Partner (database name fk_dpa_1) */
    lazy val partnerFk = foreignKey("fk_dpa_1", partnerId, Partner)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (allocatedId) (database name fk_dpa_2_idx) */
    val index1 = index("fk_dpa_2_idx", allocatedId, unique=true)
  }
  /** Collection-like TableQuery object for table DeliveryPartnerAllocation */
  lazy val DeliveryPartnerAllocation = new TableQuery(tag => new DeliveryPartnerAllocation(tag))

  /** Entity class storing rows of table DeliveryRequest
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param comment Database column comment SqlType(TEXT), Default(None)
   *  @param cashCollection Database column cash_collection SqlType(INT), Default(None)
   *  @param transport Database column transport SqlType(INT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param selectedPartnerId Database column selected_partner_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param status Database column status SqlType(INT), Default(None)
   *  @param pickupDate Database column pickup_date SqlType(DATETIME), Default(None)
   *  @param country Database column country SqlType(INT), Default(None)
   *  @param requestNumber Database column request_number SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param requestErrorMessage Database column request_error_message SqlType(VARCHAR), Length(255,true), Default(None) */
  case class DeliveryRequestRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, comment: Option[String] = None, cashCollection: Option[Int] = None, transport: Option[Int] = None, storeOrderId: Option[String] = None, selectedPartnerId: Option[String] = None, status: Option[Int] = None, pickupDate: Option[DateTime] = None, country: Option[Int] = None, requestNumber: Option[String] = None, requestErrorMessage: Option[String] = None)
  /** GetResult implicit for fetching DeliveryRequestRow objects using plain SQL queries */
  implicit def GetResultDeliveryRequestRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[DeliveryRequestRow] = GR{
    prs => import prs._
    DeliveryRequestRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[DateTime], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table delivery_request. Objects of this class serve as prototypes for rows in queries. */
  class DeliveryRequest(_tableTag: Tag) extends Table[DeliveryRequestRow](_tableTag, "delivery_request") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, comment, cashCollection, transport, storeOrderId, selectedPartnerId, status, pickupDate, country, requestNumber, requestErrorMessage) <> (DeliveryRequestRow.tupled, DeliveryRequestRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, comment, cashCollection, transport, storeOrderId, selectedPartnerId, status, pickupDate, country, requestNumber, requestErrorMessage).shaped.<>({r=>import r._; _1.map(_=> DeliveryRequestRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column comment SqlType(TEXT), Default(None) */
    val comment: Rep[Option[String]] = column[Option[String]]("comment", O.Default(None))
    /** Database column cash_collection SqlType(INT), Default(None) */
    val cashCollection: Rep[Option[Int]] = column[Option[Int]]("cash_collection", O.Default(None))
    /** Database column transport SqlType(INT), Default(None) */
    val transport: Rep[Option[Int]] = column[Option[Int]]("transport", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column selected_partner_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val selectedPartnerId: Rep[Option[String]] = column[Option[String]]("selected_partner_id", O.Length(32,varying=true), O.Default(None))
    /** Database column status SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
    /** Database column pickup_date SqlType(DATETIME), Default(None) */
    val pickupDate: Rep[Option[DateTime]] = column[Option[DateTime]]("pickup_date", O.Default(None))
    /** Database column country SqlType(INT), Default(None) */
    val country: Rep[Option[Int]] = column[Option[Int]]("country", O.Default(None))
    /** Database column request_number SqlType(VARCHAR), Length(255,true), Default(None) */
    val requestNumber: Rep[Option[String]] = column[Option[String]]("request_number", O.Length(255,varying=true), O.Default(None))
    /** Database column request_error_message SqlType(VARCHAR), Length(255,true), Default(None) */
    val requestErrorMessage: Rep[Option[String]] = column[Option[String]]("request_error_message", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table DeliveryRequest */
  lazy val DeliveryRequest = new TableQuery(tag => new DeliveryRequest(tag))

  /** Entity class storing rows of table DeliveryZone
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param zoneCoordinate Database column zone_coordinate SqlType(TEXT), Default(None)
   *  @param country Database column country SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param partnerId Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class DeliveryZoneRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, name: Option[String] = None, zoneCoordinate: Option[String] = None, country: Option[String] = None, `type`: Option[Int] = None, partnerId: Option[String] = None)
  /** GetResult implicit for fetching DeliveryZoneRow objects using plain SQL queries */
  implicit def GetResultDeliveryZoneRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[DeliveryZoneRow] = GR{
    prs => import prs._
    DeliveryZoneRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table delivery_zone. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class DeliveryZone(_tableTag: Tag) extends Table[DeliveryZoneRow](_tableTag, "delivery_zone") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, name, zoneCoordinate, country, `type`, partnerId) <> (DeliveryZoneRow.tupled, DeliveryZoneRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, name, zoneCoordinate, country, `type`, partnerId).shaped.<>({r=>import r._; _1.map(_=> DeliveryZoneRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column zone_coordinate SqlType(TEXT), Default(None) */
    val zoneCoordinate: Rep[Option[String]] = column[Option[String]]("zone_coordinate", O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(None))
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val partnerId: Rep[Option[String]] = column[Option[String]]("partner_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Partner (database name fk_delivery_zone_partner_partner_id) */
    lazy val partnerFk = foreignKey("fk_delivery_zone_partner_partner_id", partnerId, Partner)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table DeliveryZone */
  lazy val DeliveryZone = new TableQuery(tag => new DeliveryZone(tag))

  /** Entity class storing rows of table DevicePushNotificationStatus
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default()
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param deviceToken Database column device_token SqlType(TEXT), Default(None)
   *  @param sentTime Database column sent_time SqlType(BIGINT), Default(None)
   *  @param notificationEvent Database column notification_event SqlType(INT), Default(None) */
  case class DevicePushNotificationStatusRow(id: String = "", version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, deviceToken: Option[String] = None, sentTime: Option[Long] = None, notificationEvent: Option[Int] = None)
  /** GetResult implicit for fetching DevicePushNotificationStatusRow objects using plain SQL queries */
  implicit def GetResultDevicePushNotificationStatusRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Long]]): GR[DevicePushNotificationStatusRow] = GR{
    prs => import prs._
    DevicePushNotificationStatusRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Long], <<?[Int]))
  }
  /** Table description of table device_push_notification_status. Objects of this class serve as prototypes for rows in queries. */
  class DevicePushNotificationStatus(_tableTag: Tag) extends Table[DevicePushNotificationStatusRow](_tableTag, "device_push_notification_status") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, deviceToken, sentTime, notificationEvent) <> (DevicePushNotificationStatusRow.tupled, DevicePushNotificationStatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, deviceToken, sentTime, notificationEvent).shaped.<>({r=>import r._; _1.map(_=> DevicePushNotificationStatusRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default() */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true), O.Default(""))
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
    /** Database column device_token SqlType(TEXT), Default(None) */
    val deviceToken: Rep[Option[String]] = column[Option[String]]("device_token", O.Default(None))
    /** Database column sent_time SqlType(BIGINT), Default(None) */
    val sentTime: Rep[Option[Long]] = column[Option[Long]]("sent_time", O.Default(None))
    /** Database column notification_event SqlType(INT), Default(None) */
    val notificationEvent: Rep[Option[Int]] = column[Option[Int]]("notification_event", O.Default(None))
  }
  /** Collection-like TableQuery object for table DevicePushNotificationStatus */
  lazy val DevicePushNotificationStatus = new TableQuery(tag => new DevicePushNotificationStatus(tag))

  /** Entity class storing rows of table EmailBlacklist
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param notificationType Database column notification_type SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param messageId Database column message_id SqlType(TEXT), Default(None)
   *  @param mailId Database column mail_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param errorCause Database column error_cause SqlType(TEXT), Default(None)
   *  @param storeOrder Database column store_order SqlType(VARCHAR), Length(32,true), Default(None) */
  case class EmailBlacklistRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, notificationType: Option[String] = None, messageId: Option[String] = None, mailId: Option[String] = None, errorCause: Option[String] = None, storeOrder: Option[String] = None)
  /** GetResult implicit for fetching EmailBlacklistRow objects using plain SQL queries */
  implicit def GetResultEmailBlacklistRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[EmailBlacklistRow] = GR{
    prs => import prs._
    EmailBlacklistRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table email_blacklist. Objects of this class serve as prototypes for rows in queries. */
  class EmailBlacklist(_tableTag: Tag) extends Table[EmailBlacklistRow](_tableTag, "email_blacklist") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, notificationType, messageId, mailId, errorCause, storeOrder) <> (EmailBlacklistRow.tupled, EmailBlacklistRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, notificationType, messageId, mailId, errorCause, storeOrder).shaped.<>({r=>import r._; _1.map(_=> EmailBlacklistRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column notification_type SqlType(VARCHAR), Length(32,true), Default(None) */
    val notificationType: Rep[Option[String]] = column[Option[String]]("notification_type", O.Length(32,varying=true), O.Default(None))
    /** Database column message_id SqlType(TEXT), Default(None) */
    val messageId: Rep[Option[String]] = column[Option[String]]("message_id", O.Default(None))
    /** Database column mail_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val mailId: Rep[Option[String]] = column[Option[String]]("mail_id", O.Length(32,varying=true), O.Default(None))
    /** Database column error_cause SqlType(TEXT), Default(None) */
    val errorCause: Rep[Option[String]] = column[Option[String]]("error_cause", O.Default(None))
    /** Database column store_order SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrder: Rep[Option[String]] = column[Option[String]]("store_order", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table EmailBlacklist */
  lazy val EmailBlacklist = new TableQuery(tag => new EmailBlacklist(tag))

  /** Entity class storing rows of table EmailLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param status Database column status SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param notificationType Database column notification_type SqlType(VARCHAR), Length(100,true), Default(None) */
  case class EmailLogRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, storeOrderId: Option[String] = None, email: Option[String] = None, status: Option[String] = None, notificationType: Option[String] = None)
  /** GetResult implicit for fetching EmailLogRow objects using plain SQL queries */
  implicit def GetResultEmailLogRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[EmailLogRow] = GR{
    prs => import prs._
    EmailLogRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table email_log. Objects of this class serve as prototypes for rows in queries. */
  class EmailLog(_tableTag: Tag) extends Table[EmailLogRow](_tableTag, "email_log") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, menuId, storeOrderId, email, status, notificationType) <> (EmailLogRow.tupled, EmailLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, menuId, storeOrderId, email, status, notificationType).shaped.<>({r=>import r._; _1.map(_=> EmailLogRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(200,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(200,varying=true), O.Default(None))
    /** Database column status SqlType(VARCHAR), Length(45,true), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Length(45,varying=true), O.Default(None))
    /** Database column notification_type SqlType(VARCHAR), Length(100,true), Default(None) */
    val notificationType: Rep[Option[String]] = column[Option[String]]("notification_type", O.Length(100,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table EmailLog */
  lazy val EmailLog = new TableQuery(tag => new EmailLog(tag))

  /** Entity class storing rows of table FaxBlacklist
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default()
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param errorCode Database column error_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param status Database column status SqlType(TEXT), Default(None)
   *  @param messageId Database column message_id SqlType(TEXT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class FaxBlacklistRow(id: String = "", version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, phone: Option[String] = None, errorCode: Option[String] = None, status: Option[String] = None, messageId: Option[String] = None, storeOrderId: Option[String] = None)
  /** GetResult implicit for fetching FaxBlacklistRow objects using plain SQL queries */
  implicit def GetResultFaxBlacklistRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[FaxBlacklistRow] = GR{
    prs => import prs._
    FaxBlacklistRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table fax_blacklist. Objects of this class serve as prototypes for rows in queries. */
  class FaxBlacklist(_tableTag: Tag) extends Table[FaxBlacklistRow](_tableTag, "fax_blacklist") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, phone, errorCode, status, messageId, storeOrderId) <> (FaxBlacklistRow.tupled, FaxBlacklistRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, phone, errorCode, status, messageId, storeOrderId).shaped.<>({r=>import r._; _1.map(_=> FaxBlacklistRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default() */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true), O.Default(""))
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
    /** Database column phone SqlType(VARCHAR), Length(32,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(32,varying=true), O.Default(None))
    /** Database column error_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val errorCode: Rep[Option[String]] = column[Option[String]]("error_code", O.Length(32,varying=true), O.Default(None))
    /** Database column status SqlType(TEXT), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Default(None))
    /** Database column message_id SqlType(TEXT), Default(None) */
    val messageId: Rep[Option[String]] = column[Option[String]]("message_id", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table FaxBlacklist */
  lazy val FaxBlacklist = new TableQuery(tag => new FaxBlacklist(tag))

  /** Entity class storing rows of table FaxLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param accountId Database column account_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param status Database column status SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param isBillable Database column is_billable SqlType(INT), Default(None)
   *  @param messageSid Database column message_sid SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param faxErrorCode Database column fax_error_code SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param currency Database column currency SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param rate Database column rate SqlType(FLOAT), Default(None)
   *  @param debit Database column debit SqlType(FLOAT), Default(None)
   *  @param faxPages Database column fax_pages SqlType(INT), Default(None)
   *  @param failCount Database column fail_count SqlType(INT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class FaxLogRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, version: Option[Int] = None, menuId: Option[String] = None, accountId: Option[String] = None, phone: Option[String] = None, status: Option[String] = None, isBillable: Option[Int] = None, messageSid: Option[String] = None, faxErrorCode: Option[String] = None, currency: Option[String] = None, rate: Option[Float] = None, debit: Option[Float] = None, faxPages: Option[Int] = None, failCount: Option[Int] = None, storeOrderId: Option[String] = None)
  /** GetResult implicit for fetching FaxLogRow objects using plain SQL queries */
  implicit def GetResultFaxLogRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[Float]]): GR[FaxLogRow] = GR{
    prs => import prs._
    FaxLogRow.tupled((<<[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Float], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table fax_log. Objects of this class serve as prototypes for rows in queries. */
  class FaxLog(_tableTag: Tag) extends Table[FaxLogRow](_tableTag, "fax_log") {
    def * = (id, createdOn, updatedOn, createdBy, updatedBy, version, menuId, accountId, phone, status, isBillable, messageSid, faxErrorCode, currency, rate, debit, faxPages, failCount, storeOrderId) <> (FaxLogRow.tupled, FaxLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdOn, updatedOn, createdBy, updatedBy, version, menuId, accountId, phone, status, isBillable, messageSid, faxErrorCode, currency, rate, debit, faxPages, failCount, storeOrderId).shaped.<>({r=>import r._; _1.map(_=> FaxLogRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(20,varying=true), O.Default(None))
    /** Database column status SqlType(VARCHAR), Length(255,true), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Length(255,varying=true), O.Default(None))
    /** Database column is_billable SqlType(INT), Default(None) */
    val isBillable: Rep[Option[Int]] = column[Option[Int]]("is_billable", O.Default(None))
    /** Database column message_sid SqlType(VARCHAR), Length(45,true), Default(None) */
    val messageSid: Rep[Option[String]] = column[Option[String]]("message_sid", O.Length(45,varying=true), O.Default(None))
    /** Database column fax_error_code SqlType(VARCHAR), Length(255,true), Default(None) */
    val faxErrorCode: Rep[Option[String]] = column[Option[String]]("fax_error_code", O.Length(255,varying=true), O.Default(None))
    /** Database column currency SqlType(VARCHAR), Length(255,true), Default(None) */
    val currency: Rep[Option[String]] = column[Option[String]]("currency", O.Length(255,varying=true), O.Default(None))
    /** Database column rate SqlType(FLOAT), Default(None) */
    val rate: Rep[Option[Float]] = column[Option[Float]]("rate", O.Default(None))
    /** Database column debit SqlType(FLOAT), Default(None) */
    val debit: Rep[Option[Float]] = column[Option[Float]]("debit", O.Default(None))
    /** Database column fax_pages SqlType(INT), Default(None) */
    val faxPages: Rep[Option[Int]] = column[Option[Int]]("fax_pages", O.Default(None))
    /** Database column fail_count SqlType(INT), Default(None) */
    val failCount: Rep[Option[Int]] = column[Option[Int]]("fail_count", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table FaxLog */
  lazy val FaxLog = new TableQuery(tag => new FaxLog(tag))

  /** Entity class storing rows of table Ff4jFeatures
   *  @param featUid Database column FEAT_UID SqlType(VARCHAR), PrimaryKey, Length(100,true), Default()
   *  @param enable Database column ENABLE SqlType(INT)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param strategy Database column STRATEGY SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param expression Database column EXPRESSION SqlType(TEXT), Default(None)
   *  @param groupname Database column GROUPNAME SqlType(VARCHAR), Length(255,true), Default(None) */
  case class Ff4jFeaturesRow(featUid: String = "", enable: Int, description: Option[String] = None, strategy: Option[String] = None, expression: Option[String] = None, groupname: Option[String] = None)
  /** GetResult implicit for fetching Ff4jFeaturesRow objects using plain SQL queries */
  implicit def GetResultFf4jFeaturesRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]]): GR[Ff4jFeaturesRow] = GR{
    prs => import prs._
    Ff4jFeaturesRow.tupled((<<[String], <<[Int], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table FF4J_FEATURES. Objects of this class serve as prototypes for rows in queries. */
  class Ff4jFeatures(_tableTag: Tag) extends Table[Ff4jFeaturesRow](_tableTag, "FF4J_FEATURES") {
    def * = (featUid, enable, description, strategy, expression, groupname) <> (Ff4jFeaturesRow.tupled, Ff4jFeaturesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(featUid), Rep.Some(enable), description, strategy, expression, groupname).shaped.<>({r=>import r._; _1.map(_=> Ff4jFeaturesRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column FEAT_UID SqlType(VARCHAR), PrimaryKey, Length(100,true), Default() */
    val featUid: Rep[String] = column[String]("FEAT_UID", O.PrimaryKey, O.Length(100,varying=true), O.Default(""))
    /** Database column ENABLE SqlType(INT) */
    val enable: Rep[Int] = column[Int]("ENABLE")
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column STRATEGY SqlType(VARCHAR), Length(255,true), Default(None) */
    val strategy: Rep[Option[String]] = column[Option[String]]("STRATEGY", O.Length(255,varying=true), O.Default(None))
    /** Database column EXPRESSION SqlType(TEXT), Default(None) */
    val expression: Rep[Option[String]] = column[Option[String]]("EXPRESSION", O.Default(None))
    /** Database column GROUPNAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val groupname: Rep[Option[String]] = column[Option[String]]("GROUPNAME", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Ff4jFeatures */
  lazy val Ff4jFeatures = new TableQuery(tag => new Ff4jFeatures(tag))

  /** Entity class storing rows of table Ff4jRoles
   *  @param featUid Database column FEAT_UID SqlType(VARCHAR), Length(50,true), Default()
   *  @param roleName Database column ROLE_NAME SqlType(VARCHAR), Length(50,true), Default() */
  case class Ff4jRolesRow(featUid: String = "", roleName: String = "")
  /** GetResult implicit for fetching Ff4jRolesRow objects using plain SQL queries */
  implicit def GetResultFf4jRolesRow(implicit e0: GR[String]): GR[Ff4jRolesRow] = GR{
    prs => import prs._
    Ff4jRolesRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table FF4J_ROLES. Objects of this class serve as prototypes for rows in queries. */
  class Ff4jRoles(_tableTag: Tag) extends Table[Ff4jRolesRow](_tableTag, "FF4J_ROLES") {
    def * = (featUid, roleName) <> (Ff4jRolesRow.tupled, Ff4jRolesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(featUid), Rep.Some(roleName)).shaped.<>({r=>import r._; _1.map(_=> Ff4jRolesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column FEAT_UID SqlType(VARCHAR), Length(50,true), Default() */
    val featUid: Rep[String] = column[String]("FEAT_UID", O.Length(50,varying=true), O.Default(""))
    /** Database column ROLE_NAME SqlType(VARCHAR), Length(50,true), Default() */
    val roleName: Rep[String] = column[String]("ROLE_NAME", O.Length(50,varying=true), O.Default(""))

    /** Primary key of Ff4jRoles (database name FF4J_ROLES_PK) */
    val pk = primaryKey("FF4J_ROLES_PK", (featUid, roleName))
  }
  /** Collection-like TableQuery object for table Ff4jRoles */
  lazy val Ff4jRoles = new TableQuery(tag => new Ff4jRoles(tag))

  /** Entity class storing rows of table GlobalPaymentRate
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param country Database column country SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param percentCut Database column percent_cut SqlType(FLOAT), Default(None)
   *  @param dollarCut Database column dollar_cut SqlType(FLOAT), Default(None)
   *  @param paymentRateType Database column payment_rate_type SqlType(INT), Default(None)
   *  @param paymentId Database column payment_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param currentPaymentRateHistoryId Database column current_payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class GlobalPaymentRateRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, country: Option[String] = None, percentCut: Option[Float] = None, dollarCut: Option[Float] = None, paymentRateType: Option[Int] = None, paymentId: Option[String] = None, currentPaymentRateHistoryId: Option[String] = None)
  /** GetResult implicit for fetching GlobalPaymentRateRow objects using plain SQL queries */
  implicit def GetResultGlobalPaymentRateRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[GlobalPaymentRateRow] = GR{
    prs => import prs._
    GlobalPaymentRateRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Float], <<?[Float], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table global_payment_rate. Objects of this class serve as prototypes for rows in queries. */
  class GlobalPaymentRate(_tableTag: Tag) extends Table[GlobalPaymentRateRow](_tableTag, "global_payment_rate") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, country, percentCut, dollarCut, paymentRateType, paymentId, currentPaymentRateHistoryId) <> (GlobalPaymentRateRow.tupled, GlobalPaymentRateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, country, percentCut, dollarCut, paymentRateType, paymentId, currentPaymentRateHistoryId).shaped.<>({r=>import r._; _1.map(_=> GlobalPaymentRateRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column country SqlType(VARCHAR), Length(200,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(200,varying=true), O.Default(None))
    /** Database column percent_cut SqlType(FLOAT), Default(None) */
    val percentCut: Rep[Option[Float]] = column[Option[Float]]("percent_cut", O.Default(None))
    /** Database column dollar_cut SqlType(FLOAT), Default(None) */
    val dollarCut: Rep[Option[Float]] = column[Option[Float]]("dollar_cut", O.Default(None))
    /** Database column payment_rate_type SqlType(INT), Default(None) */
    val paymentRateType: Rep[Option[Int]] = column[Option[Int]]("payment_rate_type", O.Default(None))
    /** Database column payment_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentId: Rep[Option[String]] = column[Option[String]]("payment_id", O.Length(32,varying=true), O.Default(None))
    /** Database column current_payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val currentPaymentRateHistoryId: Rep[Option[String]] = column[Option[String]]("current_payment_rate_history_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Payment (database name gpr_fk_1) */
    lazy val paymentFk = foreignKey("gpr_fk_1", paymentId, Payment)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table GlobalPaymentRate */
  lazy val GlobalPaymentRate = new TableQuery(tag => new GlobalPaymentRate(tag))

  /** Entity class storing rows of table Ingredient
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param bomNumber Database column bom_number SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column name SqlType(TEXT), Default(None)
   *  @param unitType Database column unit_type SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param department Database column department SqlType(VARCHAR), Length(255,true), Default(None) */
  case class IngredientRow(id: String, version: Option[Int] = None, updatedBy: Option[String] = None, createdBy: Option[String] = None, updatedOn: Option[DateTime] = None, createdOn: Option[DateTime] = None, bomNumber: Option[String] = None, name: Option[String] = None, unitType: Option[String] = None, menuId: Option[String] = None, department: Option[String] = None)
  /** GetResult implicit for fetching IngredientRow objects using plain SQL queries */
  implicit def GetResultIngredientRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[IngredientRow] = GR{
    prs => import prs._
    IngredientRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table ingredient. Objects of this class serve as prototypes for rows in queries. */
  class Ingredient(_tableTag: Tag) extends Table[IngredientRow](_tableTag, "ingredient") {
    def * = (id, version, updatedBy, createdBy, updatedOn, createdOn, bomNumber, name, unitType, menuId, department) <> (IngredientRow.tupled, IngredientRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, updatedBy, createdBy, updatedOn, createdOn, bomNumber, name, unitType, menuId, department).shaped.<>({r=>import r._; _1.map(_=> IngredientRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column bom_number SqlType(VARCHAR), Length(255,true), Default(None) */
    val bomNumber: Rep[Option[String]] = column[Option[String]]("bom_number", O.Length(255,varying=true), O.Default(None))
    /** Database column name SqlType(TEXT), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column unit_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val unitType: Rep[Option[String]] = column[Option[String]]("unit_type", O.Length(255,varying=true), O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column department SqlType(VARCHAR), Length(255,true), Default(None) */
    val department: Rep[Option[String]] = column[Option[String]]("department", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing Menu (database name fk_ingredient_1) */
    lazy val menuFk = foreignKey("fk_ingredient_1", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Ingredient */
  lazy val Ingredient = new TableQuery(tag => new Ingredient(tag))

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

    /** Foreign key referencing Menu (database name fk_item_2) */
    lazy val menuFk = foreignKey("fk_item_2", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrderForm (database name fk_item_1) */
    lazy val orderFormFk = foreignKey("fk_item_1", orderId, OrderForm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Item */
  lazy val Item = new TableQuery(tag => new Item(tag))

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

  /** Entity class storing rows of table LargeOrderLeadTime
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param largeOrderAmount Database column large_order_amount SqlType(FLOAT), Default(None)
   *  @param largeOrderLeadTime Database column large_order_lead_time SqlType(INT), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param isPreventCustomerToCheckout Database column is_prevent_customer_to_checkout SqlType(INT), Default(Some(0))
   *  @param messageToCustomer Database column message_to_customer SqlType(TEXT), Default(None) */
  case class LargeOrderLeadTimeRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeId: Option[String] = None, largeOrderAmount: Option[Float] = None, largeOrderLeadTime: Option[Int] = None, `type`: Option[Int] = None, isPreventCustomerToCheckout: Option[Int] = Some(0), messageToCustomer: Option[String] = None)
  /** GetResult implicit for fetching LargeOrderLeadTimeRow objects using plain SQL queries */
  implicit def GetResultLargeOrderLeadTimeRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[LargeOrderLeadTimeRow] = GR{
    prs => import prs._
    LargeOrderLeadTimeRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Float], <<?[Int], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table large_order_lead_time. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class LargeOrderLeadTime(_tableTag: Tag) extends Table[LargeOrderLeadTimeRow](_tableTag, "large_order_lead_time") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeId, largeOrderAmount, largeOrderLeadTime, `type`, isPreventCustomerToCheckout, messageToCustomer) <> (LargeOrderLeadTimeRow.tupled, LargeOrderLeadTimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeId, largeOrderAmount, largeOrderLeadTime, `type`, isPreventCustomerToCheckout, messageToCustomer).shaped.<>({r=>import r._; _1.map(_=> LargeOrderLeadTimeRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column large_order_amount SqlType(FLOAT), Default(None) */
    val largeOrderAmount: Rep[Option[Float]] = column[Option[Float]]("large_order_amount", O.Default(None))
    /** Database column large_order_lead_time SqlType(INT), Default(None) */
    val largeOrderLeadTime: Rep[Option[Int]] = column[Option[Int]]("large_order_lead_time", O.Default(None))
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column is_prevent_customer_to_checkout SqlType(INT), Default(Some(0)) */
    val isPreventCustomerToCheckout: Rep[Option[Int]] = column[Option[Int]]("is_prevent_customer_to_checkout", O.Default(Some(0)))
    /** Database column message_to_customer SqlType(TEXT), Default(None) */
    val messageToCustomer: Rep[Option[String]] = column[Option[String]]("message_to_customer", O.Default(None))
  }
  /** Collection-like TableQuery object for table LargeOrderLeadTime */
  lazy val LargeOrderLeadTime = new TableQuery(tag => new LargeOrderLeadTime(tag))

  /** Entity class storing rows of table LastOrderNumberTracker
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param lastOrderNumberString Database column last_order_number_string SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastOrderNumberInteger Database column last_order_number_integer SqlType(INT), Default(None) */
  case class LastOrderNumberTrackerRow(id: String, version: Option[Int] = None, updatedOn: Option[DateTime] = None, createdOn: Option[DateTime] = None, updatedBy: Option[String] = None, createdBy: Option[String] = None, menuId: Option[String] = None, lastOrderNumberString: Option[String] = None, lastOrderNumberInteger: Option[Int] = None)
  /** GetResult implicit for fetching LastOrderNumberTrackerRow objects using plain SQL queries */
  implicit def GetResultLastOrderNumberTrackerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[LastOrderNumberTrackerRow] = GR{
    prs => import prs._
    LastOrderNumberTrackerRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table last_order_number_tracker. Objects of this class serve as prototypes for rows in queries. */
  class LastOrderNumberTracker(_tableTag: Tag) extends Table[LastOrderNumberTrackerRow](_tableTag, "last_order_number_tracker") {
    def * = (id, version, updatedOn, createdOn, updatedBy, createdBy, menuId, lastOrderNumberString, lastOrderNumberInteger) <> (LastOrderNumberTrackerRow.tupled, LastOrderNumberTrackerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, updatedOn, createdOn, updatedBy, createdBy, menuId, lastOrderNumberString, lastOrderNumberInteger).shaped.<>({r=>import r._; _1.map(_=> LastOrderNumberTrackerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column last_order_number_string SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastOrderNumberString: Rep[Option[String]] = column[Option[String]]("last_order_number_string", O.Length(255,varying=true), O.Default(None))
    /** Database column last_order_number_integer SqlType(INT), Default(None) */
    val lastOrderNumberInteger: Rep[Option[Int]] = column[Option[Int]]("last_order_number_integer", O.Default(None))
  }
  /** Collection-like TableQuery object for table LastOrderNumberTracker */
  lazy val LastOrderNumberTracker = new TableQuery(tag => new LastOrderNumberTracker(tag))

  /** Entity class storing rows of table Localization
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param locale Database column locale SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param status Database column status SqlType(INT), Default(None) */
  case class LocalizationRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[String] = None, updatedOn: Option[String] = None, locale: Option[String] = None, status: Option[Int] = None)
  /** GetResult implicit for fetching LocalizationRow objects using plain SQL queries */
  implicit def GetResultLocalizationRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[LocalizationRow] = GR{
    prs => import prs._
    LocalizationRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table localization. Objects of this class serve as prototypes for rows in queries. */
  class Localization(_tableTag: Tag) extends Table[LocalizationRow](_tableTag, "localization") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, locale, status) <> (LocalizationRow.tupled, LocalizationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, locale, status).shaped.<>({r=>import r._; _1.map(_=> LocalizationRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdOn: Rep[Option[String]] = column[Option[String]]("created_on", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedOn: Rep[Option[String]] = column[Option[String]]("updated_on", O.Length(32,varying=true), O.Default(None))
    /** Database column locale SqlType(VARCHAR), Length(10,true), Default(None) */
    val locale: Rep[Option[String]] = column[Option[String]]("locale", O.Length(10,varying=true), O.Default(None))
    /** Database column status SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
  }
  /** Collection-like TableQuery object for table Localization */
  lazy val Localization = new TableQuery(tag => new Localization(tag))

  /** Entity class storing rows of table LocalizationExternalAccess
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param expiryDateTime Database column expiry_date_time SqlType(BIGINT), Default(None)
   *  @param userName Database column user_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param password Database column password SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param securedKey Database column secured_key SqlType(VARCHAR), Length(255,true), Default(None) */
  case class LocalizationExternalAccessRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, expiryDateTime: Option[Long] = None, userName: Option[String] = None, password: Option[String] = None, securedKey: Option[String] = None)
  /** GetResult implicit for fetching LocalizationExternalAccessRow objects using plain SQL queries */
  implicit def GetResultLocalizationExternalAccessRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Long]]): GR[LocalizationExternalAccessRow] = GR{
    prs => import prs._
    LocalizationExternalAccessRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Long], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table localization_external_access. Objects of this class serve as prototypes for rows in queries. */
  class LocalizationExternalAccess(_tableTag: Tag) extends Table[LocalizationExternalAccessRow](_tableTag, "localization_external_access") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, expiryDateTime, userName, password, securedKey) <> (LocalizationExternalAccessRow.tupled, LocalizationExternalAccessRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, expiryDateTime, userName, password, securedKey).shaped.<>({r=>import r._; _1.map(_=> LocalizationExternalAccessRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column expiry_date_time SqlType(BIGINT), Default(None) */
    val expiryDateTime: Rep[Option[Long]] = column[Option[Long]]("expiry_date_time", O.Default(None))
    /** Database column user_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val userName: Rep[Option[String]] = column[Option[String]]("user_name", O.Length(255,varying=true), O.Default(None))
    /** Database column password SqlType(VARCHAR), Length(255,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(255,varying=true), O.Default(None))
    /** Database column secured_key SqlType(VARCHAR), Length(255,true), Default(None) */
    val securedKey: Rep[Option[String]] = column[Option[String]]("secured_key", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table LocalizationExternalAccess */
  lazy val LocalizationExternalAccess = new TableQuery(tag => new LocalizationExternalAccess(tag))

  /** Entity class storing rows of table Location
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param zoneCoordinate Database column zone_coordinate SqlType(TEXT), Default(None)
   *  @param cost Database column cost SqlType(FLOAT), Default(None)
   *  @param durationInMinutes Database column duration_in_minutes SqlType(INT), Default(None)
   *  @param minimumOrderCost Database column minimum_order_cost SqlType(FLOAT), Default(None)
   *  @param maximumOrderCost Database column maximum_order_cost SqlType(FLOAT), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param poly Database column poly SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param deliveryFreeAfter Database column delivery_free_after SqlType(FLOAT), Default(None)
   *  @param deliveryArea Database column delivery_area SqlType(FLOAT), Default(None)
   *  @param zoneName Database column zone_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param priorityPosition Database column priority_position SqlType(INT), Default(Some(0)) */
  case class LocationRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, zoneCoordinate: Option[String] = None, cost: Option[Float] = None, durationInMinutes: Option[Int] = None, minimumOrderCost: Option[Float] = None, maximumOrderCost: Option[Float] = None, storeId: Option[String] = None, poly: Option[String] = None, deliveryFreeAfter: Option[Float] = None, deliveryArea: Option[Float] = None, zoneName: Option[String] = None, priorityPosition: Option[Int] = Some(0))
  /** GetResult implicit for fetching LocationRow objects using plain SQL queries */
  implicit def GetResultLocationRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[LocationRow] = GR{
    prs => import prs._
    LocationRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Float], <<?[Int], <<?[Float], <<?[Float], <<?[String], <<?[String], <<?[Float], <<?[Float], <<?[String], <<?[Int]))
  }
  /** Table description of table location. Objects of this class serve as prototypes for rows in queries. */
  class Location(_tableTag: Tag) extends Table[LocationRow](_tableTag, "location") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, zoneCoordinate, cost, durationInMinutes, minimumOrderCost, maximumOrderCost, storeId, poly, deliveryFreeAfter, deliveryArea, zoneName, priorityPosition) <> (LocationRow.tupled, LocationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, zoneCoordinate, cost, durationInMinutes, minimumOrderCost, maximumOrderCost, storeId, poly, deliveryFreeAfter, deliveryArea, zoneName, priorityPosition).shaped.<>({r=>import r._; _1.map(_=> LocationRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column zone_coordinate SqlType(TEXT), Default(None) */
    val zoneCoordinate: Rep[Option[String]] = column[Option[String]]("zone_coordinate", O.Default(None))
    /** Database column cost SqlType(FLOAT), Default(None) */
    val cost: Rep[Option[Float]] = column[Option[Float]]("cost", O.Default(None))
    /** Database column duration_in_minutes SqlType(INT), Default(None) */
    val durationInMinutes: Rep[Option[Int]] = column[Option[Int]]("duration_in_minutes", O.Default(None))
    /** Database column minimum_order_cost SqlType(FLOAT), Default(None) */
    val minimumOrderCost: Rep[Option[Float]] = column[Option[Float]]("minimum_order_cost", O.Default(None))
    /** Database column maximum_order_cost SqlType(FLOAT), Default(None) */
    val maximumOrderCost: Rep[Option[Float]] = column[Option[Float]]("maximum_order_cost", O.Default(None))
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column poly SqlType(VARCHAR), Length(255,true), Default(None) */
    val poly: Rep[Option[String]] = column[Option[String]]("poly", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_free_after SqlType(FLOAT), Default(None) */
    val deliveryFreeAfter: Rep[Option[Float]] = column[Option[Float]]("delivery_free_after", O.Default(None))
    /** Database column delivery_area SqlType(FLOAT), Default(None) */
    val deliveryArea: Rep[Option[Float]] = column[Option[Float]]("delivery_area", O.Default(None))
    /** Database column zone_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val zoneName: Rep[Option[String]] = column[Option[String]]("zone_name", O.Length(255,varying=true), O.Default(None))
    /** Database column priority_position SqlType(INT), Default(Some(0)) */
    val priorityPosition: Rep[Option[Int]] = column[Option[Int]]("priority_position", O.Default(Some(0)))

    /** Foreign key referencing Store (database name fk_location_1) */
    lazy val storeFk = foreignKey("fk_location_1", storeId, Store)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Location */
  lazy val Location = new TableQuery(tag => new Location(tag))

  /** Row type of table Menu */
  type MenuRow = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for MenuRow providing default values if available in the database schema. */
  def MenuRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, cname: Option[String] = None, subdomain: Option[String] = None, currencyCode: Option[String] = None, accountId: Option[String] = None, termsAndConditions: Option[String] = None, name: Option[String] = None, email: Option[String] = None, pendingTemplate: Option[String] = None, confirmedTemplate: Option[String] = None, cancelledTemplate: Option[String] = None, deliveryFreeAfter: Option[Float] = None, imageFilename: Option[String] = None, bannerFilename: Option[String] = None, directoryFilename: Option[String] = None, autoConfirm: Option[Int] = None, minimumPickupAmount: Option[Float] = None, enableOrderPeriod: Option[Int] = Some(0), enableDeliveryPeriod: Option[Int] = Some(0), enablePickupPeriod: Option[Int] = Some(0), orderStartDate: Option[DateTime] = None, orderEndDate: Option[DateTime] = None, deliveryStartDate: Option[DateTime] = None, deliveryEndDate: Option[DateTime] = None, pickupStartDate: Option[DateTime] = None, pickupEndDate: Option[DateTime] = None, noDeliveryDates: Option[String] = None, noPickupDates: Option[String] = None, largeOrderLeadTime: Option[Int] = Some(0), largeOrderLeadTimePickup: Option[Int] = Some(0), largeOrderAmount: Option[Float] = Some(0.0F), largeOrderAmountPickup: Option[Float] = Some(0.0F), summaryTemplate: Option[String] = None, merchantNotificationTemplate: Option[String] = None, cssTemplate: Option[String] = None, orderNumberFormat: Option[String] = Some("{{XXXXXX}}"), startingOrderNumber: Option[Int] = None, cssTemplateNew: Option[String] = None, instructionsForCustomers: Option[String] = None, homePageUrl: Option[String] = None, enableRemarkCompulsory: Option[Int] = Some(0), preventCheckoutIfBelowMinimumAmount: Option[Int] = Some(0), cuisineType: Option[String] = None, classification: Option[String] = None, displayDirectory: Option[Int] = None, deliveredTemplate: Option[String] = None, enableDeliveredMail: Option[Int] = Some(0), roundToFiveCents: Option[Int] = Some(0), country: Option[String] = None, gmtOffset: Option[Float] = None, shopbackTrackerId: Option[String] = None, cssTemplateNewv3: Option[String] = None, itemViewToggle: Option[Int] = Some(0), cartMetaTag: Option[String] = Some("Food delivery Singapore | Catering in Singapore | Delivery Singapore"), cartDesc: Option[String] = Some("Hungry now? Order your next meal online from today! We provide delivery and pickup/takeaway services."), cnameStatus: Option[Int] = Some(0)): MenuRow = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: cname :: subdomain :: currencyCode :: accountId :: termsAndConditions :: name :: email :: pendingTemplate :: confirmedTemplate :: cancelledTemplate :: deliveryFreeAfter :: imageFilename :: bannerFilename :: directoryFilename :: autoConfirm :: minimumPickupAmount :: enableOrderPeriod :: enableDeliveryPeriod :: enablePickupPeriod :: orderStartDate :: orderEndDate :: deliveryStartDate :: deliveryEndDate :: pickupStartDate :: pickupEndDate :: noDeliveryDates :: noPickupDates :: largeOrderLeadTime :: largeOrderLeadTimePickup :: largeOrderAmount :: largeOrderAmountPickup :: summaryTemplate :: merchantNotificationTemplate :: cssTemplate :: orderNumberFormat :: startingOrderNumber :: cssTemplateNew :: instructionsForCustomers :: homePageUrl :: enableRemarkCompulsory :: preventCheckoutIfBelowMinimumAmount :: cuisineType :: classification :: displayDirectory :: deliveredTemplate :: enableDeliveredMail :: roundToFiveCents :: country :: gmtOffset :: shopbackTrackerId :: cssTemplateNewv3 :: itemViewToggle :: cartMetaTag :: cartDesc :: cnameStatus :: HNil
  }
  /** GetResult implicit for fetching MenuRow objects using plain SQL queries */
  implicit def GetResultMenuRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[MenuRow] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[DateTime] :: <<?[DateTime] :: <<?[DateTime] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: HNil
  }
  /** Table description of table menu. Objects of this class serve as prototypes for rows in queries. */
  class Menu(_tableTag: Tag) extends Table[MenuRow](_tableTag, "menu") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: cname :: subdomain :: currencyCode :: accountId :: termsAndConditions :: name :: email :: pendingTemplate :: confirmedTemplate :: cancelledTemplate :: deliveryFreeAfter :: imageFilename :: bannerFilename :: directoryFilename :: autoConfirm :: minimumPickupAmount :: enableOrderPeriod :: enableDeliveryPeriod :: enablePickupPeriod :: orderStartDate :: orderEndDate :: deliveryStartDate :: deliveryEndDate :: pickupStartDate :: pickupEndDate :: noDeliveryDates :: noPickupDates :: largeOrderLeadTime :: largeOrderLeadTimePickup :: largeOrderAmount :: largeOrderAmountPickup :: summaryTemplate :: merchantNotificationTemplate :: cssTemplate :: orderNumberFormat :: startingOrderNumber :: cssTemplateNew :: instructionsForCustomers :: homePageUrl :: enableRemarkCompulsory :: preventCheckoutIfBelowMinimumAmount :: cuisineType :: classification :: displayDirectory :: deliveredTemplate :: enableDeliveredMail :: roundToFiveCents :: country :: gmtOffset :: shopbackTrackerId :: cssTemplateNewv3 :: itemViewToggle :: cartMetaTag :: cartDesc :: cnameStatus :: HNil

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
    /** Database column cname SqlType(VARCHAR), Length(255,true), Default(None) */
    val cname: Rep[Option[String]] = column[Option[String]]("cname", O.Length(255,varying=true), O.Default(None))
    /** Database column subdomain SqlType(VARCHAR), Length(255,true), Default(None) */
    val subdomain: Rep[Option[String]] = column[Option[String]]("subdomain", O.Length(255,varying=true), O.Default(None))
    /** Database column currency_code SqlType(VARCHAR), Length(10,true), Default(None) */
    val currencyCode: Rep[Option[String]] = column[Option[String]]("currency_code", O.Length(10,varying=true), O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column terms_and_conditions SqlType(TEXT), Default(None) */
    val termsAndConditions: Rep[Option[String]] = column[Option[String]]("terms_and_conditions", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column pending_template SqlType(TEXT), Default(None) */
    val pendingTemplate: Rep[Option[String]] = column[Option[String]]("pending_template", O.Default(None))
    /** Database column confirmed_template SqlType(TEXT), Default(None) */
    val confirmedTemplate: Rep[Option[String]] = column[Option[String]]("confirmed_template", O.Default(None))
    /** Database column cancelled_template SqlType(TEXT), Default(None) */
    val cancelledTemplate: Rep[Option[String]] = column[Option[String]]("cancelled_template", O.Default(None))
    /** Database column delivery_free_after SqlType(FLOAT), Default(None) */
    val deliveryFreeAfter: Rep[Option[Float]] = column[Option[Float]]("delivery_free_after", O.Default(None))
    /** Database column image_filename SqlType(VARCHAR), Length(255,true), Default(None) */
    val imageFilename: Rep[Option[String]] = column[Option[String]]("image_filename", O.Length(255,varying=true), O.Default(None))
    /** Database column banner_filename SqlType(VARCHAR), Length(255,true), Default(None) */
    val bannerFilename: Rep[Option[String]] = column[Option[String]]("banner_filename", O.Length(255,varying=true), O.Default(None))
    /** Database column directory_filename SqlType(VARCHAR), Length(255,true), Default(None) */
    val directoryFilename: Rep[Option[String]] = column[Option[String]]("directory_filename", O.Length(255,varying=true), O.Default(None))
    /** Database column auto_confirm SqlType(INT), Default(None) */
    val autoConfirm: Rep[Option[Int]] = column[Option[Int]]("auto_confirm", O.Default(None))
    /** Database column minimum_pickup_amount SqlType(FLOAT), Default(None) */
    val minimumPickupAmount: Rep[Option[Float]] = column[Option[Float]]("minimum_pickup_amount", O.Default(None))
    /** Database column enable_order_period SqlType(INT), Default(Some(0)) */
    val enableOrderPeriod: Rep[Option[Int]] = column[Option[Int]]("enable_order_period", O.Default(Some(0)))
    /** Database column enable_delivery_period SqlType(INT), Default(Some(0)) */
    val enableDeliveryPeriod: Rep[Option[Int]] = column[Option[Int]]("enable_delivery_period", O.Default(Some(0)))
    /** Database column enable_pickup_period SqlType(INT), Default(Some(0)) */
    val enablePickupPeriod: Rep[Option[Int]] = column[Option[Int]]("enable_pickup_period", O.Default(Some(0)))
    /** Database column order_start_date SqlType(DATETIME), Default(None) */
    val orderStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("order_start_date", O.Default(None))
    /** Database column order_end_date SqlType(DATETIME), Default(None) */
    val orderEndDate: Rep[Option[DateTime]] = column[Option[DateTime]]("order_end_date", O.Default(None))
    /** Database column delivery_start_date SqlType(DATETIME), Default(None) */
    val deliveryStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("delivery_start_date", O.Default(None))
    /** Database column delivery_end_date SqlType(DATETIME), Default(None) */
    val deliveryEndDate: Rep[Option[DateTime]] = column[Option[DateTime]]("delivery_end_date", O.Default(None))
    /** Database column pickup_start_date SqlType(DATETIME), Default(None) */
    val pickupStartDate: Rep[Option[DateTime]] = column[Option[DateTime]]("pickup_start_date", O.Default(None))
    /** Database column pickup_end_date SqlType(DATETIME), Default(None) */
    val pickupEndDate: Rep[Option[DateTime]] = column[Option[DateTime]]("pickup_end_date", O.Default(None))
    /** Database column no_delivery_dates SqlType(TEXT), Default(None) */
    val noDeliveryDates: Rep[Option[String]] = column[Option[String]]("no_delivery_dates", O.Default(None))
    /** Database column no_pickup_dates SqlType(TEXT), Default(None) */
    val noPickupDates: Rep[Option[String]] = column[Option[String]]("no_pickup_dates", O.Default(None))
    /** Database column large_order_lead_time SqlType(INT), Default(Some(0)) */
    val largeOrderLeadTime: Rep[Option[Int]] = column[Option[Int]]("large_order_lead_time", O.Default(Some(0)))
    /** Database column large_order_lead_time_pickup SqlType(INT), Default(Some(0)) */
    val largeOrderLeadTimePickup: Rep[Option[Int]] = column[Option[Int]]("large_order_lead_time_pickup", O.Default(Some(0)))
    /** Database column large_order_amount SqlType(FLOAT UNSIGNED), Default(Some(0.0)) */
    val largeOrderAmount: Rep[Option[Float]] = column[Option[Float]]("large_order_amount", O.Default(Some(0.0F)))
    /** Database column large_order_amount_pickup SqlType(FLOAT), Default(Some(0.0)) */
    val largeOrderAmountPickup: Rep[Option[Float]] = column[Option[Float]]("large_order_amount_pickup", O.Default(Some(0.0F)))
    /** Database column summary_template SqlType(TEXT), Default(None) */
    val summaryTemplate: Rep[Option[String]] = column[Option[String]]("summary_template", O.Default(None))
    /** Database column merchant_notification_template SqlType(TEXT), Default(None) */
    val merchantNotificationTemplate: Rep[Option[String]] = column[Option[String]]("merchant_notification_template", O.Default(None))
    /** Database column css_template SqlType(TEXT), Default(None) */
    val cssTemplate: Rep[Option[String]] = column[Option[String]]("css_template", O.Default(None))
    /** Database column order_number_format SqlType(VARCHAR), Length(45,true), Default(Some({{XXXXXX}})) */
    val orderNumberFormat: Rep[Option[String]] = column[Option[String]]("order_number_format", O.Length(45,varying=true), O.Default(Some("{{XXXXXX}}")))
    /** Database column starting_order_number SqlType(INT), Default(None) */
    val startingOrderNumber: Rep[Option[Int]] = column[Option[Int]]("starting_order_number", O.Default(None))
    /** Database column css_template_new SqlType(TEXT), Default(None) */
    val cssTemplateNew: Rep[Option[String]] = column[Option[String]]("css_template_new", O.Default(None))
    /** Database column instructions_for_customers SqlType(TEXT), Default(None) */
    val instructionsForCustomers: Rep[Option[String]] = column[Option[String]]("instructions_for_customers", O.Default(None))
    /** Database column home_page_url SqlType(VARCHAR), Length(45,true), Default(None) */
    val homePageUrl: Rep[Option[String]] = column[Option[String]]("home_page_url", O.Length(45,varying=true), O.Default(None))
    /** Database column enable_remark_compulsory SqlType(INT), Default(Some(0)) */
    val enableRemarkCompulsory: Rep[Option[Int]] = column[Option[Int]]("enable_remark_compulsory", O.Default(Some(0)))
    /** Database column prevent_checkout_if_below_minimum_amount SqlType(INT), Default(Some(0)) */
    val preventCheckoutIfBelowMinimumAmount: Rep[Option[Int]] = column[Option[Int]]("prevent_checkout_if_below_minimum_amount", O.Default(Some(0)))
    /** Database column cuisine_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val cuisineType: Rep[Option[String]] = column[Option[String]]("cuisine_type", O.Length(255,varying=true), O.Default(None))
    /** Database column classification SqlType(VARCHAR), Length(255,true), Default(None) */
    val classification: Rep[Option[String]] = column[Option[String]]("classification", O.Length(255,varying=true), O.Default(None))
    /** Database column display_directory SqlType(INT), Default(None) */
    val displayDirectory: Rep[Option[Int]] = column[Option[Int]]("display_directory", O.Default(None))
    /** Database column delivered_template SqlType(TEXT), Default(None) */
    val deliveredTemplate: Rep[Option[String]] = column[Option[String]]("delivered_template", O.Default(None))
    /** Database column enable_delivered_mail SqlType(INT), Default(Some(0)) */
    val enableDeliveredMail: Rep[Option[Int]] = column[Option[Int]]("enable_delivered_mail", O.Default(Some(0)))
    /** Database column round_to_five_cents SqlType(INT), Default(Some(0)) */
    val roundToFiveCents: Rep[Option[Int]] = column[Option[Int]]("round_to_five_cents", O.Default(Some(0)))
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(None))
    /** Database column gmt_offset SqlType(FLOAT), Default(None) */
    val gmtOffset: Rep[Option[Float]] = column[Option[Float]]("gmt_offset", O.Default(None))
    /** Database column shopback_tracker_id SqlType(TEXT), Default(None) */
    val shopbackTrackerId: Rep[Option[String]] = column[Option[String]]("shopback_tracker_id", O.Default(None))
    /** Database column css_template_newv3 SqlType(TEXT), Default(None) */
    val cssTemplateNewv3: Rep[Option[String]] = column[Option[String]]("css_template_newv3", O.Default(None))
    /** Database column item_view_toggle SqlType(INT), Default(Some(0)) */
    val itemViewToggle: Rep[Option[Int]] = column[Option[Int]]("item_view_toggle", O.Default(Some(0)))
    /** Database column cart_meta_tag SqlType(VARCHAR), Length(255,true), Default(Some(Food delivery Singapore | Catering in Singapore | Delivery Singapore)) */
    val cartMetaTag: Rep[Option[String]] = column[Option[String]]("cart_meta_tag", O.Length(255,varying=true), O.Default(Some("Food delivery Singapore | Catering in Singapore | Delivery Singapore")))
    /** Database column cart_desc SqlType(VARCHAR), Length(255,true), Default(Some(Hungry now? Order your next meal online from today! We provide delivery and pickup/takeaway services.)) */
    val cartDesc: Rep[Option[String]] = column[Option[String]]("cart_desc", O.Length(255,varying=true), O.Default(Some("Hungry now? Order your next meal online from today! We provide delivery and pickup/takeaway services.")))
    /** Database column cname_status SqlType(INT), Default(Some(0)) */
    val cnameStatus: Rep[Option[Int]] = column[Option[Int]]("cname_status", O.Default(Some(0)))

    /** Foreign key referencing Account (database name fk_menu_1) */
    lazy val accountFk = foreignKey("fk_menu_1", accountId :: HNil, Account)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Menu */
  lazy val Menu = new TableQuery(tag => new Menu(tag))

  /** Entity class storing rows of table MenuNotification
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param notificationTemplateId Database column notification_template_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param smsTemplate Database column sms_template SqlType(TEXT), Default(None)
   *  @param emailHeaderTitle Database column email_header_title SqlType(TEXT), Default(None)
   *  @param emailSubject Database column email_subject SqlType(TEXT), Default(None)
   *  @param emailTemplate Database column email_template SqlType(TEXT), Default(None)
   *  @param faxTemplate Database column fax_template SqlType(TEXT), Default(None)
   *  @param sms Database column sms SqlType(INT), Default(None)
   *  @param email Database column email SqlType(INT), Default(None)
   *  @param fax Database column fax SqlType(INT), Default(None)
   *  @param paymentOptionId Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class MenuNotificationRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, notificationTemplateId: Option[String] = None, smsTemplate: Option[String] = None, emailHeaderTitle: Option[String] = None, emailSubject: Option[String] = None, emailTemplate: Option[String] = None, faxTemplate: Option[String] = None, sms: Option[Int] = None, email: Option[Int] = None, fax: Option[Int] = None, paymentOptionId: Option[String] = None)
  /** GetResult implicit for fetching MenuNotificationRow objects using plain SQL queries */
  implicit def GetResultMenuNotificationRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[MenuNotificationRow] = GR{
    prs => import prs._
    MenuNotificationRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[String], <<?[String], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table menu_notification. Objects of this class serve as prototypes for rows in queries. */
  class MenuNotification(_tableTag: Tag) extends Table[MenuNotificationRow](_tableTag, "menu_notification") {
    def * = (id, version, createdOn, createdBy, updatedBy, updatedOn, menuId, notificationTemplateId, smsTemplate, emailHeaderTitle, emailSubject, emailTemplate, faxTemplate, sms, email, fax, paymentOptionId) <> (MenuNotificationRow.tupled, MenuNotificationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, createdBy, updatedBy, updatedOn, menuId, notificationTemplateId, smsTemplate, emailHeaderTitle, emailSubject, emailTemplate, faxTemplate, sms, email, fax, paymentOptionId).shaped.<>({r=>import r._; _1.map(_=> MenuNotificationRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column notification_template_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val notificationTemplateId: Rep[Option[String]] = column[Option[String]]("notification_template_id", O.Length(32,varying=true), O.Default(None))
    /** Database column sms_template SqlType(TEXT), Default(None) */
    val smsTemplate: Rep[Option[String]] = column[Option[String]]("sms_template", O.Default(None))
    /** Database column email_header_title SqlType(TEXT), Default(None) */
    val emailHeaderTitle: Rep[Option[String]] = column[Option[String]]("email_header_title", O.Default(None))
    /** Database column email_subject SqlType(TEXT), Default(None) */
    val emailSubject: Rep[Option[String]] = column[Option[String]]("email_subject", O.Default(None))
    /** Database column email_template SqlType(TEXT), Default(None) */
    val emailTemplate: Rep[Option[String]] = column[Option[String]]("email_template", O.Default(None))
    /** Database column fax_template SqlType(TEXT), Default(None) */
    val faxTemplate: Rep[Option[String]] = column[Option[String]]("fax_template", O.Default(None))
    /** Database column sms SqlType(INT), Default(None) */
    val sms: Rep[Option[Int]] = column[Option[Int]]("sms", O.Default(None))
    /** Database column email SqlType(INT), Default(None) */
    val email: Rep[Option[Int]] = column[Option[Int]]("email", O.Default(None))
    /** Database column fax SqlType(INT), Default(None) */
    val fax: Rep[Option[Int]] = column[Option[Int]]("fax", O.Default(None))
    /** Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentOptionId: Rep[Option[String]] = column[Option[String]]("payment_option_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing NotificationTemplate (database name fk_mn_1) */
    lazy val notificationTemplateFk = foreignKey("fk_mn_1", notificationTemplateId, NotificationTemplate)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing PaymentOption (database name fk_po_1) */
    lazy val paymentOptionFk = foreignKey("fk_po_1", paymentOptionId, PaymentOption)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table MenuNotification */
  lazy val MenuNotification = new TableQuery(tag => new MenuNotification(tag))

  /** Entity class storing rows of table NotificationTemplate
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param notificationType Database column notification_type SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param notificationStatusType Database column notification_status_type SqlType(INT), Default(None)
   *  @param notificationPaymentType Database column notification_payment_type SqlType(INT), Default(None)
   *  @param smsTemplate Database column sms_template SqlType(TEXT), Default(None)
   *  @param emailTemplate Database column email_template SqlType(TEXT), Default(None)
   *  @param emailHeaderTitle Database column email_header_title SqlType(TEXT), Default(None)
   *  @param emailSubject Database column email_subject SqlType(TEXT), Default(None)
   *  @param faxTemplate Database column fax_template SqlType(TEXT), Default(None)
   *  @param isEditable Database column is_editable SqlType(INT), Default(None)
   *  @param isMerchantPreferenceEnabled Database column is_merchant_preference_enabled SqlType(INT), Default(None)
   *  @param displayOrder Database column display_order SqlType(INT), Default(None) */
  case class NotificationTemplateRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, updatedOn: Option[DateTime] = None, notificationType: Option[String] = None, notificationStatusType: Option[Int] = None, notificationPaymentType: Option[Int] = None, smsTemplate: Option[String] = None, emailTemplate: Option[String] = None, emailHeaderTitle: Option[String] = None, emailSubject: Option[String] = None, faxTemplate: Option[String] = None, isEditable: Option[Int] = None, isMerchantPreferenceEnabled: Option[Int] = None, displayOrder: Option[Int] = None)
  /** GetResult implicit for fetching NotificationTemplateRow objects using plain SQL queries */
  implicit def GetResultNotificationTemplateRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[NotificationTemplateRow] = GR{
    prs => import prs._
    NotificationTemplateRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[String], <<?[String], <<?[DateTime], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table notification_template. Objects of this class serve as prototypes for rows in queries. */
  class NotificationTemplate(_tableTag: Tag) extends Table[NotificationTemplateRow](_tableTag, "notification_template") {
    def * = (id, version, createdOn, createdBy, updatedBy, updatedOn, notificationType, notificationStatusType, notificationPaymentType, smsTemplate, emailTemplate, emailHeaderTitle, emailSubject, faxTemplate, isEditable, isMerchantPreferenceEnabled, displayOrder) <> (NotificationTemplateRow.tupled, NotificationTemplateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, createdBy, updatedBy, updatedOn, notificationType, notificationStatusType, notificationPaymentType, smsTemplate, emailTemplate, emailHeaderTitle, emailSubject, faxTemplate, isEditable, isMerchantPreferenceEnabled, displayOrder).shaped.<>({r=>import r._; _1.map(_=> NotificationTemplateRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column notification_type SqlType(VARCHAR), Length(45,true), Default(None) */
    val notificationType: Rep[Option[String]] = column[Option[String]]("notification_type", O.Length(45,varying=true), O.Default(None))
    /** Database column notification_status_type SqlType(INT), Default(None) */
    val notificationStatusType: Rep[Option[Int]] = column[Option[Int]]("notification_status_type", O.Default(None))
    /** Database column notification_payment_type SqlType(INT), Default(None) */
    val notificationPaymentType: Rep[Option[Int]] = column[Option[Int]]("notification_payment_type", O.Default(None))
    /** Database column sms_template SqlType(TEXT), Default(None) */
    val smsTemplate: Rep[Option[String]] = column[Option[String]]("sms_template", O.Default(None))
    /** Database column email_template SqlType(TEXT), Default(None) */
    val emailTemplate: Rep[Option[String]] = column[Option[String]]("email_template", O.Default(None))
    /** Database column email_header_title SqlType(TEXT), Default(None) */
    val emailHeaderTitle: Rep[Option[String]] = column[Option[String]]("email_header_title", O.Default(None))
    /** Database column email_subject SqlType(TEXT), Default(None) */
    val emailSubject: Rep[Option[String]] = column[Option[String]]("email_subject", O.Default(None))
    /** Database column fax_template SqlType(TEXT), Default(None) */
    val faxTemplate: Rep[Option[String]] = column[Option[String]]("fax_template", O.Default(None))
    /** Database column is_editable SqlType(INT), Default(None) */
    val isEditable: Rep[Option[Int]] = column[Option[Int]]("is_editable", O.Default(None))
    /** Database column is_merchant_preference_enabled SqlType(INT), Default(None) */
    val isMerchantPreferenceEnabled: Rep[Option[Int]] = column[Option[Int]]("is_merchant_preference_enabled", O.Default(None))
    /** Database column display_order SqlType(INT), Default(None) */
    val displayOrder: Rep[Option[Int]] = column[Option[Int]]("display_order", O.Default(None))
  }
  /** Collection-like TableQuery object for table NotificationTemplate */
  lazy val NotificationTemplate = new TableQuery(tag => new NotificationTemplate(tag))

  /** Entity class storing rows of table OrderDiscount
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param promotionId Database column promotion_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param amount Database column amount SqlType(FLOAT), Default(None)
   *  @param amountType Database column amount_type SqlType(INT), Default(None)
   *  @param discountType Database column discount_type SqlType(INT), Default(None)
   *  @param promotionName Database column promotion_name SqlType(VARCHAR), Length(255,true), Default(None) */
  case class OrderDiscountRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, promotionId: Option[String] = None, storeOrderId: Option[String] = None, description: Option[String] = None, amount: Option[Float] = None, amountType: Option[Int] = None, discountType: Option[Int] = None, promotionName: Option[String] = None)
  /** GetResult implicit for fetching OrderDiscountRow objects using plain SQL queries */
  implicit def GetResultOrderDiscountRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[OrderDiscountRow] = GR{
    prs => import prs._
    OrderDiscountRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table order_discount. Objects of this class serve as prototypes for rows in queries. */
  class OrderDiscount(_tableTag: Tag) extends Table[OrderDiscountRow](_tableTag, "order_discount") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, promotionId, storeOrderId, description, amount, amountType, discountType, promotionName) <> (OrderDiscountRow.tupled, OrderDiscountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, promotionId, storeOrderId, description, amount, amountType, discountType, promotionName).shaped.<>({r=>import r._; _1.map(_=> OrderDiscountRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column promotion_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val promotionId: Rep[Option[String]] = column[Option[String]]("promotion_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(255,varying=true), O.Default(None))
    /** Database column amount SqlType(FLOAT), Default(None) */
    val amount: Rep[Option[Float]] = column[Option[Float]]("amount", O.Default(None))
    /** Database column amount_type SqlType(INT), Default(None) */
    val amountType: Rep[Option[Int]] = column[Option[Int]]("amount_type", O.Default(None))
    /** Database column discount_type SqlType(INT), Default(None) */
    val discountType: Rep[Option[Int]] = column[Option[Int]]("discount_type", O.Default(None))
    /** Database column promotion_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val promotionName: Rep[Option[String]] = column[Option[String]]("promotion_name", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing StoreOrder (database name fk_order_discount_1) */
    lazy val storeOrderFk = foreignKey("fk_order_discount_1", storeOrderId, StoreOrder)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderDiscount */
  lazy val OrderDiscount = new TableQuery(tag => new OrderDiscount(tag))

  /** Entity class storing rows of table OrderForm
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param dueDate Database column due_date SqlType(DATETIME), Default(None)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param submitted Database column submitted SqlType(INT), Default(Some(0))
   *  @param recipients Database column recipients SqlType(TEXT), Default(None) */
  case class OrderFormRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, email: Option[String] = None, name: Option[String] = None, dueDate: Option[DateTime] = None, version: Option[Int] = None, submitted: Option[Int] = Some(0), recipients: Option[String] = None)
  /** GetResult implicit for fetching OrderFormRow objects using plain SQL queries */
  implicit def GetResultOrderFormRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[OrderFormRow] = GR{
    prs => import prs._
    OrderFormRow.tupled((<<[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[DateTime], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table order_form. Objects of this class serve as prototypes for rows in queries. */
  class OrderForm(_tableTag: Tag) extends Table[OrderFormRow](_tableTag, "order_form") {
    def * = (id, createdOn, updatedOn, createdBy, updatedBy, email, name, dueDate, version, submitted, recipients) <> (OrderFormRow.tupled, OrderFormRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdOn, updatedOn, createdBy, updatedBy, email, name, dueDate, version, submitted, recipients).shaped.<>({r=>import r._; _1.map(_=> OrderFormRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column due_date SqlType(DATETIME), Default(None) */
    val dueDate: Rep[Option[DateTime]] = column[Option[DateTime]]("due_date", O.Default(None))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column submitted SqlType(INT), Default(Some(0)) */
    val submitted: Rep[Option[Int]] = column[Option[Int]]("submitted", O.Default(Some(0)))
    /** Database column recipients SqlType(TEXT), Default(None) */
    val recipients: Rep[Option[String]] = column[Option[String]]("recipients", O.Default(None))
  }
  /** Collection-like TableQuery object for table OrderForm */
  lazy val OrderForm = new TableQuery(tag => new OrderForm(tag))

  /** Entity class storing rows of table OrderIngredient
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param variantIngredientReference Database column variant_ingredient_reference SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param quantity Database column quantity SqlType(FLOAT), Default(None)
   *  @param name Database column name SqlType(TEXT), Default(None)
   *  @param unitType Database column unit_type SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bomNumber Database column bom_number SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param orderItemId Database column order_item_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param ingredientReference Database column ingredient_reference SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param department Database column department SqlType(VARCHAR), Length(255,true), Default(None) */
  case class OrderIngredientRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, variantIngredientReference: Option[String] = None, quantity: Option[Float] = None, name: Option[String] = None, unitType: Option[String] = None, bomNumber: Option[String] = None, orderItemId: Option[String] = None, ingredientReference: Option[String] = None, department: Option[String] = None)
  /** GetResult implicit for fetching OrderIngredientRow objects using plain SQL queries */
  implicit def GetResultOrderIngredientRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]], e4: GR[Option[Float]]): GR[OrderIngredientRow] = GR{
    prs => import prs._
    OrderIngredientRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table order_ingredient. Objects of this class serve as prototypes for rows in queries. */
  class OrderIngredient(_tableTag: Tag) extends Table[OrderIngredientRow](_tableTag, "order_ingredient") {
    def * = (id, version, createdOn, updatedOn, createdBy, updatedBy, variantIngredientReference, quantity, name, unitType, bomNumber, orderItemId, ingredientReference, department) <> (OrderIngredientRow.tupled, OrderIngredientRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, updatedOn, createdBy, updatedBy, variantIngredientReference, quantity, name, unitType, bomNumber, orderItemId, ingredientReference, department).shaped.<>({r=>import r._; _1.map(_=> OrderIngredientRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column variant_ingredient_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val variantIngredientReference: Rep[Option[String]] = column[Option[String]]("variant_ingredient_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column quantity SqlType(FLOAT), Default(None) */
    val quantity: Rep[Option[Float]] = column[Option[Float]]("quantity", O.Default(None))
    /** Database column name SqlType(TEXT), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column unit_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val unitType: Rep[Option[String]] = column[Option[String]]("unit_type", O.Length(255,varying=true), O.Default(None))
    /** Database column bom_number SqlType(VARCHAR), Length(255,true), Default(None) */
    val bomNumber: Rep[Option[String]] = column[Option[String]]("bom_number", O.Length(255,varying=true), O.Default(None))
    /** Database column order_item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val orderItemId: Rep[Option[String]] = column[Option[String]]("order_item_id", O.Length(32,varying=true), O.Default(None))
    /** Database column ingredient_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val ingredientReference: Rep[Option[String]] = column[Option[String]]("ingredient_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column department SqlType(VARCHAR), Length(255,true), Default(None) */
    val department: Rep[Option[String]] = column[Option[String]]("department", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing OrderItem (database name fk_order_ingredient_1) */
    lazy val orderItemFk = foreignKey("fk_order_ingredient_1", orderItemId, OrderItem)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderIngredient */
  lazy val OrderIngredient = new TableQuery(tag => new OrderIngredient(tag))

  /** Entity class storing rows of table OrderItem
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param price Database column price SqlType(FLOAT), Default(None)
   *  @param quantity Database column quantity SqlType(INT), Default(None)
   *  @param itemReference Database column item_reference SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param orderTagId Database column order_tag_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param promotionReference Database column promotion_reference SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param addedViaPrompt Database column added_via_prompt SqlType(INT), Default(Some(0))
   *  @param isPromoItem Database column is_promo_item SqlType(INT), Default(Some(0)) */
  case class OrderItemRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, name: Option[String] = None, price: Option[Float] = None, quantity: Option[Int] = None, itemReference: Option[String] = None, storeOrderId: Option[String] = None, orderTagId: Option[String] = None, promotionReference: Option[String] = None, addedViaPrompt: Option[Int] = Some(0), isPromoItem: Option[Int] = Some(0))
  /** GetResult implicit for fetching OrderItemRow objects using plain SQL queries */
  implicit def GetResultOrderItemRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[OrderItemRow] = GR{
    prs => import prs._
    OrderItemRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Float], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table order_item. Objects of this class serve as prototypes for rows in queries. */
  class OrderItem(_tableTag: Tag) extends Table[OrderItemRow](_tableTag, "order_item") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, name, price, quantity, itemReference, storeOrderId, orderTagId, promotionReference, addedViaPrompt, isPromoItem) <> (OrderItemRow.tupled, OrderItemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, name, price, quantity, itemReference, storeOrderId, orderTagId, promotionReference, addedViaPrompt, isPromoItem).shaped.<>({r=>import r._; _1.map(_=> OrderItemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column price SqlType(FLOAT), Default(None) */
    val price: Rep[Option[Float]] = column[Option[Float]]("price", O.Default(None))
    /** Database column quantity SqlType(INT), Default(None) */
    val quantity: Rep[Option[Int]] = column[Option[Int]]("quantity", O.Default(None))
    /** Database column item_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val itemReference: Rep[Option[String]] = column[Option[String]]("item_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column order_tag_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val orderTagId: Rep[Option[String]] = column[Option[String]]("order_tag_id", O.Length(32,varying=true), O.Default(None))
    /** Database column promotion_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val promotionReference: Rep[Option[String]] = column[Option[String]]("promotion_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column added_via_prompt SqlType(INT), Default(Some(0)) */
    val addedViaPrompt: Rep[Option[Int]] = column[Option[Int]]("added_via_prompt", O.Default(Some(0)))
    /** Database column is_promo_item SqlType(INT), Default(Some(0)) */
    val isPromoItem: Rep[Option[Int]] = column[Option[Int]]("is_promo_item", O.Default(Some(0)))

    /** Foreign key referencing OrderTag (database name fk_order_item_2) */
    lazy val orderTagFk = foreignKey("fk_order_item_2", orderTagId, OrderTag)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing StoreOrder (database name fk_order_item_1) */
    lazy val storeOrderFk = foreignKey("fk_order_item_1", storeOrderId, StoreOrder)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderItem */
  lazy val OrderItem = new TableQuery(tag => new OrderItem(tag))

  /** Row type of table OrderPromotionv3 */
  type OrderPromotionv3Row = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[java.sql.Time],HCons[Option[java.sql.Time],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for OrderPromotionv3Row providing default values if available in the database schema. */
  def OrderPromotionv3Row(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, enablePromoCode: Option[Int] = None, promoCodes: Option[String] = None, promoApplyTo: Option[Int] = None, customerUseTimes: Option[Int] = None, promoCodeLimit: Option[Int] = None, availableOn: Option[Int] = None, startDate: Option[DateTime] = None, endDate: Option[DateTime] = None, startTime: Option[java.sql.Time] = None, endTime: Option[java.sql.Time] = None, availableDays: Option[String] = None, applyToPlatform: Option[Int] = None, applyToDeliveryPickup: Option[Int] = None, excludePromos: Option[String] = None, promotionResultType: Option[Int] = None, promotionConditionType: Option[Int] = None, promoOrder: Option[Int] = None, description: Option[String] = None, name: Option[String] = None, conditionAmount: Option[Float] = None, conditionAmountType: Option[Int] = None, conditionQuantity: Option[Int] = None, conditionItemIds: Option[String] = None, conditionCategoryIds: Option[String] = None, resultAmount: Option[Float] = None, resultAmountType: Option[Int] = None, resultItemIds: Option[String] = None, resultCategoryIds: Option[String] = None, resultQuantity: Option[Int] = None, promotionReference: Option[String] = None, storeOrderId: Option[String] = None, appliedAbsoluteDiscountAmount: Option[Float] = None, appliedOrderItemReference: Option[String] = None, appliedOrderPromotionType: Option[Int] = None, isCustomiseStartEndTime: Option[Int] = None, isCustomiseAvailableDay: Option[Int] = None, isCustomiseStartEndDate: Option[Int] = Some(0), isShowOnShoppingCart: Option[Int] = Some(0), stackableOption: Option[Int] = Some(0)): OrderPromotionv3Row = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: enablePromoCode :: promoCodes :: promoApplyTo :: customerUseTimes :: promoCodeLimit :: availableOn :: startDate :: endDate :: startTime :: endTime :: availableDays :: applyToPlatform :: applyToDeliveryPickup :: excludePromos :: promotionResultType :: promotionConditionType :: promoOrder :: description :: name :: conditionAmount :: conditionAmountType :: conditionQuantity :: conditionItemIds :: conditionCategoryIds :: resultAmount :: resultAmountType :: resultItemIds :: resultCategoryIds :: resultQuantity :: promotionReference :: storeOrderId :: appliedAbsoluteDiscountAmount :: appliedOrderItemReference :: appliedOrderPromotionType :: isCustomiseStartEndTime :: isCustomiseAvailableDay :: isCustomiseStartEndDate :: isShowOnShoppingCart :: stackableOption :: HNil
  }
  /** GetResult implicit for fetching OrderPromotionv3Row objects using plain SQL queries */
  implicit def GetResultOrderPromotionv3Row(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[java.sql.Time]], e5: GR[Option[Float]]): GR[OrderPromotionv3Row] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[DateTime] :: <<?[java.sql.Time] :: <<?[java.sql.Time] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table order_promotionv3. Objects of this class serve as prototypes for rows in queries. */
  class OrderPromotionv3(_tableTag: Tag) extends Table[OrderPromotionv3Row](_tableTag, "order_promotionv3") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: enablePromoCode :: promoCodes :: promoApplyTo :: customerUseTimes :: promoCodeLimit :: availableOn :: startDate :: endDate :: startTime :: endTime :: availableDays :: applyToPlatform :: applyToDeliveryPickup :: excludePromos :: promotionResultType :: promotionConditionType :: promoOrder :: description :: name :: conditionAmount :: conditionAmountType :: conditionQuantity :: conditionItemIds :: conditionCategoryIds :: resultAmount :: resultAmountType :: resultItemIds :: resultCategoryIds :: resultQuantity :: promotionReference :: storeOrderId :: appliedAbsoluteDiscountAmount :: appliedOrderItemReference :: appliedOrderPromotionType :: isCustomiseStartEndTime :: isCustomiseAvailableDay :: isCustomiseStartEndDate :: isShowOnShoppingCart :: stackableOption :: HNil

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
    /** Database column enable_promo_code SqlType(INT), Default(None) */
    val enablePromoCode: Rep[Option[Int]] = column[Option[Int]]("enable_promo_code", O.Default(None))
    /** Database column promo_codes SqlType(TEXT), Default(None) */
    val promoCodes: Rep[Option[String]] = column[Option[String]]("promo_codes", O.Default(None))
    /** Database column promo_apply_to SqlType(INT), Default(None) */
    val promoApplyTo: Rep[Option[Int]] = column[Option[Int]]("promo_apply_to", O.Default(None))
    /** Database column customer_use_times SqlType(INT), Default(None) */
    val customerUseTimes: Rep[Option[Int]] = column[Option[Int]]("customer_use_times", O.Default(None))
    /** Database column promo_code_limit SqlType(INT), Default(None) */
    val promoCodeLimit: Rep[Option[Int]] = column[Option[Int]]("promo_code_limit", O.Default(None))
    /** Database column available_on SqlType(INT), Default(None) */
    val availableOn: Rep[Option[Int]] = column[Option[Int]]("available_on", O.Default(None))
    /** Database column start_date SqlType(DATETIME), Default(None) */
    val startDate: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date", O.Default(None))
    /** Database column end_date SqlType(DATETIME), Default(None) */
    val endDate: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date", O.Default(None))
    /** Database column start_time SqlType(TIME), Default(None) */
    val startTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("start_time", O.Default(None))
    /** Database column end_time SqlType(TIME), Default(None) */
    val endTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("end_time", O.Default(None))
    /** Database column available_days SqlType(VARCHAR), Length(255,true), Default(None) */
    val availableDays: Rep[Option[String]] = column[Option[String]]("available_days", O.Length(255,varying=true), O.Default(None))
    /** Database column apply_to_platform SqlType(INT), Default(None) */
    val applyToPlatform: Rep[Option[Int]] = column[Option[Int]]("apply_to_platform", O.Default(None))
    /** Database column apply_to_delivery_pickup SqlType(INT), Default(None) */
    val applyToDeliveryPickup: Rep[Option[Int]] = column[Option[Int]]("apply_to_delivery_pickup", O.Default(None))
    /** Database column exclude_promos SqlType(TEXT), Default(None) */
    val excludePromos: Rep[Option[String]] = column[Option[String]]("exclude_promos", O.Default(None))
    /** Database column promotion_result_type SqlType(INT), Default(None) */
    val promotionResultType: Rep[Option[Int]] = column[Option[Int]]("promotion_result_type", O.Default(None))
    /** Database column promotion_condition_type SqlType(INT), Default(None) */
    val promotionConditionType: Rep[Option[Int]] = column[Option[Int]]("promotion_condition_type", O.Default(None))
    /** Database column promo_order SqlType(INT), Default(None) */
    val promoOrder: Rep[Option[Int]] = column[Option[Int]]("promo_order", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(255,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column condition_amount SqlType(FLOAT), Default(None) */
    val conditionAmount: Rep[Option[Float]] = column[Option[Float]]("condition_amount", O.Default(None))
    /** Database column condition_amount_type SqlType(INT), Default(None) */
    val conditionAmountType: Rep[Option[Int]] = column[Option[Int]]("condition_amount_type", O.Default(None))
    /** Database column condition_quantity SqlType(INT), Default(None) */
    val conditionQuantity: Rep[Option[Int]] = column[Option[Int]]("condition_quantity", O.Default(None))
    /** Database column condition_item_ids SqlType(TEXT), Default(None) */
    val conditionItemIds: Rep[Option[String]] = column[Option[String]]("condition_item_ids", O.Default(None))
    /** Database column condition_category_ids SqlType(TEXT), Default(None) */
    val conditionCategoryIds: Rep[Option[String]] = column[Option[String]]("condition_category_ids", O.Default(None))
    /** Database column result_amount SqlType(FLOAT), Default(None) */
    val resultAmount: Rep[Option[Float]] = column[Option[Float]]("result_amount", O.Default(None))
    /** Database column result_amount_type SqlType(INT), Default(None) */
    val resultAmountType: Rep[Option[Int]] = column[Option[Int]]("result_amount_type", O.Default(None))
    /** Database column result_item_ids SqlType(TEXT), Default(None) */
    val resultItemIds: Rep[Option[String]] = column[Option[String]]("result_item_ids", O.Default(None))
    /** Database column result_category_ids SqlType(TEXT), Default(None) */
    val resultCategoryIds: Rep[Option[String]] = column[Option[String]]("result_category_ids", O.Default(None))
    /** Database column result_quantity SqlType(INT), Default(None) */
    val resultQuantity: Rep[Option[Int]] = column[Option[Int]]("result_quantity", O.Default(None))
    /** Database column promotion_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val promotionReference: Rep[Option[String]] = column[Option[String]]("promotion_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column applied_absolute_discount_amount SqlType(FLOAT), Default(None) */
    val appliedAbsoluteDiscountAmount: Rep[Option[Float]] = column[Option[Float]]("applied_absolute_discount_amount", O.Default(None))
    /** Database column applied_order_item_reference SqlType(TEXT), Default(None) */
    val appliedOrderItemReference: Rep[Option[String]] = column[Option[String]]("applied_order_item_reference", O.Default(None))
    /** Database column applied_order_promotion_type SqlType(INT), Default(None) */
    val appliedOrderPromotionType: Rep[Option[Int]] = column[Option[Int]]("applied_order_promotion_type", O.Default(None))
    /** Database column is_customise_start_end_time SqlType(INT), Default(None) */
    val isCustomiseStartEndTime: Rep[Option[Int]] = column[Option[Int]]("is_customise_start_end_time", O.Default(None))
    /** Database column is_customise_available_day SqlType(INT), Default(None) */
    val isCustomiseAvailableDay: Rep[Option[Int]] = column[Option[Int]]("is_customise_available_day", O.Default(None))
    /** Database column is_customise_start_end_date SqlType(INT), Default(Some(0)) */
    val isCustomiseStartEndDate: Rep[Option[Int]] = column[Option[Int]]("is_customise_start_end_date", O.Default(Some(0)))
    /** Database column is_show_on_shopping_cart SqlType(INT), Default(Some(0)) */
    val isShowOnShoppingCart: Rep[Option[Int]] = column[Option[Int]]("is_show_on_shopping_cart", O.Default(Some(0)))
    /** Database column stackable_option SqlType(INT), Default(Some(0)) */
    val stackableOption: Rep[Option[Int]] = column[Option[Int]]("stackable_option", O.Default(Some(0)))

    /** Foreign key referencing StoreOrder (database name fk_order_promotion_1) */
    lazy val storeOrderFk = foreignKey("fk_order_promotion_1", storeOrderId :: HNil, StoreOrder)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderPromotionv3 */
  lazy val OrderPromotionv3 = new TableQuery(tag => new OrderPromotionv3(tag))

  /** Entity class storing rows of table OrderTag
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param orderItemId Database column order_item_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param tagSubitemReference Database column tag_subitem_reference SqlType(VARCHAR), Length(32,true), Default(None) */
  case class OrderTagRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, orderItemId: Option[String] = None, tagSubitemReference: Option[String] = None)
  /** GetResult implicit for fetching OrderTagRow objects using plain SQL queries */
  implicit def GetResultOrderTagRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[OrderTagRow] = GR{
    prs => import prs._
    OrderTagRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String]))
  }
  /** Table description of table order_tag. Objects of this class serve as prototypes for rows in queries. */
  class OrderTag(_tableTag: Tag) extends Table[OrderTagRow](_tableTag, "order_tag") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, orderItemId, tagSubitemReference) <> (OrderTagRow.tupled, OrderTagRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, orderItemId, tagSubitemReference).shaped.<>({r=>import r._; _1.map(_=> OrderTagRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column order_item_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val orderItemId: Rep[Option[String]] = column[Option[String]]("order_item_id", O.Length(32,varying=true), O.Default(None))
    /** Database column tag_subitem_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val tagSubitemReference: Rep[Option[String]] = column[Option[String]]("tag_subitem_reference", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing OrderItem (database name fk_order_tag_subitem) */
    lazy val orderItemFk = foreignKey("fk_order_tag_subitem", orderItemId, OrderItem)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderTag */
  lazy val OrderTag = new TableQuery(tag => new OrderTag(tag))

  /** Entity class storing rows of table OrderTaxAndCharge
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param amount Database column amount SqlType(FLOAT), Default(None)
   *  @param applyTo Database column apply_to SqlType(INT), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param inclusive Database column inclusive SqlType(INT), Default(None)
   *  @param external Database column external SqlType(INT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param dpType Database column dp_type SqlType(INT), Default(None)
   *  @param applyToDelivery Database column apply_to_delivery SqlType(INT), Default(None)
   *  @param taxOrder Database column tax_order SqlType(INT), Default(Some(0)) */
  case class OrderTaxAndChargeRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, amount: Option[Float] = None, applyTo: Option[Int] = None, `type`: Option[Int] = None, description: Option[String] = None, inclusive: Option[Int] = None, external: Option[Int] = None, storeOrderId: Option[String] = None, dpType: Option[Int] = None, applyToDelivery: Option[Int] = None, taxOrder: Option[Int] = Some(0))
  /** GetResult implicit for fetching OrderTaxAndChargeRow objects using plain SQL queries */
  implicit def GetResultOrderTaxAndChargeRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[OrderTaxAndChargeRow] = GR{
    prs => import prs._
    OrderTaxAndChargeRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Float], <<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table order_tax_and_charge. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class OrderTaxAndCharge(_tableTag: Tag) extends Table[OrderTaxAndChargeRow](_tableTag, "order_tax_and_charge") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, amount, applyTo, `type`, description, inclusive, external, storeOrderId, dpType, applyToDelivery, taxOrder) <> (OrderTaxAndChargeRow.tupled, OrderTaxAndChargeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, amount, applyTo, `type`, description, inclusive, external, storeOrderId, dpType, applyToDelivery, taxOrder).shaped.<>({r=>import r._; _1.map(_=> OrderTaxAndChargeRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column amount SqlType(FLOAT), Default(None) */
    val amount: Rep[Option[Float]] = column[Option[Float]]("amount", O.Default(None))
    /** Database column apply_to SqlType(INT), Default(None) */
    val applyTo: Rep[Option[Int]] = column[Option[Int]]("apply_to", O.Default(None))
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column inclusive SqlType(INT), Default(None) */
    val inclusive: Rep[Option[Int]] = column[Option[Int]]("inclusive", O.Default(None))
    /** Database column external SqlType(INT), Default(None) */
    val external: Rep[Option[Int]] = column[Option[Int]]("external", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column dp_type SqlType(INT), Default(None) */
    val dpType: Rep[Option[Int]] = column[Option[Int]]("dp_type", O.Default(None))
    /** Database column apply_to_delivery SqlType(INT), Default(None) */
    val applyToDelivery: Rep[Option[Int]] = column[Option[Int]]("apply_to_delivery", O.Default(None))
    /** Database column tax_order SqlType(INT), Default(Some(0)) */
    val taxOrder: Rep[Option[Int]] = column[Option[Int]]("tax_order", O.Default(Some(0)))

    /** Foreign key referencing StoreOrder (database name fk_order_tax_and_charge_1) */
    lazy val storeOrderFk = foreignKey("fk_order_tax_and_charge_1", storeOrderId, StoreOrder)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table OrderTaxAndCharge */
  lazy val OrderTaxAndCharge = new TableQuery(tag => new OrderTaxAndCharge(tag))

  /** Entity class storing rows of table Partner
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param name Database column name SqlType(TEXT), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param email Database column email SqlType(TEXT), Default(None)
   *  @param apiKey Database column api_key SqlType(TEXT), Default(None)
   *  @param requestUrl Database column request_url SqlType(TEXT), Default(None)
   *  @param changeUrl Database column change_url SqlType(TEXT), Default(None)
   *  @param cancelUrl Database column cancel_url SqlType(TEXT), Default(None)
   *  @param statusUrl Database column status_url SqlType(TEXT), Default(None)
   *  @param isActive Database column is_active SqlType(INT), Default(None)
   *  @param communicationMode Database column communication_mode SqlType(INT), Default(Some(0))
   *  @param commonApiCredentials Database column common_api_credentials SqlType(INT), Default(Some(0))
   *  @param secretKey Database column secret_key SqlType(TEXT), Default(None)
   *  @param locationNames Database column location_names SqlType(TEXT), Default(None)
   *  @param country Database column country SqlType(TEXT), Default(None) */
  case class PartnerRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, name: Option[String] = None, phone: Option[String] = None, email: Option[String] = None, apiKey: Option[String] = None, requestUrl: Option[String] = None, changeUrl: Option[String] = None, cancelUrl: Option[String] = None, statusUrl: Option[String] = None, isActive: Option[Int] = None, communicationMode: Option[Int] = Some(0), commonApiCredentials: Option[Int] = Some(0), secretKey: Option[String] = None, locationNames: Option[String] = None, country: Option[String] = None)
  /** GetResult implicit for fetching PartnerRow objects using plain SQL queries */
  implicit def GetResultPartnerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[PartnerRow] = GR{
    prs => import prs._
    PartnerRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table partner. Objects of this class serve as prototypes for rows in queries. */
  class Partner(_tableTag: Tag) extends Table[PartnerRow](_tableTag, "partner") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, name, phone, email, apiKey, requestUrl, changeUrl, cancelUrl, statusUrl, isActive, communicationMode, commonApiCredentials, secretKey, locationNames, country) <> (PartnerRow.tupled, PartnerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, name, phone, email, apiKey, requestUrl, changeUrl, cancelUrl, statusUrl, isActive, communicationMode, commonApiCredentials, secretKey, locationNames, country).shaped.<>({r=>import r._; _1.map(_=> PartnerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column name SqlType(TEXT), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(32,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(32,varying=true), O.Default(None))
    /** Database column email SqlType(TEXT), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Default(None))
    /** Database column api_key SqlType(TEXT), Default(None) */
    val apiKey: Rep[Option[String]] = column[Option[String]]("api_key", O.Default(None))
    /** Database column request_url SqlType(TEXT), Default(None) */
    val requestUrl: Rep[Option[String]] = column[Option[String]]("request_url", O.Default(None))
    /** Database column change_url SqlType(TEXT), Default(None) */
    val changeUrl: Rep[Option[String]] = column[Option[String]]("change_url", O.Default(None))
    /** Database column cancel_url SqlType(TEXT), Default(None) */
    val cancelUrl: Rep[Option[String]] = column[Option[String]]("cancel_url", O.Default(None))
    /** Database column status_url SqlType(TEXT), Default(None) */
    val statusUrl: Rep[Option[String]] = column[Option[String]]("status_url", O.Default(None))
    /** Database column is_active SqlType(INT), Default(None) */
    val isActive: Rep[Option[Int]] = column[Option[Int]]("is_active", O.Default(None))
    /** Database column communication_mode SqlType(INT), Default(Some(0)) */
    val communicationMode: Rep[Option[Int]] = column[Option[Int]]("communication_mode", O.Default(Some(0)))
    /** Database column common_api_credentials SqlType(INT), Default(Some(0)) */
    val commonApiCredentials: Rep[Option[Int]] = column[Option[Int]]("common_api_credentials", O.Default(Some(0)))
    /** Database column secret_key SqlType(TEXT), Default(None) */
    val secretKey: Rep[Option[String]] = column[Option[String]]("secret_key", O.Default(None))
    /** Database column location_names SqlType(TEXT), Default(None) */
    val locationNames: Rep[Option[String]] = column[Option[String]]("location_names", O.Default(None))
    /** Database column country SqlType(TEXT), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Default(None))
  }
  /** Collection-like TableQuery object for table Partner */
  lazy val Partner = new TableQuery(tag => new Partner(tag))

  /** Entity class storing rows of table PartnerRequest
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param partnerId Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param ackKey Database column ack_key SqlType(TEXT), Default(None)
   *  @param status Database column status SqlType(INT), Default(None)
   *  @param deliveryRequestId Database column delivery_request_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param lastSentMail Database column last_sent_mail SqlType(DATETIME), Default(None) */
  case class PartnerRequestRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, partnerId: Option[String] = None, ackKey: Option[String] = None, status: Option[Int] = None, deliveryRequestId: Option[String] = None, lastSentMail: Option[DateTime] = None)
  /** GetResult implicit for fetching PartnerRequestRow objects using plain SQL queries */
  implicit def GetResultPartnerRequestRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[PartnerRequestRow] = GR{
    prs => import prs._
    PartnerRequestRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[DateTime]))
  }
  /** Table description of table partner_request. Objects of this class serve as prototypes for rows in queries. */
  class PartnerRequest(_tableTag: Tag) extends Table[PartnerRequestRow](_tableTag, "partner_request") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, partnerId, ackKey, status, deliveryRequestId, lastSentMail) <> (PartnerRequestRow.tupled, PartnerRequestRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, partnerId, ackKey, status, deliveryRequestId, lastSentMail).shaped.<>({r=>import r._; _1.map(_=> PartnerRequestRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column partner_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val partnerId: Rep[Option[String]] = column[Option[String]]("partner_id", O.Length(32,varying=true), O.Default(None))
    /** Database column ack_key SqlType(TEXT), Default(None) */
    val ackKey: Rep[Option[String]] = column[Option[String]]("ack_key", O.Default(None))
    /** Database column status SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
    /** Database column delivery_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val deliveryRequestId: Rep[Option[String]] = column[Option[String]]("delivery_request_id", O.Length(32,varying=true), O.Default(None))
    /** Database column last_sent_mail SqlType(DATETIME), Default(None) */
    val lastSentMail: Rep[Option[DateTime]] = column[Option[DateTime]]("last_sent_mail", O.Default(None))
  }
  /** Collection-like TableQuery object for table PartnerRequest */
  lazy val PartnerRequest = new TableQuery(tag => new PartnerRequest(tag))

  /** Entity class storing rows of table PartnerResponse
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param driverName Database column driver_name SqlType(TEXT), Default(None)
   *  @param driverPhone Database column driver_phone SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param vehicleNumber Database column vehicle_number SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param estimatedTime Database column estimated_time SqlType(DATETIME), Default(None)
   *  @param price Database column price SqlType(FLOAT), Default(None)
   *  @param currentLatitude Database column current_latitude SqlType(FLOAT), Default(None)
   *  @param currentLongitude Database column current_longitude SqlType(FLOAT), Default(None)
   *  @param partnerRequestId Database column partner_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class PartnerResponseRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, driverName: Option[String] = None, driverPhone: Option[String] = None, vehicleNumber: Option[String] = None, estimatedTime: Option[DateTime] = None, price: Option[Float] = None, currentLatitude: Option[Float] = None, currentLongitude: Option[Float] = None, partnerRequestId: Option[String] = None)
  /** GetResult implicit for fetching PartnerResponseRow objects using plain SQL queries */
  implicit def GetResultPartnerResponseRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[PartnerResponseRow] = GR{
    prs => import prs._
    PartnerResponseRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[DateTime], <<?[Float], <<?[Float], <<?[Float], <<?[String]))
  }
  /** Table description of table partner_response. Objects of this class serve as prototypes for rows in queries. */
  class PartnerResponse(_tableTag: Tag) extends Table[PartnerResponseRow](_tableTag, "partner_response") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, driverName, driverPhone, vehicleNumber, estimatedTime, price, currentLatitude, currentLongitude, partnerRequestId) <> (PartnerResponseRow.tupled, PartnerResponseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, driverName, driverPhone, vehicleNumber, estimatedTime, price, currentLatitude, currentLongitude, partnerRequestId).shaped.<>({r=>import r._; _1.map(_=> PartnerResponseRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column driver_name SqlType(TEXT), Default(None) */
    val driverName: Rep[Option[String]] = column[Option[String]]("driver_name", O.Default(None))
    /** Database column driver_phone SqlType(VARCHAR), Length(32,true), Default(None) */
    val driverPhone: Rep[Option[String]] = column[Option[String]]("driver_phone", O.Length(32,varying=true), O.Default(None))
    /** Database column vehicle_number SqlType(VARCHAR), Length(32,true), Default(None) */
    val vehicleNumber: Rep[Option[String]] = column[Option[String]]("vehicle_number", O.Length(32,varying=true), O.Default(None))
    /** Database column estimated_time SqlType(DATETIME), Default(None) */
    val estimatedTime: Rep[Option[DateTime]] = column[Option[DateTime]]("estimated_time", O.Default(None))
    /** Database column price SqlType(FLOAT), Default(None) */
    val price: Rep[Option[Float]] = column[Option[Float]]("price", O.Default(None))
    /** Database column current_latitude SqlType(FLOAT), Default(None) */
    val currentLatitude: Rep[Option[Float]] = column[Option[Float]]("current_latitude", O.Default(None))
    /** Database column current_longitude SqlType(FLOAT), Default(None) */
    val currentLongitude: Rep[Option[Float]] = column[Option[Float]]("current_longitude", O.Default(None))
    /** Database column partner_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val partnerRequestId: Rep[Option[String]] = column[Option[String]]("partner_request_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table PartnerResponse */
  lazy val PartnerResponse = new TableQuery(tag => new PartnerResponse(tag))

  /** Entity class storing rows of table Payment
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param paymentName Database column payment_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param publicInformation Database column public_information SqlType(TEXT), Default(None)
   *  @param privateInformation Database column private_information SqlType(TEXT), Default(None)
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param clientSecret Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param defaultName Database column default_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param isAvailable Database column is_available SqlType(INT), Default(None) */
  case class PaymentRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, `type`: Option[Int] = None, paymentName: Option[String] = None, publicInformation: Option[String] = None, privateInformation: Option[String] = None, clientId: Option[String] = None, clientSecret: Option[String] = None, defaultName: Option[String] = None, isAvailable: Option[Int] = None)
  /** GetResult implicit for fetching PaymentRow objects using plain SQL queries */
  implicit def GetResultPaymentRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[PaymentRow] = GR{
    prs => import prs._
    PaymentRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table payment. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Payment(_tableTag: Tag) extends Table[PaymentRow](_tableTag, "payment") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, `type`, paymentName, publicInformation, privateInformation, clientId, clientSecret, defaultName, isAvailable) <> (PaymentRow.tupled, PaymentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, `type`, paymentName, publicInformation, privateInformation, clientId, clientSecret, defaultName, isAvailable).shaped.<>({r=>import r._; _1.map(_=> PaymentRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column payment_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentName: Rep[Option[String]] = column[Option[String]]("payment_name", O.Length(255,varying=true), O.Default(None))
    /** Database column public_information SqlType(TEXT), Default(None) */
    val publicInformation: Rep[Option[String]] = column[Option[String]]("public_information", O.Default(None))
    /** Database column private_information SqlType(TEXT), Default(None) */
    val privateInformation: Rep[Option[String]] = column[Option[String]]("private_information", O.Default(None))
    /** Database column client_id SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("client_id", O.Length(255,varying=true), O.Default(None))
    /** Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientSecret: Rep[Option[String]] = column[Option[String]]("client_secret", O.Length(255,varying=true), O.Default(None))
    /** Database column default_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val defaultName: Rep[Option[String]] = column[Option[String]]("default_name", O.Length(255,varying=true), O.Default(None))
    /** Database column is_available SqlType(INT), Default(None) */
    val isAvailable: Rep[Option[Int]] = column[Option[Int]]("is_available", O.Default(None))
  }
  /** Collection-like TableQuery object for table Payment */
  lazy val Payment = new TableQuery(tag => new Payment(tag))

  /** Entity class storing rows of table PaymentOption
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param displayOnShoppingCart Database column display_on_shopping_cart SqlType(INT), Default(None)
   *  @param publicInformation Database column public_information SqlType(TEXT), Default(None)
   *  @param privateInformation Database column private_information SqlType(TEXT), Default(None)
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param clientSecret Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentId Database column payment_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param accountNumber Database column account_number SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentName Database column payment_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param isEnabled Database column is_enabled SqlType(INT), Default(Some(0))
   *  @param paymentLinkStatus Database column payment_link_status SqlType(INT), Default(None) */
  case class PaymentOptionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, `type`: Option[Int] = None, displayOnShoppingCart: Option[Int] = None, publicInformation: Option[String] = None, privateInformation: Option[String] = None, clientId: Option[String] = None, clientSecret: Option[String] = None, menuId: Option[String] = None, paymentId: Option[String] = None, accountNumber: Option[String] = None, paymentName: Option[String] = None, isEnabled: Option[Int] = Some(0), paymentLinkStatus: Option[Int] = None)
  /** GetResult implicit for fetching PaymentOptionRow objects using plain SQL queries */
  implicit def GetResultPaymentOptionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[PaymentOptionRow] = GR{
    prs => import prs._
    PaymentOptionRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table payment_option. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class PaymentOption(_tableTag: Tag) extends Table[PaymentOptionRow](_tableTag, "payment_option") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, `type`, displayOnShoppingCart, publicInformation, privateInformation, clientId, clientSecret, menuId, paymentId, accountNumber, paymentName, isEnabled, paymentLinkStatus) <> (PaymentOptionRow.tupled, PaymentOptionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, `type`, displayOnShoppingCart, publicInformation, privateInformation, clientId, clientSecret, menuId, paymentId, accountNumber, paymentName, isEnabled, paymentLinkStatus).shaped.<>({r=>import r._; _1.map(_=> PaymentOptionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column display_on_shopping_cart SqlType(INT), Default(None) */
    val displayOnShoppingCart: Rep[Option[Int]] = column[Option[Int]]("display_on_shopping_cart", O.Default(None))
    /** Database column public_information SqlType(TEXT), Default(None) */
    val publicInformation: Rep[Option[String]] = column[Option[String]]("public_information", O.Default(None))
    /** Database column private_information SqlType(TEXT), Default(None) */
    val privateInformation: Rep[Option[String]] = column[Option[String]]("private_information", O.Default(None))
    /** Database column client_id SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("client_id", O.Length(255,varying=true), O.Default(None))
    /** Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientSecret: Rep[Option[String]] = column[Option[String]]("client_secret", O.Length(255,varying=true), O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentId: Rep[Option[String]] = column[Option[String]]("payment_id", O.Length(32,varying=true), O.Default(None))
    /** Database column account_number SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountNumber: Rep[Option[String]] = column[Option[String]]("account_number", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentName: Rep[Option[String]] = column[Option[String]]("payment_name", O.Length(255,varying=true), O.Default(None))
    /** Database column is_enabled SqlType(INT), Default(Some(0)) */
    val isEnabled: Rep[Option[Int]] = column[Option[Int]]("is_enabled", O.Default(Some(0)))
    /** Database column payment_link_status SqlType(INT), Default(None) */
    val paymentLinkStatus: Rep[Option[Int]] = column[Option[Int]]("payment_link_status", O.Default(None))

    /** Foreign key referencing Menu (database name fk_payment_option_1) */
    lazy val menuFk = foreignKey("fk_payment_option_1", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Payment (database name kf_payment_option_2) */
    lazy val paymentFk = foreignKey("kf_payment_option_2", paymentId, Payment)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PaymentOption */
  lazy val PaymentOption = new TableQuery(tag => new PaymentOption(tag))

  /** Entity class storing rows of table PaymentRateHistory
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param percentCut Database column percent_cut SqlType(FLOAT), Default(None)
   *  @param dollarCut Database column dollar_cut SqlType(FLOAT), Default(None)
   *  @param paymentRateType Database column payment_rate_type SqlType(INT), Default(None) */
  case class PaymentRateHistoryRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, percentCut: Option[Float] = None, dollarCut: Option[Float] = None, paymentRateType: Option[Int] = None)
  /** GetResult implicit for fetching PaymentRateHistoryRow objects using plain SQL queries */
  implicit def GetResultPaymentRateHistoryRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[PaymentRateHistoryRow] = GR{
    prs => import prs._
    PaymentRateHistoryRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Float], <<?[Float], <<?[Int]))
  }
  /** Table description of table payment_rate_history. Objects of this class serve as prototypes for rows in queries. */
  class PaymentRateHistory(_tableTag: Tag) extends Table[PaymentRateHistoryRow](_tableTag, "payment_rate_history") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, percentCut, dollarCut, paymentRateType) <> (PaymentRateHistoryRow.tupled, PaymentRateHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, percentCut, dollarCut, paymentRateType).shaped.<>({r=>import r._; _1.map(_=> PaymentRateHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column percent_cut SqlType(FLOAT), Default(None) */
    val percentCut: Rep[Option[Float]] = column[Option[Float]]("percent_cut", O.Default(None))
    /** Database column dollar_cut SqlType(FLOAT), Default(None) */
    val dollarCut: Rep[Option[Float]] = column[Option[Float]]("dollar_cut", O.Default(None))
    /** Database column payment_rate_type SqlType(INT), Default(None) */
    val paymentRateType: Rep[Option[Int]] = column[Option[Int]]("payment_rate_type", O.Default(None))
  }
  /** Collection-like TableQuery object for table PaymentRateHistory */
  lazy val PaymentRateHistory = new TableQuery(tag => new PaymentRateHistory(tag))

  /** Entity class storing rows of table Permission
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param permissionType Database column permission_type SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param accessType Database column access_type SqlType(INT), Default(None)
   *  @param permissionId Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class PermissionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, permissionType: Option[String] = None, accessType: Option[Int] = None, permissionId: Option[String] = None)
  /** GetResult implicit for fetching PermissionRow objects using plain SQL queries */
  implicit def GetResultPermissionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[PermissionRow] = GR{
    prs => import prs._
    PermissionRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table permission. Objects of this class serve as prototypes for rows in queries. */
  class Permission(_tableTag: Tag) extends Table[PermissionRow](_tableTag, "permission") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, permissionType, accessType, permissionId) <> (PermissionRow.tupled, PermissionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, permissionType, accessType, permissionId).shaped.<>({r=>import r._; _1.map(_=> PermissionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column permission_type SqlType(VARCHAR), Length(45,true), Default(None) */
    val permissionType: Rep[Option[String]] = column[Option[String]]("permission_type", O.Length(45,varying=true), O.Default(None))
    /** Database column access_type SqlType(INT), Default(None) */
    val accessType: Rep[Option[Int]] = column[Option[Int]]("access_type", O.Default(None))
    /** Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val permissionId: Rep[Option[String]] = column[Option[String]]("permission_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Permission (database name p_fk_1) */
    lazy val permissionFk = foreignKey("p_fk_1", permissionId, Permission)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Permission */
  lazy val Permission = new TableQuery(tag => new Permission(tag))

  /** Entity class storing rows of table PersistentLogins
   *  @param username Database column username SqlType(VARCHAR), Length(64,true)
   *  @param series Database column series SqlType(VARCHAR), PrimaryKey, Length(64,true)
   *  @param token Database column token SqlType(VARCHAR), Length(64,true)
   *  @param lastUsed Database column last_used SqlType(TIMESTAMP) */
  case class PersistentLoginsRow(username: String, series: String, token: String, lastUsed: DateTime)
  /** GetResult implicit for fetching PersistentLoginsRow objects using plain SQL queries */
  implicit def GetResultPersistentLoginsRow(implicit e0: GR[String], e1: GR[DateTime]): GR[PersistentLoginsRow] = GR{
    prs => import prs._
    PersistentLoginsRow.tupled((<<[String], <<[String], <<[String], <<[DateTime]))
  }
  /** Table description of table persistent_logins. Objects of this class serve as prototypes for rows in queries. */
  class PersistentLogins(_tableTag: Tag) extends Table[PersistentLoginsRow](_tableTag, "persistent_logins") {
    def * = (username, series, token, lastUsed) <> (PersistentLoginsRow.tupled, PersistentLoginsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(username), Rep.Some(series), Rep.Some(token), Rep.Some(lastUsed)).shaped.<>({r=>import r._; _1.map(_=> PersistentLoginsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column username SqlType(VARCHAR), Length(64,true) */
    val username: Rep[String] = column[String]("username", O.Length(64,varying=true))
    /** Database column series SqlType(VARCHAR), PrimaryKey, Length(64,true) */
    val series: Rep[String] = column[String]("series", O.PrimaryKey, O.Length(64,varying=true))
    /** Database column token SqlType(VARCHAR), Length(64,true) */
    val token: Rep[String] = column[String]("token", O.Length(64,varying=true))
    /** Database column last_used SqlType(TIMESTAMP) */
    val lastUsed: Rep[DateTime] = column[DateTime]("last_used")
  }
  /** Collection-like TableQuery object for table PersistentLogins */
  lazy val PersistentLogins = new TableQuery(tag => new PersistentLogins(tag))

  /** Row type of table Promotion */
  type PromotionRow = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[Float],HCons[Option[String],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Time],HCons[Option[java.sql.Time],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for PromotionRow providing default values if available in the database schema. */
  def PromotionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, conditionalIdsType: Option[Int] = None, conditionalIds: Option[String] = None, conditionalAmount: Option[Float] = None, conditionalType: Option[Int] = None, promotionalAmountType: Option[Int] = None, promotionalAmount: Option[Float] = None, name: Option[String] = None, availability: Option[Int] = None, startDateTime: Option[DateTime] = None, endDateTime: Option[DateTime] = None, promotionalIds: Option[String] = None, promotionalType: Option[Int] = None, codes: Option[String] = None, description: Option[String] = None, codesInstruction: Option[String] = None, dayInWeek: Option[String] = None, intervalStartTime: Option[java.sql.Time] = None, intervalEndTime: Option[java.sql.Time] = None, showOnShoppingCart: Option[Int] = Some(1)): PromotionRow = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: menuId :: conditionalIdsType :: conditionalIds :: conditionalAmount :: conditionalType :: promotionalAmountType :: promotionalAmount :: name :: availability :: startDateTime :: endDateTime :: promotionalIds :: promotionalType :: codes :: description :: codesInstruction :: dayInWeek :: intervalStartTime :: intervalEndTime :: showOnShoppingCart :: HNil
  }
  /** GetResult implicit for fetching PromotionRow objects using plain SQL queries */
  implicit def GetResultPromotionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]], e5: GR[Option[java.sql.Time]]): GR[PromotionRow] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[Float] :: <<?[String] :: <<?[Int] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Time] :: <<?[java.sql.Time] :: <<?[Int] :: HNil
  }
  /** Table description of table promotion. Objects of this class serve as prototypes for rows in queries. */
  class Promotion(_tableTag: Tag) extends Table[PromotionRow](_tableTag, "promotion") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: menuId :: conditionalIdsType :: conditionalIds :: conditionalAmount :: conditionalType :: promotionalAmountType :: promotionalAmount :: name :: availability :: startDateTime :: endDateTime :: promotionalIds :: promotionalType :: codes :: description :: codesInstruction :: dayInWeek :: intervalStartTime :: intervalEndTime :: showOnShoppingCart :: HNil

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
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column conditional_ids_type SqlType(INT), Default(None) */
    val conditionalIdsType: Rep[Option[Int]] = column[Option[Int]]("conditional_ids_type", O.Default(None))
    /** Database column conditional_ids SqlType(TEXT), Default(None) */
    val conditionalIds: Rep[Option[String]] = column[Option[String]]("conditional_ids", O.Default(None))
    /** Database column conditional_amount SqlType(FLOAT), Default(None) */
    val conditionalAmount: Rep[Option[Float]] = column[Option[Float]]("conditional_amount", O.Default(None))
    /** Database column conditional_type SqlType(INT), Default(None) */
    val conditionalType: Rep[Option[Int]] = column[Option[Int]]("conditional_type", O.Default(None))
    /** Database column promotional_amount_type SqlType(INT), Default(None) */
    val promotionalAmountType: Rep[Option[Int]] = column[Option[Int]]("promotional_amount_type", O.Default(None))
    /** Database column promotional_amount SqlType(FLOAT), Default(None) */
    val promotionalAmount: Rep[Option[Float]] = column[Option[Float]]("promotional_amount", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column availability SqlType(INT), Default(None) */
    val availability: Rep[Option[Int]] = column[Option[Int]]("availability", O.Default(None))
    /** Database column start_date_time SqlType(DATETIME), Default(None) */
    val startDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date_time", O.Default(None))
    /** Database column end_date_time SqlType(DATETIME), Default(None) */
    val endDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date_time", O.Default(None))
    /** Database column promotional_ids SqlType(TEXT), Default(None) */
    val promotionalIds: Rep[Option[String]] = column[Option[String]]("promotional_ids", O.Default(None))
    /** Database column promotional_type SqlType(INT), Default(None) */
    val promotionalType: Rep[Option[Int]] = column[Option[Int]]("promotional_type", O.Default(None))
    /** Database column codes SqlType(TEXT), Default(None) */
    val codes: Rep[Option[String]] = column[Option[String]]("codes", O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column codes_instruction SqlType(TEXT), Default(None) */
    val codesInstruction: Rep[Option[String]] = column[Option[String]]("codes_instruction", O.Default(None))
    /** Database column day_in_week SqlType(VARCHAR), Length(225,true), Default(None) */
    val dayInWeek: Rep[Option[String]] = column[Option[String]]("day_in_week", O.Length(225,varying=true), O.Default(None))
    /** Database column interval_start_time SqlType(TIME), Default(None) */
    val intervalStartTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("interval_start_time", O.Default(None))
    /** Database column interval_end_time SqlType(TIME), Default(None) */
    val intervalEndTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("interval_end_time", O.Default(None))
    /** Database column show_on_shopping_cart SqlType(INT), Default(Some(1)) */
    val showOnShoppingCart: Rep[Option[Int]] = column[Option[Int]]("show_on_shopping_cart", O.Default(Some(1)))

    /** Foreign key referencing Menu (database name fk_promotion_1) */
    lazy val menuFk = foreignKey("fk_promotion_1", menuId :: HNil, Menu)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Promotion */
  lazy val Promotion = new TableQuery(tag => new Promotion(tag))

  /** Row type of table Promotionv3 */
  type Promotionv3Row = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[java.sql.Time],HCons[Option[java.sql.Time],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for Promotionv3Row providing default values if available in the database schema. */
  def Promotionv3Row(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, enablePromoCode: Option[Int] = None, promoCodes: Option[String] = None, promoApplyTo: Option[Int] = None, customerUseTimes: Option[Int] = None, promoCodeLimit: Option[Int] = None, availableOn: Option[Int] = None, startDate: Option[DateTime] = None, endDate: Option[DateTime] = None, startTime: Option[java.sql.Time] = None, endTime: Option[java.sql.Time] = None, availableDays: Option[String] = None, applyToPlatform: Option[Int] = None, applyToDeliveryPickup: Option[Int] = None, excludePromos: Option[String] = None, promotionResultType: Option[Int] = None, promotionConditionType: Option[Int] = None, promoOrder: Option[Int] = None, description: Option[String] = None, name: Option[String] = None, conditionAmount: Option[Float] = None, conditionAmountType: Option[Int] = None, conditionQuantity: Option[Int] = None, conditionItemIds: Option[String] = None, conditionCategoryIds: Option[String] = None, resultAmount: Option[Float] = None, resultAmountType: Option[Int] = None, resultItemIds: Option[String] = None, resultCategoryIds: Option[String] = None, resultQuantity: Option[Int] = None, menuId: Option[String] = None, isCustomiseStartEndTime: Option[Int] = None, isCustomiseAvailableDay: Option[Int] = None, isCustomiseStartEndDate: Option[Int] = Some(0), isShowOnShoppingCart: Option[Int] = Some(0), stackableOption: Option[Int] = Some(0)): Promotionv3Row = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: enablePromoCode :: promoCodes :: promoApplyTo :: customerUseTimes :: promoCodeLimit :: availableOn :: startDate :: endDate :: startTime :: endTime :: availableDays :: applyToPlatform :: applyToDeliveryPickup :: excludePromos :: promotionResultType :: promotionConditionType :: promoOrder :: description :: name :: conditionAmount :: conditionAmountType :: conditionQuantity :: conditionItemIds :: conditionCategoryIds :: resultAmount :: resultAmountType :: resultItemIds :: resultCategoryIds :: resultQuantity :: menuId :: isCustomiseStartEndTime :: isCustomiseAvailableDay :: isCustomiseStartEndDate :: isShowOnShoppingCart :: stackableOption :: HNil
  }
  /** GetResult implicit for fetching Promotionv3Row objects using plain SQL queries */
  implicit def GetResultPromotionv3Row(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[java.sql.Time]], e5: GR[Option[Float]]): GR[Promotionv3Row] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[DateTime] :: <<?[java.sql.Time] :: <<?[java.sql.Time] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table promotionv3. Objects of this class serve as prototypes for rows in queries. */
  class Promotionv3(_tableTag: Tag) extends Table[Promotionv3Row](_tableTag, "promotionv3") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: enablePromoCode :: promoCodes :: promoApplyTo :: customerUseTimes :: promoCodeLimit :: availableOn :: startDate :: endDate :: startTime :: endTime :: availableDays :: applyToPlatform :: applyToDeliveryPickup :: excludePromos :: promotionResultType :: promotionConditionType :: promoOrder :: description :: name :: conditionAmount :: conditionAmountType :: conditionQuantity :: conditionItemIds :: conditionCategoryIds :: resultAmount :: resultAmountType :: resultItemIds :: resultCategoryIds :: resultQuantity :: menuId :: isCustomiseStartEndTime :: isCustomiseAvailableDay :: isCustomiseStartEndDate :: isShowOnShoppingCart :: stackableOption :: HNil

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
    /** Database column enable_promo_code SqlType(INT), Default(None) */
    val enablePromoCode: Rep[Option[Int]] = column[Option[Int]]("enable_promo_code", O.Default(None))
    /** Database column promo_codes SqlType(TEXT), Default(None) */
    val promoCodes: Rep[Option[String]] = column[Option[String]]("promo_codes", O.Default(None))
    /** Database column promo_apply_to SqlType(INT), Default(None) */
    val promoApplyTo: Rep[Option[Int]] = column[Option[Int]]("promo_apply_to", O.Default(None))
    /** Database column customer_use_times SqlType(INT), Default(None) */
    val customerUseTimes: Rep[Option[Int]] = column[Option[Int]]("customer_use_times", O.Default(None))
    /** Database column promo_code_limit SqlType(INT), Default(None) */
    val promoCodeLimit: Rep[Option[Int]] = column[Option[Int]]("promo_code_limit", O.Default(None))
    /** Database column available_on SqlType(INT), Default(None) */
    val availableOn: Rep[Option[Int]] = column[Option[Int]]("available_on", O.Default(None))
    /** Database column start_date SqlType(DATETIME), Default(None) */
    val startDate: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date", O.Default(None))
    /** Database column end_date SqlType(DATETIME), Default(None) */
    val endDate: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date", O.Default(None))
    /** Database column start_time SqlType(TIME), Default(None) */
    val startTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("start_time", O.Default(None))
    /** Database column end_time SqlType(TIME), Default(None) */
    val endTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("end_time", O.Default(None))
    /** Database column available_days SqlType(VARCHAR), Length(255,true), Default(None) */
    val availableDays: Rep[Option[String]] = column[Option[String]]("available_days", O.Length(255,varying=true), O.Default(None))
    /** Database column apply_to_platform SqlType(INT), Default(None) */
    val applyToPlatform: Rep[Option[Int]] = column[Option[Int]]("apply_to_platform", O.Default(None))
    /** Database column apply_to_delivery_pickup SqlType(INT), Default(None) */
    val applyToDeliveryPickup: Rep[Option[Int]] = column[Option[Int]]("apply_to_delivery_pickup", O.Default(None))
    /** Database column exclude_promos SqlType(TEXT), Default(None) */
    val excludePromos: Rep[Option[String]] = column[Option[String]]("exclude_promos", O.Default(None))
    /** Database column promotion_result_type SqlType(INT), Default(None) */
    val promotionResultType: Rep[Option[Int]] = column[Option[Int]]("promotion_result_type", O.Default(None))
    /** Database column promotion_condition_type SqlType(INT), Default(None) */
    val promotionConditionType: Rep[Option[Int]] = column[Option[Int]]("promotion_condition_type", O.Default(None))
    /** Database column promo_order SqlType(INT), Default(None) */
    val promoOrder: Rep[Option[Int]] = column[Option[Int]]("promo_order", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(255,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column condition_amount SqlType(FLOAT), Default(None) */
    val conditionAmount: Rep[Option[Float]] = column[Option[Float]]("condition_amount", O.Default(None))
    /** Database column condition_amount_type SqlType(INT), Default(None) */
    val conditionAmountType: Rep[Option[Int]] = column[Option[Int]]("condition_amount_type", O.Default(None))
    /** Database column condition_quantity SqlType(INT), Default(None) */
    val conditionQuantity: Rep[Option[Int]] = column[Option[Int]]("condition_quantity", O.Default(None))
    /** Database column condition_item_ids SqlType(TEXT), Default(None) */
    val conditionItemIds: Rep[Option[String]] = column[Option[String]]("condition_item_ids", O.Default(None))
    /** Database column condition_category_ids SqlType(TEXT), Default(None) */
    val conditionCategoryIds: Rep[Option[String]] = column[Option[String]]("condition_category_ids", O.Default(None))
    /** Database column result_amount SqlType(FLOAT), Default(None) */
    val resultAmount: Rep[Option[Float]] = column[Option[Float]]("result_amount", O.Default(None))
    /** Database column result_amount_type SqlType(INT), Default(None) */
    val resultAmountType: Rep[Option[Int]] = column[Option[Int]]("result_amount_type", O.Default(None))
    /** Database column result_item_ids SqlType(TEXT), Default(None) */
    val resultItemIds: Rep[Option[String]] = column[Option[String]]("result_item_ids", O.Default(None))
    /** Database column result_category_ids SqlType(TEXT), Default(None) */
    val resultCategoryIds: Rep[Option[String]] = column[Option[String]]("result_category_ids", O.Default(None))
    /** Database column result_quantity SqlType(INT), Default(None) */
    val resultQuantity: Rep[Option[Int]] = column[Option[Int]]("result_quantity", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column is_customise_start_end_time SqlType(INT), Default(None) */
    val isCustomiseStartEndTime: Rep[Option[Int]] = column[Option[Int]]("is_customise_start_end_time", O.Default(None))
    /** Database column is_customise_available_day SqlType(INT), Default(None) */
    val isCustomiseAvailableDay: Rep[Option[Int]] = column[Option[Int]]("is_customise_available_day", O.Default(None))
    /** Database column is_customise_start_end_date SqlType(INT), Default(Some(0)) */
    val isCustomiseStartEndDate: Rep[Option[Int]] = column[Option[Int]]("is_customise_start_end_date", O.Default(Some(0)))
    /** Database column is_show_on_shopping_cart SqlType(INT), Default(Some(0)) */
    val isShowOnShoppingCart: Rep[Option[Int]] = column[Option[Int]]("is_show_on_shopping_cart", O.Default(Some(0)))
    /** Database column stackable_option SqlType(INT), Default(Some(0)) */
    val stackableOption: Rep[Option[Int]] = column[Option[Int]]("stackable_option", O.Default(Some(0)))

    /** Foreign key referencing Menu (database name fx_promotionv3_1) */
    lazy val menuFk = foreignKey("fx_promotionv3_1", menuId :: HNil, Menu)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Promotionv3 */
  lazy val Promotionv3 = new TableQuery(tag => new Promotionv3(tag))

  /** Entity class storing rows of table ShoppingCartScript
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param cartScript Database column cart_script SqlType(TEXT), Default(None)
   *  @param checkoutScript Database column checkout_script SqlType(TEXT), Default(None)
   *  @param thankYouScript Database column thank_you_script SqlType(TEXT), Default(None) */
  case class ShoppingCartScriptRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, cartScript: Option[String] = None, checkoutScript: Option[String] = None, thankYouScript: Option[String] = None)
  /** GetResult implicit for fetching ShoppingCartScriptRow objects using plain SQL queries */
  implicit def GetResultShoppingCartScriptRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[ShoppingCartScriptRow] = GR{
    prs => import prs._
    ShoppingCartScriptRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table shopping_cart_script. Objects of this class serve as prototypes for rows in queries. */
  class ShoppingCartScript(_tableTag: Tag) extends Table[ShoppingCartScriptRow](_tableTag, "shopping_cart_script") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, menuId, cartScript, checkoutScript, thankYouScript) <> (ShoppingCartScriptRow.tupled, ShoppingCartScriptRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, menuId, cartScript, checkoutScript, thankYouScript).shaped.<>({r=>import r._; _1.map(_=> ShoppingCartScriptRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column cart_script SqlType(TEXT), Default(None) */
    val cartScript: Rep[Option[String]] = column[Option[String]]("cart_script", O.Default(None))
    /** Database column checkout_script SqlType(TEXT), Default(None) */
    val checkoutScript: Rep[Option[String]] = column[Option[String]]("checkout_script", O.Default(None))
    /** Database column thank_you_script SqlType(TEXT), Default(None) */
    val thankYouScript: Rep[Option[String]] = column[Option[String]]("thank_you_script", O.Default(None))

    /** Foreign key referencing Menu (database name fk_menu_2) */
    lazy val menuFk = foreignKey("fk_menu_2", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ShoppingCartScript */
  lazy val ShoppingCartScript = new TableQuery(tag => new ShoppingCartScript(tag))

  /** Entity class storing rows of table ShoppingCartTracker
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param webpageType Database column webpage_type SqlType(INT), Default(None)
   *  @param appendType Database column append_type SqlType(INT), Default(None)
   *  @param trackerScript Database column tracker_script SqlType(TEXT), Default(None) */
  case class ShoppingCartTrackerRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, name: Option[String] = None, webpageType: Option[Int] = None, appendType: Option[Int] = None, trackerScript: Option[String] = None)
  /** GetResult implicit for fetching ShoppingCartTrackerRow objects using plain SQL queries */
  implicit def GetResultShoppingCartTrackerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[ShoppingCartTrackerRow] = GR{
    prs => import prs._
    ShoppingCartTrackerRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table shopping_cart_tracker. Objects of this class serve as prototypes for rows in queries. */
  class ShoppingCartTracker(_tableTag: Tag) extends Table[ShoppingCartTrackerRow](_tableTag, "shopping_cart_tracker") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, menuId, name, webpageType, appendType, trackerScript) <> (ShoppingCartTrackerRow.tupled, ShoppingCartTrackerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, menuId, name, webpageType, appendType, trackerScript).shaped.<>({r=>import r._; _1.map(_=> ShoppingCartTrackerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(45,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(45,varying=true), O.Default(None))
    /** Database column webpage_type SqlType(INT), Default(None) */
    val webpageType: Rep[Option[Int]] = column[Option[Int]]("webpage_type", O.Default(None))
    /** Database column append_type SqlType(INT), Default(None) */
    val appendType: Rep[Option[Int]] = column[Option[Int]]("append_type", O.Default(None))
    /** Database column tracker_script SqlType(TEXT), Default(None) */
    val trackerScript: Rep[Option[String]] = column[Option[String]]("tracker_script", O.Default(None))

    /** Foreign key referencing Menu (database name fk_menu_3) */
    lazy val menuFk = foreignKey("fk_menu_3", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ShoppingCartTracker */
  lazy val ShoppingCartTracker = new TableQuery(tag => new ShoppingCartTracker(tag))

  /** Entity class storing rows of table SmsBlacklist
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default()
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param errorCode Database column error_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param errorDescription Database column error_description SqlType(TEXT), Default(None)
   *  @param messageId Database column message_id SqlType(TEXT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class SmsBlacklistRow(id: String = "", version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, phone: Option[String] = None, errorCode: Option[String] = None, errorDescription: Option[String] = None, messageId: Option[String] = None, storeOrderId: Option[String] = None)
  /** GetResult implicit for fetching SmsBlacklistRow objects using plain SQL queries */
  implicit def GetResultSmsBlacklistRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[SmsBlacklistRow] = GR{
    prs => import prs._
    SmsBlacklistRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table sms_blacklist. Objects of this class serve as prototypes for rows in queries. */
  class SmsBlacklist(_tableTag: Tag) extends Table[SmsBlacklistRow](_tableTag, "sms_blacklist") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, phone, errorCode, errorDescription, messageId, storeOrderId) <> (SmsBlacklistRow.tupled, SmsBlacklistRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, phone, errorCode, errorDescription, messageId, storeOrderId).shaped.<>({r=>import r._; _1.map(_=> SmsBlacklistRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true), Default() */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true), O.Default(""))
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
    /** Database column phone SqlType(VARCHAR), Length(32,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(32,varying=true), O.Default(None))
    /** Database column error_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val errorCode: Rep[Option[String]] = column[Option[String]]("error_code", O.Length(32,varying=true), O.Default(None))
    /** Database column error_description SqlType(TEXT), Default(None) */
    val errorDescription: Rep[Option[String]] = column[Option[String]]("error_description", O.Default(None))
    /** Database column message_id SqlType(TEXT), Default(None) */
    val messageId: Rep[Option[String]] = column[Option[String]]("message_id", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table SmsBlacklist */
  lazy val SmsBlacklist = new TableQuery(tag => new SmsBlacklist(tag))

  /** Entity class storing rows of table SmsLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param accountId Database column account_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param status Database column status SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param isBillable Database column is_billable SqlType(INT), Default(None)
   *  @param messageSid Database column message_sid SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param failCount Database column fail_count SqlType(INT), Default(Some(0))
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param notificationType Database column notification_type SqlType(VARCHAR), Length(255,true), Default(None) */
  case class SmsLogRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, accountId: Option[String] = None, phone: Option[String] = None, status: Option[String] = None, isBillable: Option[Int] = None, messageSid: Option[String] = None, failCount: Option[Int] = Some(0), storeOrderId: Option[String] = None, notificationType: Option[String] = None)
  /** GetResult implicit for fetching SmsLogRow objects using plain SQL queries */
  implicit def GetResultSmsLogRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[SmsLogRow] = GR{
    prs => import prs._
    SmsLogRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[String], <<?[String], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table sms_log. Objects of this class serve as prototypes for rows in queries. */
  class SmsLog(_tableTag: Tag) extends Table[SmsLogRow](_tableTag, "sms_log") {
    def * = (id, version, createdOn, createdBy, updatedBy, updatedOn, menuId, accountId, phone, status, isBillable, messageSid, failCount, storeOrderId, notificationType) <> (SmsLogRow.tupled, SmsLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, createdBy, updatedBy, updatedOn, menuId, accountId, phone, status, isBillable, messageSid, failCount, storeOrderId, notificationType).shaped.<>({r=>import r._; _1.map(_=> SmsLogRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(20,varying=true), O.Default(None))
    /** Database column status SqlType(VARCHAR), Length(32,true), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Length(32,varying=true), O.Default(None))
    /** Database column is_billable SqlType(INT), Default(None) */
    val isBillable: Rep[Option[Int]] = column[Option[Int]]("is_billable", O.Default(None))
    /** Database column message_sid SqlType(VARCHAR), Length(45,true), Default(None) */
    val messageSid: Rep[Option[String]] = column[Option[String]]("message_sid", O.Length(45,varying=true), O.Default(None))
    /** Database column fail_count SqlType(INT), Default(Some(0)) */
    val failCount: Rep[Option[Int]] = column[Option[Int]]("fail_count", O.Default(Some(0)))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column notification_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val notificationType: Rep[Option[String]] = column[Option[String]]("notification_type", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table SmsLog */
  lazy val SmsLog = new TableQuery(tag => new SmsLog(tag))

  /** Row type of table Store */
  type StoreRow = HCons[String,HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Float],HCons[Option[Float],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for StoreRow providing default values if available in the database schema. */
  def StoreRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, version: Option[Int] = None, name: Option[String] = None, email: Option[String] = None, apiKey: Option[String] = None, allowApiKey: Option[Int] = None, phone: Option[String] = None, accountId: Option[String] = None, address: Option[String] = None, addressTwo: Option[String] = None, state: Option[String] = None, city: Option[String] = None, country: Option[String] = None, postal: Option[String] = None, advanceOrderLengthInDays: Option[Int] = None, hasAdvanceOrder: Option[Int] = None, open: Option[Int] = None, zone: Option[String] = None, termsAndConditions: Option[String] = None, gmtOffset: Option[Float] = None, latitude: Option[Float] = None, longitude: Option[Float] = None, menuId: Option[String] = None, enablePickup: Option[Int] = None, enableDelivery: Option[Int] = None, isDeleted: Option[Int] = Some(0), fax: Option[String] = None, deliveryPartnerAccessKey: Option[String] = None, deliveryPartnerSecretKey: Option[String] = None, deliveryContactName: Option[String] = None, deliveryContactEmail: Option[String] = None, deliveryContactPhone: Option[String] = None, showAddressOnCart: Option[Int] = Some(1), enableAutoDelivery: Option[Int] = None, autoDeliveryLimit: Option[Float] = None, minimumPickupAmount: Option[Float] = Some(0.0F)): StoreRow = {
    id :: createdOn :: updatedOn :: createdBy :: updatedBy :: version :: name :: email :: apiKey :: allowApiKey :: phone :: accountId :: address :: addressTwo :: state :: city :: country :: postal :: advanceOrderLengthInDays :: hasAdvanceOrder :: open :: zone :: termsAndConditions :: gmtOffset :: latitude :: longitude :: menuId :: enablePickup :: enableDelivery :: isDeleted :: fax :: deliveryPartnerAccessKey :: deliveryPartnerSecretKey :: deliveryContactName :: deliveryContactEmail :: deliveryContactPhone :: showAddressOnCart :: enableAutoDelivery :: autoDeliveryLimit :: minimumPickupAmount :: HNil
  }
  /** GetResult implicit for fetching StoreRow objects using plain SQL queries */
  implicit def GetResultStoreRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[Float]]): GR[StoreRow] = GR{
    prs => import prs._
    <<[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Float] :: <<?[Float] :: HNil
  }
  /** Table description of table store. Objects of this class serve as prototypes for rows in queries. */
  class Store(_tableTag: Tag) extends Table[StoreRow](_tableTag, "store") {
    def * = id :: createdOn :: updatedOn :: createdBy :: updatedBy :: version :: name :: email :: apiKey :: allowApiKey :: phone :: accountId :: address :: addressTwo :: state :: city :: country :: postal :: advanceOrderLengthInDays :: hasAdvanceOrder :: open :: zone :: termsAndConditions :: gmtOffset :: latitude :: longitude :: menuId :: enablePickup :: enableDelivery :: isDeleted :: fax :: deliveryPartnerAccessKey :: deliveryPartnerSecretKey :: deliveryContactName :: deliveryContactEmail :: deliveryContactPhone :: showAddressOnCart :: enableAutoDelivery :: autoDeliveryLimit :: minimumPickupAmount :: HNil

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
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column api_key SqlType(VARCHAR), Length(255,true), Default(None) */
    val apiKey: Rep[Option[String]] = column[Option[String]]("api_key", O.Length(255,varying=true), O.Default(None))
    /** Database column allow_api_key SqlType(INT), Default(None) */
    val allowApiKey: Rep[Option[Int]] = column[Option[Int]]("allow_api_key", O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(15,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(15,varying=true), O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column address SqlType(TEXT), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Default(None))
    /** Database column address_two SqlType(TEXT), Default(None) */
    val addressTwo: Rep[Option[String]] = column[Option[String]]("address_two", O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column city SqlType(VARCHAR), Length(255,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(255,varying=true), O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(255,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(255,varying=true), O.Default(None))
    /** Database column postal SqlType(VARCHAR), Length(255,true), Default(None) */
    val postal: Rep[Option[String]] = column[Option[String]]("postal", O.Length(255,varying=true), O.Default(None))
    /** Database column advance_order_length_in_days SqlType(INT), Default(None) */
    val advanceOrderLengthInDays: Rep[Option[Int]] = column[Option[Int]]("advance_order_length_in_days", O.Default(None))
    /** Database column has_advance_order SqlType(INT), Default(None) */
    val hasAdvanceOrder: Rep[Option[Int]] = column[Option[Int]]("has_advance_order", O.Default(None))
    /** Database column open SqlType(INT), Default(None) */
    val open: Rep[Option[Int]] = column[Option[Int]]("open", O.Default(None))
    /** Database column zone SqlType(VARCHAR), Length(255,true), Default(None) */
    val zone: Rep[Option[String]] = column[Option[String]]("zone", O.Length(255,varying=true), O.Default(None))
    /** Database column terms_and_conditions SqlType(TEXT), Default(None) */
    val termsAndConditions: Rep[Option[String]] = column[Option[String]]("terms_and_conditions", O.Default(None))
    /** Database column gmt_offset SqlType(FLOAT), Default(None) */
    val gmtOffset: Rep[Option[Float]] = column[Option[Float]]("gmt_offset", O.Default(None))
    /** Database column latitude SqlType(FLOAT), Default(None) */
    val latitude: Rep[Option[Float]] = column[Option[Float]]("latitude", O.Default(None))
    /** Database column longitude SqlType(FLOAT), Default(None) */
    val longitude: Rep[Option[Float]] = column[Option[Float]]("longitude", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column enable_pickup SqlType(INT), Default(None) */
    val enablePickup: Rep[Option[Int]] = column[Option[Int]]("enable_pickup", O.Default(None))
    /** Database column enable_delivery SqlType(INT), Default(None) */
    val enableDelivery: Rep[Option[Int]] = column[Option[Int]]("enable_delivery", O.Default(None))
    /** Database column is_deleted SqlType(INT), Default(Some(0)) */
    val isDeleted: Rep[Option[Int]] = column[Option[Int]]("is_deleted", O.Default(Some(0)))
    /** Database column fax SqlType(VARCHAR), Length(20,true), Default(None) */
    val fax: Rep[Option[String]] = column[Option[String]]("fax", O.Length(20,varying=true), O.Default(None))
    /** Database column delivery_partner_access_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryPartnerAccessKey: Rep[Option[String]] = column[Option[String]]("delivery_partner_access_key", O.Length(45,varying=true), O.Default(None))
    /** Database column delivery_partner_secret_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryPartnerSecretKey: Rep[Option[String]] = column[Option[String]]("delivery_partner_secret_key", O.Length(45,varying=true), O.Default(None))
    /** Database column delivery_contact_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val deliveryContactName: Rep[Option[String]] = column[Option[String]]("delivery_contact_name", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_contact_email SqlType(VARCHAR), Length(255,true), Default(None) */
    val deliveryContactEmail: Rep[Option[String]] = column[Option[String]]("delivery_contact_email", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_contact_phone SqlType(VARCHAR), Length(45,true), Default(None) */
    val deliveryContactPhone: Rep[Option[String]] = column[Option[String]]("delivery_contact_phone", O.Length(45,varying=true), O.Default(None))
    /** Database column show_address_on_cart SqlType(INT), Default(Some(1)) */
    val showAddressOnCart: Rep[Option[Int]] = column[Option[Int]]("show_address_on_cart", O.Default(Some(1)))
    /** Database column enable_auto_delivery SqlType(INT), Default(None) */
    val enableAutoDelivery: Rep[Option[Int]] = column[Option[Int]]("enable_auto_delivery", O.Default(None))
    /** Database column auto_delivery_limit SqlType(FLOAT), Default(None) */
    val autoDeliveryLimit: Rep[Option[Float]] = column[Option[Float]]("auto_delivery_limit", O.Default(None))
    /** Database column minimum_pickup_amount SqlType(FLOAT), Default(Some(0.0)) */
    val minimumPickupAmount: Rep[Option[Float]] = column[Option[Float]]("minimum_pickup_amount", O.Default(Some(0.0F)))

    /** Foreign key referencing Account (database name fk_store_1) */
    lazy val accountFk = foreignKey("fk_store_1", accountId :: HNil, Account)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (apiKey) (database name api_key_UNIQUE) */
    val index1 = index("api_key_UNIQUE", apiKey :: HNil, unique=true)
  }
  /** Collection-like TableQuery object for table Store */
  lazy val Store = new TableQuery(tag => new Store(tag))

  /** Row type of table StoreOrder */
  type StoreOrderRow = HCons[String,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[DateTime],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Int],HCons[Option[Int],HCons[Option[DateTime],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for StoreOrderRow providing default values if available in the database schema. */
  def StoreOrderRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, customerId: Option[String] = None, storeId: Option[String] = None, pickup: Option[Int] = None, customerRemark: Option[String] = None, kitchenRemark: Option[String] = None, deliveryCost: Option[Float] = None, status: Option[Int] = None, paymentType: Option[Int] = None, deliveryDate: Option[DateTime] = None, paymentDueDate: Option[DateTime] = None, orderNumber: Option[String] = None, paymentStatus: Option[Int] = None, customerAddress: Option[String] = None, customerAddressOne: Option[String] = None, customerAddressTwo: Option[String] = None, customerAddressCity: Option[String] = None, customerAddressState: Option[String] = None, customerAddressPostal: Option[String] = None, customerAddressCountry: Option[String] = None, customerLongitude: Option[Float] = None, customerLatitude: Option[Float] = None, menuName: Option[String] = None, menuId: Option[String] = None, minimumOrder: Option[Float] = Some(0.0F), `type`: Option[Int] = Some(0), intervalInMinutes: Option[Int] = Some(0), submittedOn: Option[DateTime] = None, paymentReference: Option[String] = None, billingAddress: Option[String] = None, billingAddressOne: Option[String] = None, billingAddressTwo: Option[String] = None, billingAddressCity: Option[String] = None, billingAddressState: Option[String] = None, billingAddressPostal: Option[String] = None, billingAddressCountry: Option[String] = None, organisationName: Option[String] = None, gmtOffset: Option[Float] = None, totalAmount: Option[Float] = None, referrerUrl: Option[String] = None, deliveryFreeAfter: Option[Float] = Some(0.0F), locationDeliveryCost: Option[Float] = Some(0.0F), promotionCode: Option[String] = None, minimumOrderDefault: Option[Float] = Some(0.0F), invoiceReference: Option[String] = None, locale: Option[String] = Some("en_SG"), currencyCode: Option[String] = Some("SGD"), defaultStoreId: Option[String] = None, locationId: Option[String] = None, timeOptionId: Option[String] = None, timeOptionLeadTime: Option[Int] = None, paymentOptionId: Option[String] = None, recipientName: Option[String] = None, recipientContact: Option[String] = None, paymentProcessReference: Option[String] = None, roundingAdjustment: Option[Float] = Some(0.0F), deliveryRequestId: Option[String] = None): StoreOrderRow = {
    id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: customerId :: storeId :: pickup :: customerRemark :: kitchenRemark :: deliveryCost :: status :: paymentType :: deliveryDate :: paymentDueDate :: orderNumber :: paymentStatus :: customerAddress :: customerAddressOne :: customerAddressTwo :: customerAddressCity :: customerAddressState :: customerAddressPostal :: customerAddressCountry :: customerLongitude :: customerLatitude :: menuName :: menuId :: minimumOrder :: `type` :: intervalInMinutes :: submittedOn :: paymentReference :: billingAddress :: billingAddressOne :: billingAddressTwo :: billingAddressCity :: billingAddressState :: billingAddressPostal :: billingAddressCountry :: organisationName :: gmtOffset :: totalAmount :: referrerUrl :: deliveryFreeAfter :: locationDeliveryCost :: promotionCode :: minimumOrderDefault :: invoiceReference :: locale :: currencyCode :: defaultStoreId :: locationId :: timeOptionId :: timeOptionLeadTime :: paymentOptionId :: recipientName :: recipientContact :: paymentProcessReference :: roundingAdjustment :: deliveryRequestId :: HNil
  }
  /** GetResult implicit for fetching StoreOrderRow objects using plain SQL queries */
  implicit def GetResultStoreOrderRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[StoreOrderRow] = GR{
    prs => import prs._
    <<[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[DateTime] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Int] :: <<?[Int] :: <<?[DateTime] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[String] :: HNil
  }
  /** Table description of table store_order. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class StoreOrder(_tableTag: Tag) extends Table[StoreOrderRow](_tableTag, "store_order") {
    def * = id :: version :: createdBy :: updatedBy :: createdOn :: updatedOn :: customerId :: storeId :: pickup :: customerRemark :: kitchenRemark :: deliveryCost :: status :: paymentType :: deliveryDate :: paymentDueDate :: orderNumber :: paymentStatus :: customerAddress :: customerAddressOne :: customerAddressTwo :: customerAddressCity :: customerAddressState :: customerAddressPostal :: customerAddressCountry :: customerLongitude :: customerLatitude :: menuName :: menuId :: minimumOrder :: `type` :: intervalInMinutes :: submittedOn :: paymentReference :: billingAddress :: billingAddressOne :: billingAddressTwo :: billingAddressCity :: billingAddressState :: billingAddressPostal :: billingAddressCountry :: organisationName :: gmtOffset :: totalAmount :: referrerUrl :: deliveryFreeAfter :: locationDeliveryCost :: promotionCode :: minimumOrderDefault :: invoiceReference :: locale :: currencyCode :: defaultStoreId :: locationId :: timeOptionId :: timeOptionLeadTime :: paymentOptionId :: recipientName :: recipientContact :: paymentProcessReference :: roundingAdjustment :: deliveryRequestId :: HNil

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
    /** Database column customer_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val customerId: Rep[Option[String]] = column[Option[String]]("customer_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column pickup SqlType(INT), Default(None) */
    val pickup: Rep[Option[Int]] = column[Option[Int]]("pickup", O.Default(None))
    /** Database column customer_remark SqlType(TEXT), Default(None) */
    val customerRemark: Rep[Option[String]] = column[Option[String]]("customer_remark", O.Default(None))
    /** Database column kitchen_remark SqlType(TEXT), Default(None) */
    val kitchenRemark: Rep[Option[String]] = column[Option[String]]("kitchen_remark", O.Default(None))
    /** Database column delivery_cost SqlType(FLOAT), Default(None) */
    val deliveryCost: Rep[Option[Float]] = column[Option[Float]]("delivery_cost", O.Default(None))
    /** Database column status SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
    /** Database column payment_type SqlType(INT), Default(None) */
    val paymentType: Rep[Option[Int]] = column[Option[Int]]("payment_type", O.Default(None))
    /** Database column delivery_date SqlType(DATETIME), Default(None) */
    val deliveryDate: Rep[Option[DateTime]] = column[Option[DateTime]]("delivery_date", O.Default(None))
    /** Database column payment_due_date SqlType(DATETIME), Default(None) */
    val paymentDueDate: Rep[Option[DateTime]] = column[Option[DateTime]]("payment_due_date", O.Default(None))
    /** Database column order_number SqlType(VARCHAR), Length(32,true), Default(None) */
    val orderNumber: Rep[Option[String]] = column[Option[String]]("order_number", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_status SqlType(INT), Default(None) */
    val paymentStatus: Rep[Option[Int]] = column[Option[Int]]("payment_status", O.Default(None))
    /** Database column customer_address SqlType(TEXT), Default(None) */
    val customerAddress: Rep[Option[String]] = column[Option[String]]("customer_address", O.Default(None))
    /** Database column customer_address_one SqlType(TEXT), Default(None) */
    val customerAddressOne: Rep[Option[String]] = column[Option[String]]("customer_address_one", O.Default(None))
    /** Database column customer_address_two SqlType(TEXT), Default(None) */
    val customerAddressTwo: Rep[Option[String]] = column[Option[String]]("customer_address_two", O.Default(None))
    /** Database column customer_address_city SqlType(VARCHAR), Length(255,true), Default(None) */
    val customerAddressCity: Rep[Option[String]] = column[Option[String]]("customer_address_city", O.Length(255,varying=true), O.Default(None))
    /** Database column customer_address_state SqlType(VARCHAR), Length(255,true), Default(None) */
    val customerAddressState: Rep[Option[String]] = column[Option[String]]("customer_address_state", O.Length(255,varying=true), O.Default(None))
    /** Database column customer_address_postal SqlType(VARCHAR), Length(255,true), Default(None) */
    val customerAddressPostal: Rep[Option[String]] = column[Option[String]]("customer_address_postal", O.Length(255,varying=true), O.Default(None))
    /** Database column customer_address_country SqlType(VARCHAR), Length(255,true), Default(None) */
    val customerAddressCountry: Rep[Option[String]] = column[Option[String]]("customer_address_country", O.Length(255,varying=true), O.Default(None))
    /** Database column customer_longitude SqlType(FLOAT), Default(None) */
    val customerLongitude: Rep[Option[Float]] = column[Option[Float]]("customer_longitude", O.Default(None))
    /** Database column customer_latitude SqlType(FLOAT), Default(None) */
    val customerLatitude: Rep[Option[Float]] = column[Option[Float]]("customer_latitude", O.Default(None))
    /** Database column menu_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val menuName: Rep[Option[String]] = column[Option[String]]("menu_name", O.Length(255,varying=true), O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column minimum_order SqlType(FLOAT), Default(Some(0.0)) */
    val minimumOrder: Rep[Option[Float]] = column[Option[Float]]("minimum_order", O.Default(Some(0.0F)))
    /** Database column type SqlType(INT), Default(Some(0))
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(Some(0)))
    /** Database column interval_in_minutes SqlType(INT), Default(Some(0)) */
    val intervalInMinutes: Rep[Option[Int]] = column[Option[Int]]("interval_in_minutes", O.Default(Some(0)))
    /** Database column submitted_on SqlType(DATETIME), Default(None) */
    val submittedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("submitted_on", O.Default(None))
    /** Database column payment_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentReference: Rep[Option[String]] = column[Option[String]]("payment_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_address SqlType(TEXT), Default(None) */
    val billingAddress: Rep[Option[String]] = column[Option[String]]("billing_address", O.Default(None))
    /** Database column billing_address_one SqlType(TEXT), Default(None) */
    val billingAddressOne: Rep[Option[String]] = column[Option[String]]("billing_address_one", O.Default(None))
    /** Database column billing_address_two SqlType(TEXT), Default(None) */
    val billingAddressTwo: Rep[Option[String]] = column[Option[String]]("billing_address_two", O.Default(None))
    /** Database column billing_address_city SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingAddressCity: Rep[Option[String]] = column[Option[String]]("billing_address_city", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_address_state SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingAddressState: Rep[Option[String]] = column[Option[String]]("billing_address_state", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_address_postal SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingAddressPostal: Rep[Option[String]] = column[Option[String]]("billing_address_postal", O.Length(255,varying=true), O.Default(None))
    /** Database column billing_address_country SqlType(VARCHAR), Length(255,true), Default(None) */
    val billingAddressCountry: Rep[Option[String]] = column[Option[String]]("billing_address_country", O.Length(255,varying=true), O.Default(None))
    /** Database column organisation_name SqlType(TEXT), Default(None) */
    val organisationName: Rep[Option[String]] = column[Option[String]]("organisation_name", O.Default(None))
    /** Database column gmt_offset SqlType(FLOAT), Default(None) */
    val gmtOffset: Rep[Option[Float]] = column[Option[Float]]("gmt_offset", O.Default(None))
    /** Database column total_amount SqlType(FLOAT), Default(None) */
    val totalAmount: Rep[Option[Float]] = column[Option[Float]]("total_amount", O.Default(None))
    /** Database column referrer_url SqlType(TEXT), Default(None) */
    val referrerUrl: Rep[Option[String]] = column[Option[String]]("referrer_url", O.Default(None))
    /** Database column delivery_free_after SqlType(FLOAT), Default(Some(0.0)) */
    val deliveryFreeAfter: Rep[Option[Float]] = column[Option[Float]]("delivery_free_after", O.Default(Some(0.0F)))
    /** Database column location_delivery_cost SqlType(FLOAT), Default(Some(0.0)) */
    val locationDeliveryCost: Rep[Option[Float]] = column[Option[Float]]("location_delivery_cost", O.Default(Some(0.0F)))
    /** Database column promotion_code SqlType(TEXT), Default(None) */
    val promotionCode: Rep[Option[String]] = column[Option[String]]("promotion_code", O.Default(None))
    /** Database column minimum_order_default SqlType(FLOAT), Default(Some(0.0)) */
    val minimumOrderDefault: Rep[Option[Float]] = column[Option[Float]]("minimum_order_default", O.Default(Some(0.0F)))
    /** Database column invoice_reference SqlType(VARCHAR), Length(32,true), Default(None) */
    val invoiceReference: Rep[Option[String]] = column[Option[String]]("invoice_reference", O.Length(32,varying=true), O.Default(None))
    /** Database column locale SqlType(VARCHAR), Length(10,true), Default(Some(en_SG)) */
    val locale: Rep[Option[String]] = column[Option[String]]("locale", O.Length(10,varying=true), O.Default(Some("en_SG")))
    /** Database column currency_code SqlType(VARCHAR), Length(3,true), Default(Some(SGD)) */
    val currencyCode: Rep[Option[String]] = column[Option[String]]("currency_code", O.Length(3,varying=true), O.Default(Some("SGD")))
    /** Database column default_store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val defaultStoreId: Rep[Option[String]] = column[Option[String]]("default_store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column location_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val locationId: Rep[Option[String]] = column[Option[String]]("location_id", O.Length(32,varying=true), O.Default(None))
    /** Database column time_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val timeOptionId: Rep[Option[String]] = column[Option[String]]("time_option_id", O.Length(32,varying=true), O.Default(None))
    /** Database column time_option_lead_time SqlType(INT), Default(None) */
    val timeOptionLeadTime: Rep[Option[Int]] = column[Option[Int]]("time_option_lead_time", O.Default(None))
    /** Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentOptionId: Rep[Option[String]] = column[Option[String]]("payment_option_id", O.Length(32,varying=true), O.Default(None))
    /** Database column recipient_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val recipientName: Rep[Option[String]] = column[Option[String]]("recipient_name", O.Length(255,varying=true), O.Default(None))
    /** Database column recipient_contact SqlType(VARCHAR), Length(60,true), Default(None) */
    val recipientContact: Rep[Option[String]] = column[Option[String]]("recipient_contact", O.Length(60,varying=true), O.Default(None))
    /** Database column payment_process_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentProcessReference: Rep[Option[String]] = column[Option[String]]("payment_process_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column rounding_adjustment SqlType(FLOAT), Default(Some(0.0)) */
    val roundingAdjustment: Rep[Option[Float]] = column[Option[Float]]("rounding_adjustment", O.Default(Some(0.0F)))
    /** Database column delivery_request_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val deliveryRequestId: Rep[Option[String]] = column[Option[String]]("delivery_request_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Customer (database name fk_store_order_1) */
    lazy val customerFk = foreignKey("fk_store_order_1", customerId :: HNil, Customer)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing DeliveryRequest (database name fk_store_order_3) */
    lazy val deliveryRequestFk = foreignKey("fk_store_order_3", deliveryRequestId :: HNil, DeliveryRequest)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Store (database name fk_store_order_2) */
    lazy val storeFk = foreignKey("fk_store_order_2", storeId :: HNil, Store)(r => Rep.Some(r.id) :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table StoreOrder */
  lazy val StoreOrder = new TableQuery(tag => new StoreOrder(tag))

  /** Entity class storing rows of table StoreOrderLog
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param log Database column log SqlType(TEXT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class StoreOrderLogRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, log: Option[String] = None, storeOrderId: Option[String] = None)
  /** GetResult implicit for fetching StoreOrderLogRow objects using plain SQL queries */
  implicit def GetResultStoreOrderLogRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[StoreOrderLogRow] = GR{
    prs => import prs._
    StoreOrderLogRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table store_order_log. Objects of this class serve as prototypes for rows in queries. */
  class StoreOrderLog(_tableTag: Tag) extends Table[StoreOrderLogRow](_tableTag, "store_order_log") {
    def * = (id, version, createdOn, updatedOn, createdBy, updatedBy, log, storeOrderId) <> (StoreOrderLogRow.tupled, StoreOrderLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, updatedOn, createdBy, updatedBy, log, storeOrderId).shaped.<>({r=>import r._; _1.map(_=> StoreOrderLogRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column log SqlType(TEXT), Default(None) */
    val log: Rep[Option[String]] = column[Option[String]]("log", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing StoreOrder (database name store_order_log_fk1) */
    lazy val storeOrderFk = foreignKey("store_order_log_fk1", storeOrderId, StoreOrder)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table StoreOrderLog */
  lazy val StoreOrderLog = new TableQuery(tag => new StoreOrderLog(tag))

  /** Entity class storing rows of table StoreOrderPaymentDetails
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentStatus Database column payment_status SqlType(INT), Default(None)
   *  @param paymentOptionId Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentProcessReference Database column payment_process_reference SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param paymentReference Database column payment_reference SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param oddleApplicationFee Database column oddle_application_fee SqlType(FLOAT), Default(None)
   *  @param paymentGatewayFee Database column payment_gateway_fee SqlType(FLOAT), Default(None)
   *  @param paymentRateHistoryId Database column payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeOrderTotalAmount Database column store_order_total_amount SqlType(FLOAT), Default(None)
   *  @param failureMessage Database column failure_message SqlType(TEXT), Default(None)
   *  @param secondaryPaymentDetails Database column secondary_payment_details SqlType(TEXT), Default(None) */
  case class StoreOrderPaymentDetailsRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeOrderId: Option[String] = None, paymentStatus: Option[Int] = None, paymentOptionId: Option[String] = None, paymentProcessReference: Option[String] = None, paymentReference: Option[String] = None, oddleApplicationFee: Option[Float] = None, paymentGatewayFee: Option[Float] = None, paymentRateHistoryId: Option[String] = None, storeOrderTotalAmount: Option[Float] = None, failureMessage: Option[String] = None, secondaryPaymentDetails: Option[String] = None)
  /** GetResult implicit for fetching StoreOrderPaymentDetailsRow objects using plain SQL queries */
  implicit def GetResultStoreOrderPaymentDetailsRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[StoreOrderPaymentDetailsRow] = GR{
    prs => import prs._
    StoreOrderPaymentDetailsRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Float], <<?[String], <<?[Float], <<?[String], <<?[String]))
  }
  /** Table description of table store_order_payment_details. Objects of this class serve as prototypes for rows in queries. */
  class StoreOrderPaymentDetails(_tableTag: Tag) extends Table[StoreOrderPaymentDetailsRow](_tableTag, "store_order_payment_details") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeOrderId, paymentStatus, paymentOptionId, paymentProcessReference, paymentReference, oddleApplicationFee, paymentGatewayFee, paymentRateHistoryId, storeOrderTotalAmount, failureMessage, secondaryPaymentDetails) <> (StoreOrderPaymentDetailsRow.tupled, StoreOrderPaymentDetailsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeOrderId, paymentStatus, paymentOptionId, paymentProcessReference, paymentReference, oddleApplicationFee, paymentGatewayFee, paymentRateHistoryId, storeOrderTotalAmount, failureMessage, secondaryPaymentDetails).shaped.<>({r=>import r._; _1.map(_=> StoreOrderPaymentDetailsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_status SqlType(INT), Default(None) */
    val paymentStatus: Rep[Option[Int]] = column[Option[Int]]("payment_status", O.Default(None))
    /** Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentOptionId: Rep[Option[String]] = column[Option[String]]("payment_option_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_process_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentProcessReference: Rep[Option[String]] = column[Option[String]]("payment_process_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column payment_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentReference: Rep[Option[String]] = column[Option[String]]("payment_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column oddle_application_fee SqlType(FLOAT), Default(None) */
    val oddleApplicationFee: Rep[Option[Float]] = column[Option[Float]]("oddle_application_fee", O.Default(None))
    /** Database column payment_gateway_fee SqlType(FLOAT), Default(None) */
    val paymentGatewayFee: Rep[Option[Float]] = column[Option[Float]]("payment_gateway_fee", O.Default(None))
    /** Database column payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentRateHistoryId: Rep[Option[String]] = column[Option[String]]("payment_rate_history_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_total_amount SqlType(FLOAT), Default(None) */
    val storeOrderTotalAmount: Rep[Option[Float]] = column[Option[Float]]("store_order_total_amount", O.Default(None))
    /** Database column failure_message SqlType(TEXT), Default(None) */
    val failureMessage: Rep[Option[String]] = column[Option[String]]("failure_message", O.Default(None))
    /** Database column secondary_payment_details SqlType(TEXT), Default(None) */
    val secondaryPaymentDetails: Rep[Option[String]] = column[Option[String]]("secondary_payment_details", O.Default(None))

    /** Foreign key referencing PaymentOption (database name sopd_fk_2) */
    lazy val paymentOptionFk = foreignKey("sopd_fk_2", paymentOptionId, PaymentOption)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing StoreOrder (database name sopd_fk_1) */
    lazy val storeOrderFk = foreignKey("sopd_fk_1", storeOrderId, StoreOrder)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table StoreOrderPaymentDetails */
  lazy val StoreOrderPaymentDetails = new TableQuery(tag => new StoreOrderPaymentDetails(tag))

  /** Entity class storing rows of table StoreOrderPaymentDetailsHistory
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentStatus Database column payment_status SqlType(INT), Default(None)
   *  @param paymentOptionId Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param paymentProcessReference Database column payment_process_reference SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param paymentReference Database column payment_reference SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param oddleApplicationFee Database column oddle_application_fee SqlType(FLOAT), Default(None)
   *  @param paymentGatewayFee Database column payment_gateway_fee SqlType(FLOAT), Default(None)
   *  @param paymentRateHistoryId Database column payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeOrderTotalAmount Database column store_order_total_amount SqlType(FLOAT), Default(None)
   *  @param failureMessage Database column failure_message SqlType(TEXT), Default(None)
   *  @param secondaryPaymentDetails Database column secondary_payment_details SqlType(TEXT), Default(None) */
  case class StoreOrderPaymentDetailsHistoryRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeOrderId: Option[String] = None, paymentStatus: Option[Int] = None, paymentOptionId: Option[String] = None, paymentProcessReference: Option[String] = None, paymentReference: Option[String] = None, oddleApplicationFee: Option[Float] = None, paymentGatewayFee: Option[Float] = None, paymentRateHistoryId: Option[String] = None, storeOrderTotalAmount: Option[Float] = None, failureMessage: Option[String] = None, secondaryPaymentDetails: Option[String] = None)
  /** GetResult implicit for fetching StoreOrderPaymentDetailsHistoryRow objects using plain SQL queries */
  implicit def GetResultStoreOrderPaymentDetailsHistoryRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[StoreOrderPaymentDetailsHistoryRow] = GR{
    prs => import prs._
    StoreOrderPaymentDetailsHistoryRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Float], <<?[Float], <<?[String], <<?[Float], <<?[String], <<?[String]))
  }
  /** Table description of table store_order_payment_details_history. Objects of this class serve as prototypes for rows in queries. */
  class StoreOrderPaymentDetailsHistory(_tableTag: Tag) extends Table[StoreOrderPaymentDetailsHistoryRow](_tableTag, "store_order_payment_details_history") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeOrderId, paymentStatus, paymentOptionId, paymentProcessReference, paymentReference, oddleApplicationFee, paymentGatewayFee, paymentRateHistoryId, storeOrderTotalAmount, failureMessage, secondaryPaymentDetails) <> (StoreOrderPaymentDetailsHistoryRow.tupled, StoreOrderPaymentDetailsHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeOrderId, paymentStatus, paymentOptionId, paymentProcessReference, paymentReference, oddleApplicationFee, paymentGatewayFee, paymentRateHistoryId, storeOrderTotalAmount, failureMessage, secondaryPaymentDetails).shaped.<>({r=>import r._; _1.map(_=> StoreOrderPaymentDetailsHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_status SqlType(INT), Default(None) */
    val paymentStatus: Rep[Option[Int]] = column[Option[Int]]("payment_status", O.Default(None))
    /** Database column payment_option_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentOptionId: Rep[Option[String]] = column[Option[String]]("payment_option_id", O.Length(32,varying=true), O.Default(None))
    /** Database column payment_process_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentProcessReference: Rep[Option[String]] = column[Option[String]]("payment_process_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column payment_reference SqlType(VARCHAR), Length(255,true), Default(None) */
    val paymentReference: Rep[Option[String]] = column[Option[String]]("payment_reference", O.Length(255,varying=true), O.Default(None))
    /** Database column oddle_application_fee SqlType(FLOAT), Default(None) */
    val oddleApplicationFee: Rep[Option[Float]] = column[Option[Float]]("oddle_application_fee", O.Default(None))
    /** Database column payment_gateway_fee SqlType(FLOAT), Default(None) */
    val paymentGatewayFee: Rep[Option[Float]] = column[Option[Float]]("payment_gateway_fee", O.Default(None))
    /** Database column payment_rate_history_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val paymentRateHistoryId: Rep[Option[String]] = column[Option[String]]("payment_rate_history_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_order_total_amount SqlType(FLOAT), Default(None) */
    val storeOrderTotalAmount: Rep[Option[Float]] = column[Option[Float]]("store_order_total_amount", O.Default(None))
    /** Database column failure_message SqlType(TEXT), Default(None) */
    val failureMessage: Rep[Option[String]] = column[Option[String]]("failure_message", O.Default(None))
    /** Database column secondary_payment_details SqlType(TEXT), Default(None) */
    val secondaryPaymentDetails: Rep[Option[String]] = column[Option[String]]("secondary_payment_details", O.Default(None))
  }
  /** Collection-like TableQuery object for table StoreOrderPaymentDetailsHistory */
  lazy val StoreOrderPaymentDetailsHistory = new TableQuery(tag => new StoreOrderPaymentDetailsHistory(tag))

  /** Entity class storing rows of table StoreVariant
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param variantId Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param outOfStock Database column out_of_stock SqlType(INT), Default(None) */
  case class StoreVariantRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeId: Option[String] = None, variantId: Option[String] = None, outOfStock: Option[Int] = None)
  /** GetResult implicit for fetching StoreVariantRow objects using plain SQL queries */
  implicit def GetResultStoreVariantRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[StoreVariantRow] = GR{
    prs => import prs._
    StoreVariantRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table store_variant. Objects of this class serve as prototypes for rows in queries. */
  class StoreVariant(_tableTag: Tag) extends Table[StoreVariantRow](_tableTag, "store_variant") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeId, variantId, outOfStock) <> (StoreVariantRow.tupled, StoreVariantRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeId, variantId, outOfStock).shaped.<>({r=>import r._; _1.map(_=> StoreVariantRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val variantId: Rep[Option[String]] = column[Option[String]]("variant_id", O.Length(32,varying=true), O.Default(None))
    /** Database column out_of_stock SqlType(INT), Default(None) */
    val outOfStock: Rep[Option[Int]] = column[Option[Int]]("out_of_stock", O.Default(None))

    /** Foreign key referencing Store (database name fk_store_variant_1) */
    lazy val storeFk = foreignKey("fk_store_variant_1", storeId, Store)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Variant (database name fk_store_variant_2) */
    lazy val variantFk = foreignKey("fk_store_variant_2", variantId, Variant)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table StoreVariant */
  lazy val StoreVariant = new TableQuery(tag => new StoreVariant(tag))

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

    /** Foreign key referencing Menu (database name fk_subitem_1) */
    lazy val menuFk = foreignKey("fk_subitem_1", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (defaultSubitemVariantId) (database name fk_subitem_2_idx) */
    val index1 = index("fk_subitem_2_idx", defaultSubitemVariantId)
  }
  /** Collection-like TableQuery object for table Subitem */
  lazy val Subitem = new TableQuery(tag => new Subitem(tag))

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

  /** Entity class storing rows of table TaxAndCharge
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param amount Database column amount SqlType(FLOAT), Default(None)
   *  @param applyTo Database column apply_to SqlType(INT), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param inclusive Database column inclusive SqlType(INT), Default(None)
   *  @param external Database column external SqlType(INT), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param dpType Database column dp_type SqlType(INT), Default(None)
   *  @param applyToDelivery Database column apply_to_delivery SqlType(INT), Default(None)
   *  @param taxOrder Database column tax_order SqlType(INT), Default(Some(0))
   *  @param beforeDeliveryCharges Database column before_delivery_charges SqlType(INT), Default(None) */
  case class TaxAndChargeRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, amount: Option[Float] = None, applyTo: Option[Int] = None, `type`: Option[Int] = None, description: Option[String] = None, inclusive: Option[Int] = None, external: Option[Int] = None, menuId: Option[String] = None, dpType: Option[Int] = None, applyToDelivery: Option[Int] = None, taxOrder: Option[Int] = Some(0), beforeDeliveryCharges: Option[Int] = None)
  /** GetResult implicit for fetching TaxAndChargeRow objects using plain SQL queries */
  implicit def GetResultTaxAndChargeRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[TaxAndChargeRow] = GR{
    prs => import prs._
    TaxAndChargeRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Float], <<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table tax_and_charge. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TaxAndCharge(_tableTag: Tag) extends Table[TaxAndChargeRow](_tableTag, "tax_and_charge") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, amount, applyTo, `type`, description, inclusive, external, menuId, dpType, applyToDelivery, taxOrder, beforeDeliveryCharges) <> (TaxAndChargeRow.tupled, TaxAndChargeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, amount, applyTo, `type`, description, inclusive, external, menuId, dpType, applyToDelivery, taxOrder, beforeDeliveryCharges).shaped.<>({r=>import r._; _1.map(_=> TaxAndChargeRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column amount SqlType(FLOAT), Default(None) */
    val amount: Rep[Option[Float]] = column[Option[Float]]("amount", O.Default(None))
    /** Database column apply_to SqlType(INT), Default(None) */
    val applyTo: Rep[Option[Int]] = column[Option[Int]]("apply_to", O.Default(None))
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column inclusive SqlType(INT), Default(None) */
    val inclusive: Rep[Option[Int]] = column[Option[Int]]("inclusive", O.Default(None))
    /** Database column external SqlType(INT), Default(None) */
    val external: Rep[Option[Int]] = column[Option[Int]]("external", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column dp_type SqlType(INT), Default(None) */
    val dpType: Rep[Option[Int]] = column[Option[Int]]("dp_type", O.Default(None))
    /** Database column apply_to_delivery SqlType(INT), Default(None) */
    val applyToDelivery: Rep[Option[Int]] = column[Option[Int]]("apply_to_delivery", O.Default(None))
    /** Database column tax_order SqlType(INT), Default(Some(0)) */
    val taxOrder: Rep[Option[Int]] = column[Option[Int]]("tax_order", O.Default(Some(0)))
    /** Database column before_delivery_charges SqlType(INT), Default(None) */
    val beforeDeliveryCharges: Rep[Option[Int]] = column[Option[Int]]("before_delivery_charges", O.Default(None))

    /** Foreign key referencing Menu (database name fk_tax_and_charge) */
    lazy val menuFk = foreignKey("fk_tax_and_charge", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TaxAndCharge */
  lazy val TaxAndCharge = new TableQuery(tag => new TaxAndCharge(tag))

  /** Entity class storing rows of table ThirdPartyTracker
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param trackerId Database column tracker_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param webpageType Database column webpage_type SqlType(INT), Default(None)
   *  @param trackerType Database column tracker_type SqlType(INT), Default(None)
   *  @param value Database column value SqlType(FLOAT), Default(None)
   *  @param currencyCode Database column currency_code SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param extraField Database column extra_field SqlType(VARCHAR), Length(45,true), Default(None) */
  case class ThirdPartyTrackerRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, menuId: Option[String] = None, trackerId: Option[String] = None, webpageType: Option[Int] = None, trackerType: Option[Int] = None, value: Option[Float] = None, currencyCode: Option[String] = None, extraField: Option[String] = None)
  /** GetResult implicit for fetching ThirdPartyTrackerRow objects using plain SQL queries */
  implicit def GetResultThirdPartyTrackerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[Float]]): GR[ThirdPartyTrackerRow] = GR{
    prs => import prs._
    ThirdPartyTrackerRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Float], <<?[String], <<?[String]))
  }
  /** Table description of table third_party_tracker. Objects of this class serve as prototypes for rows in queries. */
  class ThirdPartyTracker(_tableTag: Tag) extends Table[ThirdPartyTrackerRow](_tableTag, "third_party_tracker") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, menuId, trackerId, webpageType, trackerType, value, currencyCode, extraField) <> (ThirdPartyTrackerRow.tupled, ThirdPartyTrackerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, menuId, trackerId, webpageType, trackerType, value, currencyCode, extraField).shaped.<>({r=>import r._; _1.map(_=> ThirdPartyTrackerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column tracker_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val trackerId: Rep[Option[String]] = column[Option[String]]("tracker_id", O.Length(32,varying=true), O.Default(None))
    /** Database column webpage_type SqlType(INT), Default(None) */
    val webpageType: Rep[Option[Int]] = column[Option[Int]]("webpage_type", O.Default(None))
    /** Database column tracker_type SqlType(INT), Default(None) */
    val trackerType: Rep[Option[Int]] = column[Option[Int]]("tracker_type", O.Default(None))
    /** Database column value SqlType(FLOAT), Default(None) */
    val value: Rep[Option[Float]] = column[Option[Float]]("value", O.Default(None))
    /** Database column currency_code SqlType(VARCHAR), Length(10,true), Default(None) */
    val currencyCode: Rep[Option[String]] = column[Option[String]]("currency_code", O.Length(10,varying=true), O.Default(None))
    /** Database column extra_field SqlType(VARCHAR), Length(45,true), Default(None) */
    val extraField: Rep[Option[String]] = column[Option[String]]("extra_field", O.Length(45,varying=true), O.Default(None))

    /** Foreign key referencing Menu (database name fk_third_party_tracker_1) */
    lazy val menuFk = foreignKey("fk_third_party_tracker_1", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ThirdPartyTracker */
  lazy val ThirdPartyTracker = new TableQuery(tag => new ThirdPartyTracker(tag))

  /** Entity class storing rows of table TimeOption
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param startTime Database column start_time SqlType(TIME), Default(None)
   *  @param endTime Database column end_time SqlType(TIME), Default(None)
   *  @param cutoffTime Database column cutoff_time SqlType(TIME), Default(None)
   *  @param dayInWeek Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param quota Database column quota SqlType(INT), Default(None)
   *  @param intervalInMinutes Database column interval_in_minutes SqlType(INT), Default(None)
   *  @param isSpecial Database column is_special SqlType(INT), Default(None)
   *  @param `type` Database column type SqlType(INT), Default(None)
   *  @param leadTime Database column lead_time SqlType(INT), Default(Some(0))
   *  @param startDate Database column start_date SqlType(DATETIME), Default(None)
   *  @param endDate Database column end_date SqlType(DATETIME), Default(None) */
  case class TimeOptionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeId: Option[String] = None, startTime: Option[java.sql.Time] = None, endTime: Option[java.sql.Time] = None, cutoffTime: Option[java.sql.Time] = None, dayInWeek: Option[String] = None, quota: Option[Int] = None, intervalInMinutes: Option[Int] = None, isSpecial: Option[Int] = None, `type`: Option[Int] = None, leadTime: Option[Int] = Some(0), startDate: Option[DateTime] = None, endDate: Option[DateTime] = None)
  /** GetResult implicit for fetching TimeOptionRow objects using plain SQL queries */
  implicit def GetResultTimeOptionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]], e4: GR[Option[java.sql.Time]]): GR[TimeOptionRow] = GR{
    prs => import prs._
    TimeOptionRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[java.sql.Time], <<?[java.sql.Time], <<?[java.sql.Time], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[DateTime], <<?[DateTime]))
  }
  /** Table description of table time_option. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TimeOption(_tableTag: Tag) extends Table[TimeOptionRow](_tableTag, "time_option") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeId, startTime, endTime, cutoffTime, dayInWeek, quota, intervalInMinutes, isSpecial, `type`, leadTime, startDate, endDate) <> (TimeOptionRow.tupled, TimeOptionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeId, startTime, endTime, cutoffTime, dayInWeek, quota, intervalInMinutes, isSpecial, `type`, leadTime, startDate, endDate).shaped.<>({r=>import r._; _1.map(_=> TimeOptionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column start_time SqlType(TIME), Default(None) */
    val startTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("start_time", O.Default(None))
    /** Database column end_time SqlType(TIME), Default(None) */
    val endTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("end_time", O.Default(None))
    /** Database column cutoff_time SqlType(TIME), Default(None) */
    val cutoffTime: Rep[Option[java.sql.Time]] = column[Option[java.sql.Time]]("cutoff_time", O.Default(None))
    /** Database column day_in_week SqlType(VARCHAR), Length(255,true), Default(None) */
    val dayInWeek: Rep[Option[String]] = column[Option[String]]("day_in_week", O.Length(255,varying=true), O.Default(None))
    /** Database column quota SqlType(INT), Default(None) */
    val quota: Rep[Option[Int]] = column[Option[Int]]("quota", O.Default(None))
    /** Database column interval_in_minutes SqlType(INT), Default(None) */
    val intervalInMinutes: Rep[Option[Int]] = column[Option[Int]]("interval_in_minutes", O.Default(None))
    /** Database column is_special SqlType(INT), Default(None) */
    val isSpecial: Rep[Option[Int]] = column[Option[Int]]("is_special", O.Default(None))
    /** Database column type SqlType(INT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Int]] = column[Option[Int]]("type", O.Default(None))
    /** Database column lead_time SqlType(INT), Default(Some(0)) */
    val leadTime: Rep[Option[Int]] = column[Option[Int]]("lead_time", O.Default(Some(0)))
    /** Database column start_date SqlType(DATETIME), Default(None) */
    val startDate: Rep[Option[DateTime]] = column[Option[DateTime]]("start_date", O.Default(None))
    /** Database column end_date SqlType(DATETIME), Default(None) */
    val endDate: Rep[Option[DateTime]] = column[Option[DateTime]]("end_date", O.Default(None))

    /** Foreign key referencing Store (database name fk_time_option_1) */
    lazy val storeFk = foreignKey("fk_time_option_1", storeId, Store)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TimeOption */
  lazy val TimeOption = new TableQuery(tag => new TimeOption(tag))

  /** Entity class storing rows of table TimeOptionBooking
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param orderDeliveryDateTime Database column order_delivery_date_time SqlType(TIMESTAMP), Default(None)
   *  @param isPickup Database column is_pickup SqlType(INT), Default(None)
   *  @param storeOrderId Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class TimeOptionBookingRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, storeId: Option[String] = None, orderDeliveryDateTime: Option[DateTime] = None, isPickup: Option[Int] = None, storeOrderId: Option[String] = None)
  /** GetResult implicit for fetching TimeOptionBookingRow objects using plain SQL queries */
  implicit def GetResultTimeOptionBookingRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[TimeOptionBookingRow] = GR{
    prs => import prs._
    TimeOptionBookingRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[DateTime], <<?[Int], <<?[String]))
  }
  /** Table description of table time_option_booking. Objects of this class serve as prototypes for rows in queries. */
  class TimeOptionBooking(_tableTag: Tag) extends Table[TimeOptionBookingRow](_tableTag, "time_option_booking") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, storeId, orderDeliveryDateTime, isPickup, storeOrderId) <> (TimeOptionBookingRow.tupled, TimeOptionBookingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, storeId, orderDeliveryDateTime, isPickup, storeOrderId).shaped.<>({r=>import r._; _1.map(_=> TimeOptionBookingRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))
    /** Database column order_delivery_date_time SqlType(TIMESTAMP), Default(None) */
    val orderDeliveryDateTime: Rep[Option[DateTime]] = column[Option[DateTime]]("order_delivery_date_time", O.Default(None))
    /** Database column is_pickup SqlType(INT), Default(None) */
    val isPickup: Rep[Option[Int]] = column[Option[Int]]("is_pickup", O.Default(None))
    /** Database column store_order_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeOrderId: Rep[Option[String]] = column[Option[String]]("store_order_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Store (database name sopt_fk_1) */
    lazy val storeFk = foreignKey("sopt_fk_1", storeId, Store)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (orderDeliveryDateTime) (database name sopt_1_idx) */
    val index1 = index("sopt_1_idx", orderDeliveryDateTime)
    /** Index over (storeId,orderDeliveryDateTime,isPickup) (database name sopt_2_idx) */
    val index2 = index("sopt_2_idx", (storeId, orderDeliveryDateTime, isPickup))
  }
  /** Collection-like TableQuery object for table TimeOptionBooking */
  lazy val TimeOptionBooking = new TableQuery(tag => new TimeOptionBooking(tag))

  /** Entity class storing rows of table Token
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param accessKey Database column access_key SqlType(VARCHAR), Length(40,true), Default(None)
   *  @param isEnabled Database column is_enabled SqlType(INT), Default(None)
   *  @param urlAddress Database column url_address SqlType(TEXT), Default(None)
   *  @param accountId Database column account_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param accessType Database column access_type SqlType(INT), Default(None)
   *  @param menuIds Database column menu_ids SqlType(TEXT), Default(None) */
  case class TokenRow(id: String, version: Int, createdBy: String, updatedBy: Option[String] = None, createdOn: DateTime, updatedOn: Option[DateTime] = None, accessKey: Option[String] = None, isEnabled: Option[Int] = None, urlAddress: Option[String] = None, accountId: Option[String] = None, accessType: Option[Int] = None, menuIds: Option[String] = None)
  /** GetResult implicit for fetching TokenRow objects using plain SQL queries */
  implicit def GetResultTokenRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[DateTime], e4: GR[Option[DateTime]], e5: GR[Option[Int]]): GR[TokenRow] = GR{
    prs => import prs._
    TokenRow.tupled((<<[String], <<[Int], <<[String], <<?[String], <<[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table token. Objects of this class serve as prototypes for rows in queries. */
  class Token(_tableTag: Tag) extends Table[TokenRow](_tableTag, "token") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, accessKey, isEnabled, urlAddress, accountId, accessType, menuIds) <> (TokenRow.tupled, TokenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(version), Rep.Some(createdBy), updatedBy, Rep.Some(createdOn), updatedOn, accessKey, isEnabled, urlAddress, accountId, accessType, menuIds).shaped.<>({r=>import r._; _1.map(_=> TokenRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column version SqlType(INT) */
    val version: Rep[Int] = column[Int]("version")
    /** Database column created_by SqlType(VARCHAR), Length(32,true) */
    val createdBy: Rep[String] = column[String]("created_by", O.Length(32,varying=true))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column created_on SqlType(DATETIME) */
    val createdOn: Rep[DateTime] = column[DateTime]("created_on")
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column access_key SqlType(VARCHAR), Length(40,true), Default(None) */
    val accessKey: Rep[Option[String]] = column[Option[String]]("access_key", O.Length(40,varying=true), O.Default(None))
    /** Database column is_enabled SqlType(INT), Default(None) */
    val isEnabled: Rep[Option[Int]] = column[Option[Int]]("is_enabled", O.Default(None))
    /** Database column url_address SqlType(TEXT), Default(None) */
    val urlAddress: Rep[Option[String]] = column[Option[String]]("url_address", O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column access_type SqlType(INT), Default(None) */
    val accessType: Rep[Option[Int]] = column[Option[Int]]("access_type", O.Default(None))
    /** Database column menu_ids SqlType(TEXT), Default(None) */
    val menuIds: Rep[Option[String]] = column[Option[String]]("menu_ids", O.Default(None))
  }
  /** Collection-like TableQuery object for table Token */
  lazy val Token = new TableQuery(tag => new Token(tag))

  /** Entity class storing rows of table Tracker
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param ip Database column ip SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param url Database column url SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param trafficSource Database column traffic_source SqlType(TEXT), Default(None)
   *  @param country Database column country SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param duration Database column duration SqlType(INT), Default(None)
   *  @param browser Database column browser SqlType(TEXT), Default(None)
   *  @param menuId Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param visitorId Database column visitor_id SqlType(VARCHAR), Length(128,true), Default(None)
   *  @param hits Database column hits SqlType(INT), Default(None)
   *  @param isNew Database column is_new SqlType(INT), Default(None)
   *  @param shortTrafficSource Database column short_traffic_source SqlType(TEXT), Default(None) */
  case class TrackerRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, ip: Option[String] = None, url: Option[String] = None, trafficSource: Option[String] = None, country: Option[String] = None, duration: Option[Int] = None, browser: Option[String] = None, menuId: Option[String] = None, visitorId: Option[String] = None, hits: Option[Int] = None, isNew: Option[Int] = None, shortTrafficSource: Option[String] = None)
  /** GetResult implicit for fetching TrackerRow objects using plain SQL queries */
  implicit def GetResultTrackerRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[TrackerRow] = GR{
    prs => import prs._
    TrackerRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table tracker. Objects of this class serve as prototypes for rows in queries. */
  class Tracker(_tableTag: Tag) extends Table[TrackerRow](_tableTag, "tracker") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, ip, url, trafficSource, country, duration, browser, menuId, visitorId, hits, isNew, shortTrafficSource) <> (TrackerRow.tupled, TrackerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, ip, url, trafficSource, country, duration, browser, menuId, visitorId, hits, isNew, shortTrafficSource).shaped.<>({r=>import r._; _1.map(_=> TrackerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column ip SqlType(VARCHAR), Length(255,true), Default(None) */
    val ip: Rep[Option[String]] = column[Option[String]]("ip", O.Length(255,varying=true), O.Default(None))
    /** Database column url SqlType(VARCHAR), Length(255,true), Default(None) */
    val url: Rep[Option[String]] = column[Option[String]]("url", O.Length(255,varying=true), O.Default(None))
    /** Database column traffic_source SqlType(TEXT), Default(None) */
    val trafficSource: Rep[Option[String]] = column[Option[String]]("traffic_source", O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(32,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(32,varying=true), O.Default(None))
    /** Database column duration SqlType(INT), Default(None) */
    val duration: Rep[Option[Int]] = column[Option[Int]]("duration", O.Default(None))
    /** Database column browser SqlType(TEXT), Default(None) */
    val browser: Rep[Option[String]] = column[Option[String]]("browser", O.Default(None))
    /** Database column menu_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val menuId: Rep[Option[String]] = column[Option[String]]("menu_id", O.Length(32,varying=true), O.Default(None))
    /** Database column visitor_id SqlType(VARCHAR), Length(128,true), Default(None) */
    val visitorId: Rep[Option[String]] = column[Option[String]]("visitor_id", O.Length(128,varying=true), O.Default(None))
    /** Database column hits SqlType(INT), Default(None) */
    val hits: Rep[Option[Int]] = column[Option[Int]]("hits", O.Default(None))
    /** Database column is_new SqlType(INT), Default(None) */
    val isNew: Rep[Option[Int]] = column[Option[Int]]("is_new", O.Default(None))
    /** Database column short_traffic_source SqlType(TEXT), Default(None) */
    val shortTrafficSource: Rep[Option[String]] = column[Option[String]]("short_traffic_source", O.Default(None))

    /** Foreign key referencing Menu (database name fk_tracker_1_idx) */
    lazy val menuFk = foreignKey("fk_tracker_1_idx", menuId, Menu)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Tracker */
  lazy val Tracker = new TableQuery(tag => new Tracker(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param owner Database column owner SqlType(INT), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param password Database column password SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resetPasswordKey Database column reset_password_key SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param receiveNotification Database column receive_notification SqlType(INT), Default(None)
   *  @param resetPasswordExpiryDate Database column reset_password_expiry_date SqlType(DATETIME), Default(None)
   *  @param accountId Database column account_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param apiKey Database column api_key SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param iosDeviceToken Database column ios_device_token SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param deliveryAdminNotificationSelectedCountry Database column delivery_admin_notification_selected_country SqlType(TEXT), Default(None)
   *  @param deliveryAdminSms Database column delivery_admin_sms SqlType(INT), Default(None)
   *  @param deliveryAdminEmail Database column delivery_admin_email SqlType(INT), Default(None)
   *  @param preferredDisplayLanguage Database column preferred_display_language SqlType(VARCHAR), Length(10,true), Default(None) */
  case class UserRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, owner: Option[Int] = None, email: Option[String] = None, password: Option[String] = None, phone: Option[String] = None, firstName: Option[String] = None, lastName: Option[String] = None, resetPasswordKey: Option[String] = None, receiveNotification: Option[Int] = None, resetPasswordExpiryDate: Option[DateTime] = None, accountId: Option[String] = None, apiKey: Option[String] = None, iosDeviceToken: Option[String] = None, deliveryAdminNotificationSelectedCountry: Option[String] = None, deliveryAdminSms: Option[Int] = None, deliveryAdminEmail: Option[Int] = None, preferredDisplayLanguage: Option[String] = None)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[DateTime], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, owner, email, password, phone, firstName, lastName, resetPasswordKey, receiveNotification, resetPasswordExpiryDate, accountId, apiKey, iosDeviceToken, deliveryAdminNotificationSelectedCountry, deliveryAdminSms, deliveryAdminEmail, preferredDisplayLanguage) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, owner, email, password, phone, firstName, lastName, resetPasswordKey, receiveNotification, resetPasswordExpiryDate, accountId, apiKey, iosDeviceToken, deliveryAdminNotificationSelectedCountry, deliveryAdminSms, deliveryAdminEmail, preferredDisplayLanguage).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column owner SqlType(INT), Default(None) */
    val owner: Rep[Option[Int]] = column[Option[Int]]("owner", O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column password SqlType(VARCHAR), Length(255,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(255,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Length(20,varying=true), O.Default(None))
    /** Database column first_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val firstName: Rep[Option[String]] = column[Option[String]]("first_name", O.Length(255,varying=true), O.Default(None))
    /** Database column last_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("last_name", O.Length(255,varying=true), O.Default(None))
    /** Database column reset_password_key SqlType(VARCHAR), Length(45,true), Default(None) */
    val resetPasswordKey: Rep[Option[String]] = column[Option[String]]("reset_password_key", O.Length(45,varying=true), O.Default(None))
    /** Database column receive_notification SqlType(INT), Default(None) */
    val receiveNotification: Rep[Option[Int]] = column[Option[Int]]("receive_notification", O.Default(None))
    /** Database column reset_password_expiry_date SqlType(DATETIME), Default(None) */
    val resetPasswordExpiryDate: Rep[Option[DateTime]] = column[Option[DateTime]]("reset_password_expiry_date", O.Default(None))
    /** Database column account_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val accountId: Rep[Option[String]] = column[Option[String]]("account_id", O.Length(32,varying=true), O.Default(None))
    /** Database column api_key SqlType(VARCHAR), Length(255,true), Default(None) */
    val apiKey: Rep[Option[String]] = column[Option[String]]("api_key", O.Length(255,varying=true), O.Default(None))
    /** Database column ios_device_token SqlType(VARCHAR), Length(255,true), Default(None) */
    val iosDeviceToken: Rep[Option[String]] = column[Option[String]]("ios_device_token", O.Length(255,varying=true), O.Default(None))
    /** Database column delivery_admin_notification_selected_country SqlType(TEXT), Default(None) */
    val deliveryAdminNotificationSelectedCountry: Rep[Option[String]] = column[Option[String]]("delivery_admin_notification_selected_country", O.Default(None))
    /** Database column delivery_admin_sms SqlType(INT), Default(None) */
    val deliveryAdminSms: Rep[Option[Int]] = column[Option[Int]]("delivery_admin_sms", O.Default(None))
    /** Database column delivery_admin_email SqlType(INT), Default(None) */
    val deliveryAdminEmail: Rep[Option[Int]] = column[Option[Int]]("delivery_admin_email", O.Default(None))
    /** Database column preferred_display_language SqlType(VARCHAR), Length(10,true), Default(None) */
    val preferredDisplayLanguage: Rep[Option[String]] = column[Option[String]]("preferred_display_language", O.Length(10,varying=true), O.Default(None))

    /** Foreign key referencing Account (database name fk_user_1) */
    lazy val accountFk = foreignKey("fk_user_1", accountId, Account)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))

  /** Entity class storing rows of table UserNotification
   *  @param id Database column id SqlType(VARCHAR), Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param notificationTemplateId Database column notification_template_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param sms Database column sms SqlType(INT), Default(None)
   *  @param email Database column email SqlType(INT), Default(None)
   *  @param fax Database column fax SqlType(INT), Default(None) */
  case class UserNotificationRow(id: String, version: Option[Int] = None, createdOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, updatedOn: Option[DateTime] = None, notificationTemplateId: Option[String] = None, userId: Option[String] = None, sms: Option[Int] = None, email: Option[Int] = None, fax: Option[Int] = None)
  /** GetResult implicit for fetching UserNotificationRow objects using plain SQL queries */
  implicit def GetResultUserNotificationRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[DateTime]], e3: GR[Option[String]]): GR[UserNotificationRow] = GR{
    prs => import prs._
    UserNotificationRow.tupled((<<[String], <<?[Int], <<?[DateTime], <<?[String], <<?[String], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table user_notification. Objects of this class serve as prototypes for rows in queries. */
  class UserNotification(_tableTag: Tag) extends Table[UserNotificationRow](_tableTag, "user_notification") {
    def * = (id, version, createdOn, createdBy, updatedBy, updatedOn, notificationTemplateId, userId, sms, email, fax) <> (UserNotificationRow.tupled, UserNotificationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdOn, createdBy, updatedBy, updatedOn, notificationTemplateId, userId, sms, email, fax).shaped.<>({r=>import r._; _1.map(_=> UserNotificationRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), Length(32,true) */
    val id: Rep[String] = column[String]("id", O.Length(32,varying=true))
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column created_on SqlType(DATETIME), Default(None) */
    val createdOn: Rep[Option[DateTime]] = column[Option[DateTime]]("created_on", O.Default(None))
    /** Database column created_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val createdBy: Rep[Option[String]] = column[Option[String]]("created_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None) */
    val updatedBy: Rep[Option[String]] = column[Option[String]]("updated_by", O.Length(32,varying=true), O.Default(None))
    /** Database column updated_on SqlType(DATETIME), Default(None) */
    val updatedOn: Rep[Option[DateTime]] = column[Option[DateTime]]("updated_on", O.Default(None))
    /** Database column notification_template_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val notificationTemplateId: Rep[Option[String]] = column[Option[String]]("notification_template_id", O.Length(32,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("user_id", O.Length(32,varying=true), O.Default(None))
    /** Database column sms SqlType(INT), Default(None) */
    val sms: Rep[Option[Int]] = column[Option[Int]]("sms", O.Default(None))
    /** Database column email SqlType(INT), Default(None) */
    val email: Rep[Option[Int]] = column[Option[Int]]("email", O.Default(None))
    /** Database column fax SqlType(INT), Default(None) */
    val fax: Rep[Option[Int]] = column[Option[Int]]("fax", O.Default(None))
  }
  /** Collection-like TableQuery object for table UserNotification */
  lazy val UserNotification = new TableQuery(tag => new UserNotification(tag))

  /** Entity class storing rows of table UserPermission
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param permissionId Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param permissionFlag Database column permission_flag SqlType(INT), Default(Some(7)) */
  case class UserPermissionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, userId: Option[String] = None, permissionId: Option[String] = None, permissionFlag: Option[Int] = Some(7))
  /** GetResult implicit for fetching UserPermissionRow objects using plain SQL queries */
  implicit def GetResultUserPermissionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[UserPermissionRow] = GR{
    prs => import prs._
    UserPermissionRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table user_permission. Objects of this class serve as prototypes for rows in queries. */
  class UserPermission(_tableTag: Tag) extends Table[UserPermissionRow](_tableTag, "user_permission") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, userId, permissionId, permissionFlag) <> (UserPermissionRow.tupled, UserPermissionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, userId, permissionId, permissionFlag).shaped.<>({r=>import r._; _1.map(_=> UserPermissionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column user_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("user_id", O.Length(32,varying=true), O.Default(None))
    /** Database column permission_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val permissionId: Rep[Option[String]] = column[Option[String]]("permission_id", O.Length(32,varying=true), O.Default(None))
    /** Database column permission_flag SqlType(INT), Default(Some(7)) */
    val permissionFlag: Rep[Option[Int]] = column[Option[Int]]("permission_flag", O.Default(Some(7)))

    /** Foreign key referencing Permission (database name fk_user_permission_1) */
    lazy val permissionFk = foreignKey("fk_user_permission_1", permissionId, Permission)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing User (database name fk_user_permission_2) */
    lazy val userFk = foreignKey("fk_user_permission_2", userId, User)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (userId,permissionId) (database name user_id_permission_id_constraint) */
    val index1 = index("user_id_permission_id_constraint", (userId, permissionId), unique=true)
  }
  /** Collection-like TableQuery object for table UserPermission */
  lazy val UserPermission = new TableQuery(tag => new UserPermission(tag))

  /** Entity class storing rows of table UserStore
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param storeId Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class UserStoreRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, userId: Option[String] = None, storeId: Option[String] = None)
  /** GetResult implicit for fetching UserStoreRow objects using plain SQL queries */
  implicit def GetResultUserStoreRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[UserStoreRow] = GR{
    prs => import prs._
    UserStoreRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String]))
  }
  /** Table description of table user_store. Objects of this class serve as prototypes for rows in queries. */
  class UserStore(_tableTag: Tag) extends Table[UserStoreRow](_tableTag, "user_store") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, userId, storeId) <> (UserStoreRow.tupled, UserStoreRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, userId, storeId).shaped.<>({r=>import r._; _1.map(_=> UserStoreRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column user_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("user_id", O.Length(32,varying=true), O.Default(None))
    /** Database column store_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val storeId: Rep[Option[String]] = column[Option[String]]("store_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Store (database name fk_user_store_1) */
    lazy val storeFk = foreignKey("fk_user_store_1", storeId, Store)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing User (database name fk_user_store_2) */
    lazy val userFk = foreignKey("fk_user_store_2", userId, User)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserStore */
  lazy val UserStore = new TableQuery(tag => new UserStore(tag))

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

  /** Entity class storing rows of table VariantIngredient
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param quantity Database column quantity SqlType(FLOAT), Default(None)
   *  @param ingredientId Database column ingredient_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param variantId Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None) */
  case class VariantIngredientRow(id: String, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, version: Option[Int] = None, quantity: Option[Float] = None, ingredientId: Option[String] = None, variantId: Option[String] = None)
  /** GetResult implicit for fetching VariantIngredientRow objects using plain SQL queries */
  implicit def GetResultVariantIngredientRow(implicit e0: GR[String], e1: GR[Option[DateTime]], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[Float]]): GR[VariantIngredientRow] = GR{
    prs => import prs._
    VariantIngredientRow.tupled((<<[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int], <<?[Float], <<?[String], <<?[String]))
  }
  /** Table description of table variant_ingredient. Objects of this class serve as prototypes for rows in queries. */
  class VariantIngredient(_tableTag: Tag) extends Table[VariantIngredientRow](_tableTag, "variant_ingredient") {
    def * = (id, createdOn, updatedOn, createdBy, updatedBy, version, quantity, ingredientId, variantId) <> (VariantIngredientRow.tupled, VariantIngredientRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdOn, updatedOn, createdBy, updatedBy, version, quantity, ingredientId, variantId).shaped.<>({r=>import r._; _1.map(_=> VariantIngredientRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column version SqlType(INT), Default(None) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version", O.Default(None))
    /** Database column quantity SqlType(FLOAT), Default(None) */
    val quantity: Rep[Option[Float]] = column[Option[Float]]("quantity", O.Default(None))
    /** Database column ingredient_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val ingredientId: Rep[Option[String]] = column[Option[String]]("ingredient_id", O.Length(32,varying=true), O.Default(None))
    /** Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val variantId: Rep[Option[String]] = column[Option[String]]("variant_id", O.Length(32,varying=true), O.Default(None))

    /** Foreign key referencing Ingredient (database name fk_2) */
    lazy val ingredientFk = foreignKey("fk_2", ingredientId, Ingredient)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Variant (database name fk_1) */
    lazy val variantFk = foreignKey("fk_1", variantId, Variant)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table VariantIngredient */
  lazy val VariantIngredient = new TableQuery(tag => new VariantIngredient(tag))

  /** Entity class storing rows of table VariantSubitem
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param variantId Database column variant_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param subitemId Database column subitem_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param displayPosition Database column display_position SqlType(INT), Default(None) */
  case class VariantSubitemRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, variantId: Option[String] = None, subitemId: Option[String] = None, displayPosition: Option[Int] = None)
  /** GetResult implicit for fetching VariantSubitemRow objects using plain SQL queries */
  implicit def GetResultVariantSubitemRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[VariantSubitemRow] = GR{
    prs => import prs._
    VariantSubitemRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table variant_subitem. Objects of this class serve as prototypes for rows in queries. */
  class VariantSubitem(_tableTag: Tag) extends Table[VariantSubitemRow](_tableTag, "variant_subitem") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, variantId, subitemId, displayPosition) <> (VariantSubitemRow.tupled, VariantSubitemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, variantId, subitemId, displayPosition).shaped.<>({r=>import r._; _1.map(_=> VariantSubitemRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column display_position SqlType(INT), Default(None) */
    val displayPosition: Rep[Option[Int]] = column[Option[Int]]("display_position", O.Default(None))

    /** Foreign key referencing Subitem (database name fk_variant_subitem_2) */
    lazy val subitemFk = foreignKey("fk_variant_subitem_2", subitemId, Subitem)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Variant (database name fk_variant_subitem_1) */
    lazy val variantFk = foreignKey("fk_variant_subitem_1", variantId, Variant)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table VariantSubitem */
  lazy val VariantSubitem = new TableQuery(tag => new VariantSubitem(tag))

  /** Entity class storing rows of table Version
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param version Database column version SqlType(INT), Default(None)
   *  @param createdBy Database column created_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param updatedBy Database column updated_by SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createdOn Database column created_on SqlType(DATETIME), Default(None)
   *  @param updatedOn Database column updated_on SqlType(DATETIME), Default(None)
   *  @param versionNumber Database column version_number SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param buildNumber Database column build_number SqlType(INT), Default(None)
   *  @param releaseNotes Database column release_notes SqlType(TEXT), Default(None) */
  case class VersionRow(id: String, version: Option[Int] = None, createdBy: Option[String] = None, updatedBy: Option[String] = None, createdOn: Option[DateTime] = None, updatedOn: Option[DateTime] = None, versionNumber: Option[String] = None, buildNumber: Option[Int] = None, releaseNotes: Option[String] = None)
  /** GetResult implicit for fetching VersionRow objects using plain SQL queries */
  implicit def GetResultVersionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[DateTime]]): GR[VersionRow] = GR{
    prs => import prs._
    VersionRow.tupled((<<[String], <<?[Int], <<?[String], <<?[String], <<?[DateTime], <<?[DateTime], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table version. Objects of this class serve as prototypes for rows in queries. */
  class Version(_tableTag: Tag) extends Table[VersionRow](_tableTag, "version") {
    def * = (id, version, createdBy, updatedBy, createdOn, updatedOn, versionNumber, buildNumber, releaseNotes) <> (VersionRow.tupled, VersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), version, createdBy, updatedBy, createdOn, updatedOn, versionNumber, buildNumber, releaseNotes).shaped.<>({r=>import r._; _1.map(_=> VersionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column version_number SqlType(VARCHAR), Length(45,true), Default(None) */
    val versionNumber: Rep[Option[String]] = column[Option[String]]("version_number", O.Length(45,varying=true), O.Default(None))
    /** Database column build_number SqlType(INT), Default(None) */
    val buildNumber: Rep[Option[Int]] = column[Option[Int]]("build_number", O.Default(None))
    /** Database column release_notes SqlType(TEXT), Default(None) */
    val releaseNotes: Rep[Option[String]] = column[Option[String]]("release_notes", O.Default(None))
  }
  /** Collection-like TableQuery object for table Version */
  lazy val Version = new TableQuery(tag => new Version(tag))
}
