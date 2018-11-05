package nl.quintor.timesheetapi

import cats.effect.IO
import fs2.StreamApp
import nl.quintor.timesheetapi.routes.TimesheetRoute
import nl.quintor.timesheetapi.services.TimesheetService
import org.http4s.server.blaze.BlazeBuilder
import slick.basic.DatabaseConfig
import slick.jdbc.MySQLProfile

import scala.concurrent.ExecutionContext
object HelloWorldServer extends StreamApp[IO] {
  import scala.concurrent.ExecutionContext.Implicits.global

  def stream(args: List[String], requestShutdown: IO[Unit]) = ServerStream.stream
}

object ServerStream {
  import nl.quintor.timesheetapi.stream._

  def stream(implicit ec: ExecutionContext) =
    for {
      config            <- Config.load[IO]().stream
      dbConfig          = DatabaseConfig.forConfig[MySQLProfile]("h2mem1")
      _                 <- Database.migrate(dbConfig).stream

      timesheetService  = new TimesheetService() (dbConfig.db)
      timesheetRoute    = new TimesheetRoute(timesheetService).service
      httpServer      <- BlazeBuilder[IO]
        .bindHttp(config.server.port, config.server.host)
        .mountService(timesheetRoute, "/")
        .serve
    } yield httpServer

}
