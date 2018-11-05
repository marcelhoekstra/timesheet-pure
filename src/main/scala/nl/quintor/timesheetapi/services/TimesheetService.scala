package nl.quintor.timesheetapi.services

import cats.effect.IO
import nl.quintor.timesheetapi.model.ProjectRow
import nl.quintor.timesheetapi.repository.ProjectRepo
import nl.quintor.timesheetapi.routes.dto.TimesheetDto
import slick.basic.{BasicBackend, DatabaseConfig}
import slick.jdbc.JdbcBackend.DatabaseDef
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

case class NotFound() extends RuntimeException

class TimesheetService() (implicit val db: BasicBackend#DatabaseDef) {
  def findAll() : IO[Either[NotFound, Seq[TimesheetDto]]] = {

    println("start")
    val result = Await.result(db.run(ProjectRepo.list()), Duration.Inf)

      .foreach {
      case project : ProjectRow=>
        println(project)
    }
    val timesheet1 = TimesheetDto(Some(1), 0, 2018, 10, "", Some("test"), Nil)
    IO {Right(Seq(timesheet1))}
  }
}
