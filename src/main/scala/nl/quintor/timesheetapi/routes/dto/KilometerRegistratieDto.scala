package nl.quintor.timesheetapi.routes.dto

/**
 * Created by marcel on 14-10-2015.
 */
case class KilometerRegistratieDto(
                                    id: Option[Long],
                                    version: Option[Int],
                                    auto: AutoDto,
                                    beginStand: Int,
                                    eindStand: Int) {

}
