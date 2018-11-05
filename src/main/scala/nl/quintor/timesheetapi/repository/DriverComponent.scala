package nl.quintor.timesheetapi.repository

import java.sql.{Date, Time}
import java.time.{LocalDate, LocalTime}

import io.strongtyped.active.slick.JdbcProfileProvider

trait DriverComponent {
  type DriverType <: slick.driver.JdbcProfile
  val driver: DriverType

  trait ConfigurableProfileProvider extends JdbcProfileProvider {
    type JP = DriverType
    val jdbcProfile = driver

    import driver.api.{timeColumnType => DefaultTimeColumnType, _}

    implicit val myDateColumnType = MappedColumnType.base[LocalDate, Date](
      ld => Date.valueOf(ld),
      d => d.toLocalDate
    )

    implicit val timeColumnType = MappedColumnType.base[LocalTime, Time](
      localTime => Time.valueOf(localTime),
      time => time.toLocalTime
    )
  }

}