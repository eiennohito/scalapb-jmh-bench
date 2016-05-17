import com.trueaccord.scalapb.{ScalaPbPlugin => PB}

name := """sbt-jmh-seed"""

version := "1.0-SNAPSHOT"

PB.protobufSettings

PB.runProtoc in PB.protobufConfig := { args =>
  com.github.os72.protocjar.Protoc.runProtoc("-v300" +: args.toArray)
}

version in PB.protobufConfig := "3.0.0-beta-2"

scalaVersion := "2.11.8"

val grpcVersion = "0.14.0"

libraryDependencies ++= Seq(
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % (PB.scalapbVersion in PB.protobufConfig).value,
  "io.grpc" % "grpc-netty" % grpcVersion //dependency on the netty transport. Use grpc-okhttp for android.
)

scalacOptions ++= Seq("-Yopt:l:classpath")

enablePlugins(JmhPlugin)
