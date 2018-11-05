package nl.quintor.timesheetapi.routes.dto

import java.time.LocalDate

case class KilometerBoekingDto(id : Option[Long], version : Option[Int], datum : LocalDate, kilometers: Int) {


}