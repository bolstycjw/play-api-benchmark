package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class SubitemRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def getByItems(itemIds: Seq[String]): Future[Seq[(ItemSubitemRow, SubitemRow)]] = {
    val itemSubitemsQuery = for {
      (itemSubitem, subitem) <- ItemSubitem
        .filter(_.itemId inSet itemIds)
        .join(Subitem)
        .on(_.subitemId === _.id)
        .sortBy(_._1.displayPosition)
    } yield (itemSubitem, subitem)

    db.run(itemSubitemsQuery.result)
  }
}
