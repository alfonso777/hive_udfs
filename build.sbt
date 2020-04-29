lazy val commonSettings = Seq(
  version := "0.1",
  organization := "org.commons.hive.utils",
  scalaVersion := "2.12.1"
)


resolvers += Resolver.jcenterRepo

unmanagedJars in Compile ++= (file("lib/") * "*.jar").classpath

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}