package contollers

import akka.http.scaladsl.model.{ ContentTypes, HttpEntity, StatusCodes }
import akka.http.scaladsl.server.{ HttpApp, Route }
import config.AppConfig

trait Controller extends HttpApp {

  def routes: Route =
    pathPrefix("example") {
      pathEnd {
        get {
          complete("/example")
        } ~
          (post & entity(as[String])) { exampleRequest =>
            complete {
              StatusCodes.OK -> HttpEntity(ContentTypes.`application/json`, s""" { "name": "${exampleRequest}" } """)
            }
          }
      }
    }
}

// $COVERAGE-OFF$
object Controller extends Controller with App with AppConfig {
  startServer("0.0.0.0", config.getInt("http.port"))
}
// $COVERAGE-ON$
