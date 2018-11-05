package nl.quintor.timesheetapi.routes.dto

import java.time.LocalDate



case class ProjectDto(id: Option[Long], version: Option[Int], naam: String, standaard: Option[Boolean], beginDatum: Option[LocalDate], eindDatum: Option[LocalDate], persoonlijk: Option[Boolean]) {
}


