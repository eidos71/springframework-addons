# Spring Framework Addons
This project is about an open source collection of extensions to the Spring framework.

==========================================================================

## Project Information

* [About](http://unicon.github.io/springframework-addons/)
* [Changelog](https://github.com/Unicon/springframework-addons/blob/master/changelog.md) 
* [JavaDocs](http://unicon.github.com/springframework-addons/apidocs/index.html)
* [Wiki](https://github.com/Unicon/springframework-addons/wiki)

## Current version
`0.1`

## Build 

[![Build Status](https://travis-ci.org/Unicon/springframework-addons.png)](https://travis-ci.org/Unicon/springframework-addons)

You can build the project from source using the following Maven command:

```bash
$ mvn clean package
```

## Usage
Declare the project dependency in your Local CAS server `pom.xml` file as:
```xml
<dependency>
    <groupId>net.unicon.springframework</groupId>
    <artifactId>springframework-addons</artifactId>
    <!-- See above for the latest released version number -->
    <version>${springframework-addons.version}</version>
</dependency>
```
