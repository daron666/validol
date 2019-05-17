organization := "org.daron"

name := "validol"

version := "0.0.1"

scalaVersion := "2.12.8"

lazy val catsDeps = Seq(
  "org.typelevel" %% "cats-core" % "1.6.0",
  "org.typelevel" %% "cats-effect" % "1.2.0",
  "io.chrisdavenport" %% "log4cats-slf4j" % "0.3.0"
)

lazy val otherDeps = Seq(
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
)

libraryDependencies ++= catsDeps ++ otherDeps

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-unchecked",
  "-Xfuture",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ypartial-unification"
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.9")
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.0-M4")