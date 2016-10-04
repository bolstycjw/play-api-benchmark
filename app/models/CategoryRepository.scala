package models

import javax.inject.{Inject, Singleton}

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
    val categoriesQuery = for {
      (_, category) <- Menu
        .filter(_.id === menuId)
        .join(Category)
        .on(_.id === _.menuId)
    } yield category

    db.run(categoriesQuery.result)
  }
}
