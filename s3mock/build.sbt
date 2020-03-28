name := "s3mock"

scalaVersion := "2.11.12"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "io.findify" %% "s3mock" % "0.2.4" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "3.1.0" % "test"
libraryDependencies += "software.amazon.awssdk" % "s3" % "2.3.9"
libraryDependencies += "com.adobe.testing" % "s3mock" % "2.1.16"
libraryDependencies += "com.adobe.testing" % "s3mock-junit5" % "2.1.16"
// libraryDependencies += "netty-nio-client" % "software.amazon.awssdk" % "2.3.9"

scalacOptions += "-target:jvm-1.8"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")