package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class ItemRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def getByCategories(categoryIds: Seq[String]): Future[Seq[(CategoryItemRow, ItemRow)]] = {
    val itemsQuery = for {
      (tagItem, item) <- CategoryItem
        .filter(_.tagId inSet categoryIds)
        .join(Item)
        .on(_.itemId === _.id)
        .sortBy(_._1.displayPosition)
    } yield (tagItem, item)

    db.run(itemsQuery.result)
  }
}
