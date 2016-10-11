package models

import java.util.UUID
import javax.inject.{Inject, Singleton}

import com.github.tototoshi.slick.MySQLJodaSupport._
import dtos.AddressDto
import models.database.AddressRow
import models.database.Tables._
import org.joda.time.DateTime
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

@Singleton
class AddressRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val profile = dbConfigProvider.get[JdbcProfile]

  import profile._
  import driver.api._

  def findQuery(id: String) = Address.filter(_.id === id)

  def create(addressDto: AddressDto): Future[AddressRow] = {
    val addressId = UUID.randomUUID().toString.replaceAll("-", "")
    Logger.debug(s"Generated addressId = $addressId")
    val insertAction = Address.map(a =>
        (a.id, a.address, a.customerId, a.createdOn)) += (addressId, addressDto.addressOne, addressDto.userId, Some(
        DateTime.now()))

    val action = insertAction andThen findQuery(addressId).result.head
    db.run(action.transactionally)
  }

  def update(addressDto: AddressDto): Future[AddressRow] = {
    val filterQuery = findQuery(addressDto.id.get)
    val updateAction = filterQuery
      .map(a => (a.address, a.updatedOn))
      .update((addressDto.addressOne, Some(DateTime.now())))

    val action = updateAction andThen filterQuery.result.head
    db.run(action.transactionally)
  }

  def deleteByUserIdAndTimestamp(addressDto: AddressDto): Future[Int] = {
    val filterQuery = Address.filter(a => a.customerId === addressDto.userId && a.createdOn >= new DateTime(addressDto.timestamp.get))
    val deleteAction = filterQuery.delete
    db.run(deleteAction)
  }

}
