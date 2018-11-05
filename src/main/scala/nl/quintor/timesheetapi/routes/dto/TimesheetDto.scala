package nl.quintor.timesheetapi.routes.dto

import cats.effect.IO
import org.http4s.EntityEncoder
import io.circe._
import io.circe.generic.semiauto._
import nl.quintor.timesheetapi.routes._

case class TimesheetDto(
                         id: Option[Long],
                         version: Long = 0,
                         jaar: Int,
                         maand: Int,
                         status: String,
                         opmerking: Option[String],
                         projectBoekingen: Seq[ProjectBoekingDto]) {

}

object TimesheetDto {

  implicit val timesheetEncoder: Encoder[TimesheetDto] =
    deriveEncoder[TimesheetDto]

  implicit val timesheetDecoder: Decoder[TimesheetDto] =
    deriveDecoder[TimesheetDto]

  implicit val timesheetIdentity : IdentityDto[TimesheetDto] = (c: TimesheetDto) => c.id

}