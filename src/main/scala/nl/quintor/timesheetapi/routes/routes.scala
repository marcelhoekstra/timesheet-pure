package nl.quintor.timesheetapi

import cats.effect.IO
import io.circe._
import io.circe.syntax._
import nl.quintor.timesheetapi.routes.dto.TimesheetDto
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.io._
import org.http4s.headers._
import nl.quintor.timesheetapi.routes.IdentityOps

package object routes {

  def httpOk[A : Encoder](result: Either[_, A]): IO[Response[IO]] =
    result match {
      case Left(_)  => httpNotFound()
      case Right(a) => Ok(a.asJson)
    }

  def httpCreated[A : Encoder : IdentityDto](c: A): IO[Response[IO]] =
    Created(c.asJson, Location(Uri.unsafeFromString(s"/timesheets/${c.id.get}")))

  def httpNotFound(): IO[Response[IO]] =
    NotFound()

  trait IdentityDto[A] {
    def id(a: A): Option[Long]
  }

  trait ModelIdentity[A] {
    def id(a: A): Option[Long]
  }


  implicit class IdentityOps[A : IdentityDto](a: A) (implicit val x :IdentityDto[A]) {
    def id: Option[Long] = x.id(a)
  }

  implicit class IdentityModelOps[A : ModelIdentity](a: A)(implicit val x :ModelIdentity[A]) {
    def id: Option[Long] = x.id(a)
  }
}
