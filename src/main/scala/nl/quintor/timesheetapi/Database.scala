package nl.quintor.timesheetapi

import javax.sql.DataSource

import cats.effect._
import org.flywaydb.core.Flyway
import slick.basic.DatabaseConfig
import slick.jdbc.H2Profile
import scala.collection.JavaConverters._

object Database {

  def migrate(dbConfig:DatabaseConfig[_]): IO[Unit] = {
    import pureconfig.error.ConfigReaderException
    import pureconfig._
    IO {
      Flyway.configure()
        .dataSource(dbConfig.config.getString("db.url"),"sa","")
        .baselineVersion("1")
        .baselineOnMigrate(true)
        .locations(dbConfig.config.getStringList("locations").asScala: _*)
        .load().migrate()

    }
  }


}
