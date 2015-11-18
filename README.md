# Gradle plugin for React

[![Build Status](https://travis-ci.org/ehirsch/gradle-react-plugin.svg?branch=master)][3] [![Download](https://api.bintray.com/packages/ehirsch/maven/gradle-react-plugin/images/download.svg)][4] [![License](http://img.shields.io/:license-apache-blue.svg)][5]

This is a very simple Gradle plugin to transform JSX sources into JavaScript. It was inspired by and is using the
[gradle-node-plugin][1] from [Sten Roger Sandvik][2].

[React][6] is

> A JAVASCRIPT LIBRARY FOR BUILDING USER INTERFACES

developed at Facebook and Instagram.

## Installing the plugin

Releases of this plugin are hosted at BinTray (http://bintray.com) and is part of jcenter repository.
Setup the plugin like this:


### Gradle versions since 2.1

```groovy
plugins {
    id 'net.eikehirsch.react' version '0.3.1'
}
```

### Gradle versions below 2.1

```groovy
buildscript {
	repositories {
		jcenter()
	}
	dependencies {
		classpath 'net.eikehirsch.react:gradle-react-plugin:0.3.1'
	}
}

apply plugin: 'net.eikehirsch.react'
```

The plugin will also apply gradle-node-plugin for Node and NPM related tasks. (see [http://github/srs/gradle-node-plugin][1] for details).

## Using the plugin

Simply run

```sh
./gradlew jsx

# for older gradle (e.g. 1.4) versions use:

./gradelw 'jsx'
```
to transform any js file in `src/main/react`. The resulting files will be stored at `build/react`.

### Configure the plugin

To change the defaults you can put all your settings into the `jsx` namespace:

```groovy
jsx {
  sourcesDir = 'src/react'
  destDir    = 'out'
}
```

### Create your own jsx task

You can define the input and output folders without using the extension namespace like this:

```groovy
task myJSX( type: JSXTask ) {
    sourcesDir = 'src/react'
    destDir = 'out'
}
```
(You can try this at the configuration example project)

### Include jsx with the build

If you want to have your jsx sources transformed everytime you build your project, you could do something like this:

```groovy
processResources.dependsOn jsx
```

## Building the Plugin

To build the plugin, just type the following command:

```sh
./gradlew clean build
```

## Acknowledgments

* Thanks to [Sten R. Sandvik][2] for his [node plugin][1]
* that's all for now.



[1]: https://github.com/srs/gradle-node-plugin "gradle-node-plugin"
[2]: https://github.com/srs "Stens' GitHup page"
[3]: https://travis-ci.org/ehirsch/gradle-react-plugin "build status on travis-ci"
[4]: https://bintray.com/ehirsch/maven/gradle-react-plugin/_latestVersion "download latest version"
[5]: http://www.apache.org/licenses/LICENSE-2.0.html "Apache License v2.0"
[6]: http://facebook.github.io/react/index.html "React homepage"
