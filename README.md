Gradle plugin for React
=======================

This is a very simple Gradle plugin to transform JSX sources into JavaScript. It was inspired by and is using the
[gradle-node-plugin][1] from [Sten Roger Sandvik][2].

[React][6] is

> A JAVASCRIPT LIBRARY FOR BUILDING USER INTERFACES

developed at Facebook and Instagram.

Status
------

* Build: [![Build Status](https://travis-ci.org/ehirsch/gradle-react-plugin.svg?branch=master)][3]
* Download: [![Download](todo)][4]
* License: [![License](http://img.shields.io/:license-apache-blue.svg)][5]

Installing the plugin
---------------------

Releases of this plugin are hosted at BinTray (http://bintray.com) and is part of jcenter repository.
Setup the plugin like this:

```groovy
buildscript {
	repositories {
		jcenter()
	}
	dependencies {
		classpath 'net.eikehirsch.react:gradle-react-plugin:0.1'
	}
}
```

Include the plugin in your build.gradle file like this:

```groovy
apply plugin: 'net.eikehirsch.react'
```

The plugin will also apply gradle-node-plugin for Node and NPM related tasks. (see [http://github/srs/gradle-node-plugin][1] for details).

Using the plugin
----------------

Simply run
```sh
./gradlew jsx
```
to transform any js file in `src/main/react`. The resulting files will be stored at `build/react`.

### Include jsx into with the build

If you want to have your jsx sources transformed everytime you build your project, you could do something like this:
```groovy
processResources.dependsOn jsx
```

Building the Plugin
-------------------

To build the plugin, just type the following command:

```sh
./gradlew clean build
```



[1]: https://github.com/srs/gradle-node-plugin "gradle-node-plugin"
[2]: https://github.com/srs "Stens' GitHup page"
[3]: https://travis-ci.org/ehirsch/gradle-react-plugin "build status on travis-ci"
[4]: todo
[5]: http://www.apache.org/licenses/LICENSE-2.0.html "Apache License v2.0"
[6]: http://facebook.github.io/react/index.html "React homepage"
