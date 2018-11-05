package nl.quintor.timesheetapi.repository.schema

import java.util.UUID

import slick.jdbc.H2Profile.api._
import slick.lifted.Tag

abstract class ModelTable[T](tag: Tag, tableName: String) extends Table[T](tag, tableName) {

  def id = column[Option[Long]]("id", O.PrimaryKey)
}


