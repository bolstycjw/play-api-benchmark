package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class ItemImageRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def getByItems(itemIds: Seq[String]): Future[Seq[ItemImageRow]] = {
    val itemImagesQuery = for {
      itemImage <- ItemImage.filter(_.itemId inSet itemIds)
    } yield itemImage

    db.run(itemImagesQuery.result)
  }
}
