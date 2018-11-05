package nl.quintor.timesheetapi.routes.dto

case class MedewerkerDto(
                          id: Option[Long],
                          version: Option[Int] = Some(0),
                          voorNaam: String,
                          achterNaam: String,
                          email: String,
                          contractUren: Int,
                          actief: Option[Boolean] = Some(true),
                          inlognaam: String,
                          password: Option[String],
                          passwordHash: Option[String],
                          partimeDagen: Option[String],
                          autos: Option[Seq[AutoDto]]) {
}