package nl.quintor.timesheetapi.routes.dto

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class ProjectBoekingDto(id : Option[Long], version : Option[Int], project : Long, urenBoekingen: Seq[BoekingDto]) {


}

object ProjectBoekingDto {
  implicit val projectBoekingEncoder: Encoder[ProjectBoekingDto] =
    deriveEncoder[ProjectBoekingDto]

  implicit val projectBoekingDecoder: Decoder[ProjectBoekingDto] =
    deriveDecoder[ProjectBoekingDto]
}