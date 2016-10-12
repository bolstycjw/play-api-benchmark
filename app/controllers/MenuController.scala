package controllers

import javax.inject._

import controllers.json.MenuConverter
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import play.api.mvc._
import services.MenuService

import scala.language.implicitConversions

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class MenuController @Inject()(menuService: MenuService)
    extends Controller {
  private val menuConverter = new MenuConverter
  implicit val menuWrites = menuConverter.menuWrites

  def menu(id: String) = Action.async {
    val menuDtoFuture = menuService.retrieveMenu(id)
    menuDtoFuture map { result =>
      Ok(Json.obj("status" -> "Ok", "menus" -> Json.toJson(result)))
    }
  }
}
