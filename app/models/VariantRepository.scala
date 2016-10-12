package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import models.database.{SubitemVariantRow, VariantRow}
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class VariantRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def getByItems(itemIds: Seq[String]): Future[Seq[VariantRow]] = {
    val itemVariantsQuery = for {
      itemVariant <- Variant
        .filter(_.itemId inSet itemIds)
        .sortBy(_.displayPosition)
    } yield itemVariant

    db.run(itemVariantsQuery.result)
  }

  def getBySubitems(subitemIds: Seq[String]): Future[Seq[(SubitemVariantRow, VariantRow)]] = {
    val subitemVariantsQuery = for {
      (subitemVariant, variant) <- SubitemVariant
        .filter(_.subitemId inSet subitemIds)
        .join(Variant)
        .on(_.variantId === _.id)
        .sortBy(_._1.displayPosition)
    } yield (subitemVariant, variant)

    db.run(subitemVariantsQuery.result)
  }
}
