package models

import javax.inject.{Inject, Singleton}

import models.database.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class StoreOrderRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def incrementTotalAmount(storeOrderId: String, incrementAmount: Float): Future[Option[Float]] = {
    def updateQuery(id: String, value: Float) = sqlu"""UPDATE store_order SET total_amount = total_amount + $value WHERE id = $id"""
    val filterQuery = StoreOrder.filter(_.id === storeOrderId).map(_.totalAmount)
    val combined = updateQuery(storeOrderId, incrementAmount) andThen filterQuery.result.head
    db.run(combined.transactionally)
  }
}
