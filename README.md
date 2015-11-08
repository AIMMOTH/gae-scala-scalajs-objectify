Google App Engine with Scala and ScalaJS
========================================

Scala
-----

There is a simple implementation of a Filter in Scala.


ScalaJs
-------

To compile Scala to JavaScript:

1) Run sbt

2) Run fastOptJS


Run Locally
-----------


### Run Maven Build ###

1) Start SBT $ sbt

2) Generate JavaScript $ fastOptJS

3) Optional: Edit pom.xml to set address, port and remove Java debugging.

4) Exit and start with maven $ mvn appengine:devserver

5) Optional: Hot deploy new code with $ mvn package


### Start Local Development ###

1) Start SBT $ sbt

2) Generate JavaScript $ fastOptJS

3) Build the target directory $ mvn package

4) Copy all dependencies into your source code. Example:

```
$ copy target/gae-scala-scalajs-objectify-1.0-SNAPSHOT/WEB-INF/lib/ src/main/webapp/WEB-INF/lib/
```

5) Obtain Google Appengine SDK via Maven or download.

6) Use dev_appserver to run project. Example:

```
%APPENGINE_SDK_HOME%/bin/dev_appserver -a localhost -p 8080 src/main/webapp
```

7) Optional: Add the following flag to start Remote Java debugging:

```
--jvm_flag=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
```


Maven
-----

Use Maven for uploading the project to Google App Engine with $ mvn appengine:update


Eclipse
-------

This project is using Maven for dependencies and creation of Eclipse project.
The result is a Java project and some manual changes needs to be done.

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

3.2) Either set output to

3.2.1) Maven target
 
```
target/gae-scala-scalajs-objectify-1.0-SNAPSHOT/WEB-INF/classes
```

3.2.2) Your source
 
```
src/main/webapp/WEB-INF/classes
```
