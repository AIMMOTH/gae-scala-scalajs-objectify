Google App Engine with Scala and ScalaJS
========================================

Run Locally
-----------

1) Build the target directory $ mvn package

2) Copy all dependencies into your source code. Example:

```
$ copy target/gae-scala-scalajs-objectify-1.0-SNAPSHOT/WEB-INF/lib/ src/main/webapp/WEB-INF/lib/
```

3) Start SBT $ sbt

4) Generate JavaScript $ fastOptJS

3) Obtain Google Appengine SDK via Maven or download.

4) Use dev_appserver to run project. Example:

```
%APPENGINE_SDK_HOME%/bin/dev_appserver -a localhost -p 8080 src/main/webapp
```

5) Optional: Add the following flag to start Remote Java debugging:

```
--jvm_flag=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
```

Scala
-----

There is a simple implementation of a Filter in Scala.

ScalaJs
-------

To compile Scala to JavaScript:

1) Run sbt

2) Run fastOptJS

Maven
-----

Use Maven for uploading the project to Google App Engine with $ mvn appengine:update

Eclipse
-------

This project is using Maven for dependencies and creation of Eclipse project.
The result is however a Java project and some manual changes needs to be done.

Follow this guide at the bottom:

http://docs.scala-lang.org/tutorials/scala-with-maven.html

Quick fix:

1) Run mvn eclipse:eclipse

2) Edit .project file and replace buildSpec and natures with

```
<buildSpec>
  <buildCommand>
    <name>org.scala-ide.sdt.core.scalabuilder</name>
  </buildCommand>
</buildSpec>
<natures>
  <nature>org.scala-ide.sdt.core.scalanature</nature>
  <nature>org.eclipse.jdt.core.javanature</nature>
</natures>

```

3) Import project to Eclipse

3.1) Set scala source folders

3.2) Set output to src/main/webapp/WEB-INF/classes
