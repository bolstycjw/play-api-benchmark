package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class MenuRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def get(id: String): Future[Option[MenuRow]] = {
    val menuQuery = Menu.filter(_.id === id)
    db.run(menuQuery.result.headOption)
  }
}
