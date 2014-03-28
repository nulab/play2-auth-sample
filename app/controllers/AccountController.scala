package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

trait AccountController extends Controller {

  self: Auth =>

  def signedInAccount = authorizedAction { account => implicit request =>
    Ok(Json.obj(
      "id" -> account.id,
      "name" -> account.name
    ))
  }
}

object AccountWebController extends AccountController with WebAuth
object AccountApiController extends AccountController with APIAuth
