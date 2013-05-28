0ReadMe
======

This is sample project proposing an organization of the differents modules for an ESB project.

Directory tree:
---------------

Here how the project is organised - when a comment is needed on the purpose of the file, a reference
is specified next to it, between parenthesis. This reference is then associated to a more verbosy
comment, that you'll find below the directory tree:

mvn-skeleton-project
|-- ReadMe.txt                          (this file)
|-- pom.xml                             main pom.xml (1)
|-- jars                                jars artefact (2)
|   |-- business-objects
|   |   |-- pom.xml
|   |   `-- src
|   `-- business-objects-with-jpa
|       |-- pom.xml
|       `-- src
|-- esb                                 esb artefacts (3)
|   |-- pom.xml
|   |-- sample-esb-app
|   |   |-- pom.xml
|   |   `-- src
|   |-- sample-esb-app-with-fs
|   |   |-- pom.xml
|   |   `-- src
|-- soa-p-setup                         SOA-P profile generator project - to setup dev or prod env (4)
|   `-- pom.xml
`-- war                                 other artefact (5)
    `-- my-webapp
        |-- pom.xml
        `-- src
`-- ear
    `-- my-ear
        |-- pom.xml
        `-- src


18 directories, 11 files


Details:
--------

(1) main parent-pom:

This pom.xml aims at regrouping all common plugins, dependency and configuration for all
related project. All other pom.xml inherits from this one, therefore removing the needs of
duplicated configuration.

(2) jars artefacts:

This directory is designed to regroup all Java code project related to the project. Those are
NOT .esb project on purpose. They should be added to any .esb project that needs then as
dependencies. This will avoid tying the actuall code to the ESB API and also allow to run unit
test outside the container.

(3) esb artefacts:

This folder contains a second parent pom that regroups all the common configuration, dependency and
plugins common to any ESB project. Note those project should be EMPTY any java code, as should
mostly relying on existing actions provided by the ESB.

If the project needs to use some java code, it needs to use a CustomAction to wrap the code provided
by the jars.

BUG IN MAVEN PACKAGING PLUGIN:

A defect in the current maven-jboss-packaging-plugin leads it to try to package the secondary
pom-parent project as an .esb project, while it is declare as packaging "pom". To fix this issue,
the plugin has been modified, and this version needs to be available inside the artifact repository
(Nexus repository or other) - while waiting for the fix to be released.

(4) soa-p setup

TODO: Not done yet - this project will allow to create a DEV or a PROD profile for SOA-P using a
custom maven plugin.

(5) other artefacts

If the project deploys also other artefacts, such as EAR and WAR, it could make sense to let them
lived in the same maven project as the ESB, as they are most likely going to share dependency
definition (to the least).

