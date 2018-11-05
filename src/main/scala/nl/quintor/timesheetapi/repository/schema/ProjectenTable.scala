package nl.quintor.timesheetapi.repository.schema
import java.sql.{Date, Time}
import java.time.{LocalDate, LocalTime}

import nl.quintor.timesheetapi.model.ProjectRow
import slick.jdbc.H2Profile.api._
import slick.lifted.{Rep, Tag}

object ProjectenTable {
  implicit val localDateToDate = MappedColumnType.base[LocalDate, Date](
    l => Date.valueOf(l),
    d => d.toLocalDate
  )
}
class ProjectenTable(tag: Tag) extends ModelTable[ProjectRow](tag, "project") {
  import ProjectenTable._

      def version: Rep[Int] = column[Int]("version")

      def naam: Rep[String] = column[String]("naam")

      def standaard: Rep[Boolean] = column[Boolean]("standaard")

      def beginDatum: Rep[LocalDate] = column[LocalDate]("beginDatum")

      def eindDatum: Rep[LocalDate] = column[LocalDate]("eindDatum")

      def medewerkerId: Rep[Long] = column[Long]("medewerker_id")

      def * = (id, version, naam, standaard, beginDatum, eindDatum.?, medewerkerId) <>((ProjectRow.apply _).tupled, ProjectRow.unapply)
    }
