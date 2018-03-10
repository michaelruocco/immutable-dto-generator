# Immutable DTO Generator

[![Build Status](https://travis-ci.org/michaelruocco/immutable-dto-generator.svg?branch=master)](https://travis-ci.org/michaelruocco/immutable-dto-generator)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/immutable-dto-generator/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/immutable-dto-generator?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/immutable-dto-generator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/immutable-dto-generator)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/55c9939f55a94822864280ea0114bfb0)](https://www.codacy.com/app/michaelruocco/immutable-dto-generator?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/immutable-dto-generator&amp;utm_campaign=Badge_Grade)

This library was created because I wanted to have a go at creating something
that handled code generation. The idea of this project is that it could be
used as a potential alternative to something like
(Project Lombok)[https://projectlombok.org/] which amongst other things,
allows you to not have to write (and therefore write tests for) your getter
and setter methods on your basic DTO / java bean classes.

The project lombok approach works by you writing a class where you simply
define the list of fields in the class and the rest of the code required
like the constructors and getters and setters are covered by annotations
attached to the class. The (Project Lombok)[https://projectlombok.org/]
documentation will do a far better job of explaining it than I can, so
for more details I would recommend that you read the documentation there.

Obviously Lombok is a very mature project in comparision to this library,
and so is very much more feature rich. The two drivers for this project
were simply to explore an alternative approach that included less "magic"
and also so that I could have a go at writing code to generate code, which is
not something I had done before. The idea is that you can specify where you
want your generated code to live (source set and package), and what fields
your class needs to contain, and the library will generate a DTO class,
a builder (as it only currently supports constructors following the (builder
pattern)[https://en.wikipedia.org/wiki/Builder_pattern] at present) and
a unit test class that will give 100% coverage on the generated classes.

When investigating how to go about generating java code I came across a
library called (JavaPoet){https://github.com/square/javapoet]. I have been
very impresssed with the ease of use of JavaPoet and found it very easy to get
going with, so if Java code generation is something you are interested in
I would strongly recommend you check it out in more detail. It is heavily
used in this library, so there are plenty of examples available in this
code base.

Coming shortly will be another project, that attempts to use this library
to create an Intellij plugin that will enable you to generate DTO classes
directly from the Intellij IDE. This is another thing that I have never had
a chance to try out but have been looking to work on.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:immutable-dto-generator:1.0.0'
}
```

### Generating classes

Once you have the jar on your classpath you configure how you want
your class to look by creating an instance of a class that implements
the GenerationParams interface. There is a DefaultGenerationParams provided,
or you can use the interface to roll your own. A simple example using
the default provided class is shown below:

```
DefaultGenerationParams params = new DefaultGenerationParams();
params.setDtoClassName("MyDto");
params.setTestClassName("MyDtoTest"); // if not set, default value of dto class name with "Test" appended will be used
params.setBuilderClassName("MyDtoBuilder"); // if not set, default value of dto class name with "Builder" appended will be used
params.setPackageName("my.dto.package");
params.addFieldDefinition("value1", "java.lang.String");
params.addFieldDefinition("value2", "int");
```

When setting the field definitions there are various overloaded method options with different ways of
specifying what the type of the field should be, but the simplest one of passing a string value is shown
above. When passing Object types e.g. String, or Object, it is recommended to provide the fully qualified
path name where ever possible. The library will attempt to guess which classes you mean where it can, but
this might lead to quirks and errors. The fully qualified path name is the safest and most predictable way
to go.

Once you have your definition you can use classes that implement the Generator interface to turn them into
source code. There are various classes that are used in this process and you can have a look through the
source to understand better how it hangs together. The top level class that is intended to be used by
client project is the FilesGenerator. This does wraps 3 other generator classes, one for the dto class itself,
one of the builder, and one for the test class. When you create an instance of the FileGenerator you pass
it two arguments, one to tell it the path to where your production code should be generated, and the
other to tell it where the path where your test code should be generated. Once you have created an instance
you can call the generate method and pass your GenerationParams and it will create all the Java class files
for you at the specified location:

```
Path prodSourcePath = Paths.get("src/main/java/");
Path testSourcePath = Paths.get("src/test/java/");
FilesGenerator generator = new FilesGenerator(prodSourcePath, testSourcePath);

DefaultGenerationParams params = new DefaultGenerationParams();
params.setDtoClassName("MyDto");
params.setTestClassName("MyDtoTest"); // if not set, default value of dto class name with "Test" appended will be used
params.setBuilderClassName("MyDtoBuilder"); // if not set, default value of dto class name with "Builder" appended will be used
params.setPackageName("my.dto.package");
params.addFieldDefinition("value1", "java.lang.String");
params.addFieldDefinition("value2", "int");

generator.generate(params);
```

The generate method will throw an exception if there are any problems, otherwise the 3 specified
classes will be generated in the specified folders using the specified names and package structures.

### Generated Test Classes / Asserts

The test class that is generated currently only supports using [AssertJ](http://joel-costigliola.github.io/assertj/)
for all assertions, this is mainly because I choose to use it in all of my own projects as I believe it is easier to
read and more expressive that standard junit or hamcrest assertions. I may look into making the project more configurable
and adding support for standard junit and hamcrest in the future, alternatively feel free to create a pull request and try
to add them in yourself, although I would strongly recommend you check out assertJ if you haven't used it before, I did
and now it is by far my favourite of the three.

## Running the Tests

You can run the unit tests for this project by running:

```
gradlew clean build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```