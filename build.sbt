name := """KpiParser"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  javaJpa,
  "mysql" % "mysql-connector-java" % "6.0.5",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

