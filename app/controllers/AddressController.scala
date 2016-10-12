package controllers

import javax.inject._

import controllers.json.AddressConverter
import dtos.AddressDto
import models.AddressRepository
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

import scala.concurrent.Future
import scala.language.implicitConversions

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class AddressController @Inject()(addressRepository: AddressRepository)
    extends Controller {
  private val addressConverter = new AddressConverter
  implicit val addressReads = addressConverter.addressReads
  implicit val addressWrites = addressConverter.addressWrites

  def create = Action.async(BodyParsers.parse.json) { request =>
    val addressResult = request.body.validate[AddressDto]
    addressResult.fold(
      errors => {
        Future {
          BadRequest(
            Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
        }
      },
      addressDto => {
        val addressFuture = addressRepository.create(addressDto)
        addressFuture map { result =>
          Ok(Json.obj("status" -> "Ok", "address" -> Json.toJson(result)))
        }
      }
    )
  }

  def update = Action.async(BodyParsers.parse.json) { request =>
    val addressResult = request.body.validate[AddressDto]
    addressResult.fold(
      errors => {
        Future {
          BadRequest(
            Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
        }
      },
      addressDto => {
        val addressFuture = addressRepository.update(addressDto)
        addressFuture map { result =>
          Ok(Json.obj("status" -> "Ok", "address" -> Json.toJson(result)))
        }
      }
    )
  }

  def delete = Action.async(BodyParsers.parse.json) { request =>
    val addressResult = request.body.validate[AddressDto]
    addressResult.fold(
      errors => {
        Future {
          BadRequest(
            Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
        }
      },
      addressDto => {
        val deletedAddressesFuture = addressRepository.deleteByUserIdAndTimestamp(addressDto)
        deletedAddressesFuture map { result =>
          Ok(Json.obj("status" -> "Ok", "deletedAddressCount" -> result))
        }
      }
    )
  }
}
