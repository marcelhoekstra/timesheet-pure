val Http4sVersion = "0.18.19"
val Specs2Version = "4.1.0"
val LogbackVersion = "1.2.3"
val CirceVersion = "0.9.3"
val PureConfigVersion = "0.9.2"
val H2Version            = "1.4.197"
val FlywayVersion        = "5.2.0"

val platformDependencies = Seq(
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "ch.qos.logback" % "logback-classic" % LogbackVersion,
  "com.github.pureconfig" %% "pureconfig" % PureConfigVersion,
  "org.flywaydb"          %  "flyway-core"          % FlywayVersion
)

lazy val root = (project in file("."))
  .settings(
    organization := "quintor",
    name := "timesheet-api",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.specs2" %% "specs2-core" % Specs2Version % "test",
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.slick" %% "slick" % "3.2.0",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
      "io.strongtyped" %% "active-slick-shapeless" % "0.3.5",
      "com.h2database" % "h2" % H2Version,

    ) ++ platformDependencies,
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.2.4")
  )

