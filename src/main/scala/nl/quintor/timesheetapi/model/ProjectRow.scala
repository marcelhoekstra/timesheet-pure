package nl.quintor.timesheetapi.model

import java.time.LocalDate

import nl.quintor.timesheetapi.routes.IdentityDto
import nl.quintor.timesheetapi.routes.dto.TimesheetDto

/**
 * Created by marcel on 11/11/2015.
 */

case class ProjectRow(id: Option[Long], version: Int =0, naam: String, standaard: Boolean, beginDatum: LocalDate, eindDatum: Option[LocalDate], medewerkerId: Long) {
}

object ProjectRow {
  implicit val projectModelId : nl.quintor.timesheetapi.routes.ModelIdentity[ProjectRow] = (c: ProjectRow) => c.id

}

