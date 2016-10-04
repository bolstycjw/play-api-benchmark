package controllers

import javax.inject._

import models.StoreOrderRepository
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

import scala.language.implicitConversions

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class StoreOrderController @Inject()(storeOrderRepository: StoreOrderRepository)
    extends Controller {

  def incrementTotalAmount = Action.async { request =>
    val jsonBody: Option[JsValue] = request.body.asJson
    val storeOrderId = jsonBody map { json =>
      (json \ "id").as[String]
    } getOrElse { "" }
    val incrementAmount = jsonBody map { json =>
      (json \ "incrementAmount").as[Float]
    } getOrElse { 0F }
    val totalAmount = storeOrderRepository.incrementTotalAmount(storeOrderId, incrementAmount)
    totalAmount map { result =>
      Ok(Json.obj("status" -> "Ok", "totalAmount" -> result))
    }
  }
}
