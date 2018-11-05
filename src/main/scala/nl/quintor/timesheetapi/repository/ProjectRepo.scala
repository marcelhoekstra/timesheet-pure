package nl.quintor.timesheetapi.repository

import nl.quintor.timesheetapi.model.ProjectRow
import nl.quintor.timesheetapi.repository.schema.ProjectenTable
import slick.lifted.TableQuery

import scala.language.postfixOps
import slick.jdbc.MySQLProfile.api._

object ProjectRepo extends CrudRepository[ProjectRow, ProjectenTable] (new ProjectenTable(_)) {


  def findByName(project: String) = {
    filter(_.naam === project).sortBy(_.naam).result.headOption
  }
}



