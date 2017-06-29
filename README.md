JPMS (Java Platform Module System) demo
=====================
[![Travis CI Build Status](https://travis-ci.org/decebals/jpms-demo.png)](https://travis-ci.org/decebals/jpms-demo)

It's an open source (Apache license) very simple JPMS demo.

Goal
-------------------
It's a preparation for a more ambitious objective: add support for JPMS/JIGSAW in [PF4J](https://github.com/decebals/pf4j) (Plugin Framework for Java).   
My opinion is that JPMS is an excellent solution for modularization of Java Platform but it adds to small value for modularization of Java applications.  
I hope that PF4J can be integrated with JPMS and it will fill the gap on the modularization of Java applications.

Structure
-------------------
The demo application is the same demo as [PF4J demo](https://github.com/decebals/pf4j/tree/master/demo).

In few words, this projects contains a very simple extension point (or service), `Greeting`

```java
public interface Greeting {

    String getGreeting();

}
```

some implementations: `HelloGreeting`, `WelcomeGreeting` and a main class, `Boot`, that prints all the implementations:

```java
public class Boot {

    public static void main(String[] args) {
        ServiceLoader<Greeting> providers = ServiceLoader.load(Greeting.class);
        providers.stream().forEach(provider -> {
            Greeting greeting = provider.get();
            System.out.println(greeting.getClass().getName() + " > " + greeting.getGreeting());
        });
    }

}
```

The directories layout is:
- `api` (declares [Greeting](https://github.com/decebals/jpms-demo/blob/master/api/src/main/java/ro/fortsoft/jpms/demo/api/Greeting.java) as extension-point)
- `app` (contains [Boot](https://github.com/decebals/jpms-demo/blob/master/app/src/main/java/ro/fortsoft/jpms/demo/Boot.java) class as the main class of application)
- `hello` (provides an implementation for `Greeting`, [HelloGreeting](https://github.com/decebals/jpms-demo/blob/master/hello/src/main/java/ro/fortsoft/jpms/demo/hello/HelloGreeting.java))
- `welcome` (provides another implementation for `Greeting`, [WelcomeGreeting](https://github.com/decebals/jpms-demo/blob/master/welcome/src/main/java/ro/fortsoft/jpms/demo/welcome/WelcomeGreeting.java))

I use `java.util.ServiceLoader` and `providers` feature from [module-info.java](https://github.com/decebals/jpms-demo/blob/master/hello/src/main/java/module-info.java) to declare services/extensions.

The project comes with a trivial [run.sh](https://github.com/decebals/jpms-demo/blob/master/run.sh) linux script that allows you to
run the demo from command line.
 
How to build and run
-------------------
Requirements: 
- [Git](http://git-scm.com/) 
- JDK 9 (test with `java -version`)
- [Apache Maven 3](http://maven.apache.org/) (test with `mvn -version`)

**Note**:
On my machine (Ubuntu 16.04) I use Java 9 build 9+175 for this project.

Steps:
- create a local clone of this repository (with `git clone https://github.com/decebals/jpms-demo.git`)
- go to project's folder (with `cd jpms-demo`) 
- run the demo (with `run.sh`)

The `run.sh` is very simple:
```
# create jar file for each module, in "mods" directory
mvn clean package

# run demo
java --module-path mods --module jpms.demo.app/ro.fortsoft.jpms.demo.Boot
```

The first line creates the jar files for each module and put these files in `mods` directory.
```
14:11 $ ls -l mods/
total 20
-rw-rw-r-- 1 decebal decebal 2535 iun 26 23:36 jpms-demo-api-0.0.1.jar
-rw-rw-r-- 1 decebal decebal 4237 iun 26 23:36 jpms-demo-app-0.0.1.jar
-rw-rw-r-- 1 decebal decebal 2779 iun 26 23:36 jpms-demo-hello-0.0.1.jar
-rw-rw-r-- 1 decebal decebal 2820 iun 26 23:36 jpms-demo-welcome-0.0.1.jar
```

**Note**: I specified the directory `mods` as jar output directory in the [pom.xml](https://github.com/decebals/jpms-demo/blob/master/pom.xml#L31) file:

The second line runs the demo. It contains two segments:
- `--module-path mods` specifies the directory of modules (`mods` in our case)
- `--module jpms.demo.app/ro.fortsoft.jpms.demo.Boot` specifies the main module and the main class

The output console of demo application is:
```
Running JPMS demo:
ro.fortsoft.jpms.demo.hello.HelloGreeting > Hello
ro.fortsoft.jpms.demo.welcome.WelcomeGreeting > Welcome
ro.fortsoft.jpms.demo.WhazzupGreeting > Whazzup
ro.fortsoft.jpms.demo.HowdyGreeting > Howdy
```

Resources
-------------
- [Project Jigsaw: Module System Quick-Start Guide](http://openjdk.java.net/projects/jigsaw/quick-start)
- [JEP 261: Module System](http://openjdk.java.net/jeps/261)
- [Java 9 modules - JPMS basics](http://blog.joda.org/2017/04/java-9-modules-jpms-basics.html)
- [Snippet: Java 9 Modules and JPMS](http://www.hascode.com/2017/04/snippet-java-9-modules-and-jpms)

License
--------------
Copyright 2017 Decebal Suiu

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with
the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
