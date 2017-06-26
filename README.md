JPMS (Java Platform Module System) demo
=====================
[![Travis CI Build Status](https://travis-ci.org/decebals/jpms-demo.png)](https://travis-ci.org/decebals/jpms-demo)

It's an open source (Apache license) very simple JPMS demo.

Goal
-------------------
It's a preparation for a more ambitious objective: add support for JPMS/JIGSAW in [PF4J](https://github.com/decebals/pf4j) (Plugin Framework for Java).   
My opinion is that JPMS is an excellent solution for modularization of Java Platform but it adds to small value for modularization of Java applications.  
I hope that PF4J can be integrated with JPMS and it will fill the gap on the modularization of Java applications.

How to build and run
-------------------
Requirements: 
- [Git](http://git-scm.com/) 
- JDK 9 (test with `java -version`)
- [Apache Maven 3](http://maven.apache.org/) (test with `mvn -version`)

**Note**:
On my machine I use Java 9 build 9+175 for this project.

Steps:
- create a local clone of this repository (with `git clone https://github.com/decebals/jpms-demo.git`)
- go to project's folder (with `cd jpms-demo`) 
- run the demo (with `run.sh`)

License
--------------
Copyright 2017 Decebal Suiu

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with
the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
