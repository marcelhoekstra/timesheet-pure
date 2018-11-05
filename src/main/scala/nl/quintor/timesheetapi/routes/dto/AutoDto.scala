package nl.quintor.timesheetapi.routes.dto

import java.time.LocalDate

case class AutoDto(
                    id: Option[Long],
                    version: Option[Int],
                    kenteken: String,
                    vervangendVervoer: Boolean = false,
                    beginDatum: LocalDate,
                    eindDatum: Option[LocalDate]) {
}
