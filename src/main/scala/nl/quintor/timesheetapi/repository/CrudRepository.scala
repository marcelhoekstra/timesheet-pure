package nl.quintor.timesheetapi.repository

import nl.quintor.timesheetapi.repository.schema.ModelTable
import nl.quintor.timesheetapi.routes.IdentityModelOps
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{TableQuery, Tag}

abstract class CrudRepository[M :nl.quintor.timesheetapi.routes.ModelIdentity, MT <: ModelTable[M]](
                                                                cons: Tag => MT)
  extends TableQuery[MT](cons) {

  def initialize() =
    this.schema.create

  def list() =
    this.result

  def find(id: Long) =
    filter(_.id === id).result

  def insert(model: M) =
    this += model

  def update(model: M) =
    filter(_.id === model.id).update(model)

  def delete(model: M) =
    filter(_.id === model.id).delete

}
