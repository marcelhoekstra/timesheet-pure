package nl.quintor.timesheetapi.routes

import cats.data.Kleisli
import cats.effect.IO
import nl.quintor.timesheetapi.routes.dto.TimesheetDto
import nl.quintor.timesheetapi.routes.dto.TimesheetDto._
import nl.quintor.timesheetapi.services.TimesheetService
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpService, Request, Response}
import cats.effect._
import cats.data._
import cats.implicits._

class TimesheetRoute(val timesheetService: TimesheetService) extends Http4sDsl[IO] {

  type EndPoint = Kleisli[IO, Request[IO], Response[IO]]

  def service = HttpService[IO] {
      case req @ GET -> Root / "timesheets" => getTimesheets(req)
      case GET -> Root / "timesheets" / id => this.getTimesheetById(id.toInt)
      case req@POST -> Root / "timesheets" => createTimesheet(req)
    }



  private def getTimesheets : EndPoint =
    Kleisli(_ => for {
      timesheets <- timesheetService.findAll()
      result <- httpOk(timesheets)
    } yield result)


  private def getTimesheetById(id : Int)  = {
    id match {
      case 1 => Ok()
      case _ => NotFound()
    }
  }


  private def createTimesheet(req: Request[IO]) : IO[Response[IO]] = {

    for {
      timesheet <- req.decodeJson[TimesheetDto]
      result <- httpCreated(timesheet)
    } yield result


  }
}
