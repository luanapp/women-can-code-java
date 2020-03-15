
<!-- PROJECT SHIELDS -->
[![Build Status][build-shield]][build-url]
[![Coverage Status][coverage-shield]][coverage-url]
[![GitHub contributors][contributors-shield]][contributors-url]
[![GPLv3 License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/luanapp/women-can-code-java">
    <img src="women-can-code.png" alt="Women Can Code logo" width="658" height="370">
  </a>
</p>

# Women Can Code - Java Backend Module
This repository is used as an auxiliary resource for the Java Backend Course for the Women Can Code project

## Table of Contents
* [About the Course](#about-the-course)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Building the project](#building-the-project)
* [Running the project](#running-the-project) 


## About the Course
// TODO
## Getting Started
Right in the following sections, there'll be steps of how to build and run the project locally.
### Prerequisites
Maven - version 3.5 or higher.<br/>
Java - JDK version 8 or higher.
### Building the project
To build the project, go to the project root folder and run:
```sh
mvn clean package
```
## Running the project 
After building the project, a .jar file will be available in the `target` folder. You can run the project by running:
```sh
cd ./target
java -jar ToDo-List-0.0.1-SNAPSHOT.jar
```
Another way of doing that, without the need of running the previous steps is by running:
```sh
mvn clean spring-boot:run
```
## License
Distributed under GPLv3 license. See [License](LICENSE) for more information.

[build-shield]: https://travis-ci.org/luanapp/women-can-code-java.svg?branch=master
[build-url]: https://travis-ci.org/luanapp/women-can-code-java
[contributors-shield]: https://img.shields.io/github/contributors/luanapp/women-can-code-java.svg
[contributors-url]: https://github.com/luanapp/women-can-code-java/graphs/contributors
[coverage-shield]: https://coveralls.io/repos/github/luanapp/women-can-code-java/badge.svg?branch=master
[coverage-url]:https://coveralls.io/github/luanapp/women-can-code-java?branch=master
[license-shield]: https://img.shields.io/badge/license-GPLv3-blue.svg?style=flat-square
[license-url]: https://raw.githubusercontent.com/luanapp/women-can-code-java/master/LICENSE
