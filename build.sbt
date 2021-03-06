
lazy val akkaHttpVersion = "10.1.3"
lazy val akkaVersion    = "2.5.13"

lazy val plugins = Seq(JavaAppPackaging, DockerPlugin)

dockerExposedPorts := Seq(8080)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "uk.co.adamtrousdale",
      scalaVersion    := "2.12.6"
    )),
    name := "lookup",
    resolvers += "bintray-backline-open-source-releases" at "https://dl.bintray.com/backline/open-source",
    libraryDependencies ++= Seq(
      "com.typesafe.akka"             %% "akka-http"             % akkaHttpVersion,
      "com.typesafe.akka"             %% "akka-stream"           % akkaVersion,
      "com.typesafe.akka"             %% "akka-http-spray-json"  % akkaHttpVersion,
      "com.typesafe.akka"             %% "akka-http-testkit"     % akkaHttpVersion % Test,
      "org.scalatest"                 %% "scalatest"             % "3.0.1"         % Test,
      "org.mockito"                   %  "mockito-all"           % "1.10.19"       % Test

    )
  ).enablePlugins(plugins: _*)
