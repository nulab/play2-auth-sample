package controllers

import play.api._
import play.api.mvc._
import models._

trait Auth {

  def authorizedAction(block: Account => Request[AnyContent] => SimpleResult): Action[AnyContent]

}

trait WebAuth extends Auth {
  def authorizedAction(block: Account => Request[AnyContent] => SimpleResult): Action[AnyContent] = Action { implicit request =>
    val account = Account(1, "web")
    block(account)(request)
  }
}

trait APIAuth extends Auth {
  def authorizedAction(block: Account => Request[AnyContent] => SimpleResult): Action[AnyContent] = Action { implicit request =>
    val account = Account(2, "api")
    block(account)(request)
  }
}
