#Seam Solder

A portable CDI extension library for applications, frameworks and other
extensions based on CDI.

Seam Solder is independent of CDI implementation and fully portable between
Java EE 6 and Servlet environments enhanced with CDI.

For more information, see the [Seam Solder project page](http://seamframework.org/Seam3/Solder).

## Building

   mvn clean install -Pjboss-public-repository

or

  mvn clean install -s settings.xml

The profile is not required if the JBoss Nexus repository is setup in your settings.xml

See the testsuite/readme.md file for information about running the testsuite in various containers.

