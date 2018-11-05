package nl.quintor.timesheetapi.routes.dto

case class VerlofDto(medewerkerId : Long, jaar: Int, standaardVerlofUren : Option[Double], standaardPartimeUren : Option[Double],
                     overwerkVerlofUren : Option[Double], opgespaardeVerlofUren : Option[Double]) {}