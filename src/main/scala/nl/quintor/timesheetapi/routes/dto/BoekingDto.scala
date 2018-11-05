package nl.quintor.timesheetapi.routes.dto

import java.time.LocalDate

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class BoekingDto(
                       id: Option[Long],
                       version : Option[Long],
                       projectId : Option[Long],
                       kilometerType : Option[String],
                       kilometers: Option[Int],
                       opmerking: Option[String],
                       uren: Double) {
}

object BoekingDto {
  implicit val boekingEncoder: Encoder[BoekingDto] =
    deriveEncoder[BoekingDto]

  implicit val boekingDecoder: Decoder[BoekingDto] =
    deriveDecoder[BoekingDto]
}