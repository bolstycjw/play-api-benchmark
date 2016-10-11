package models

import javax.inject.{Inject, Singleton}

import models.database.CategoryRow
import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class CategoryRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def getByMenu(menuId: String): Future[Seq[CategoryRow]] = {
    val categoriesQuery = Category.filter(_.menuId === menuId)
    db.run(categoriesQuery.result)
  }
}
