# AutoVentive coding exercise


## Introduction

There is no time limit for this exercise and you're free to spend as much time as you like on it, but as a rough guide you may wish to set aside around an hour. It is designed to be representative of an actual task you may be asked to work on at AutoVentive.

It's important to understand that the exercise is not pass or fail, it's simply an exercise that will form the basis of a discussion that we'll arrange
once you've completed it.  There may be some parts of the tasks or the code that are not completely clear; don't get hung up on that, just
be prepared to explain any problems you encounter. The exercise is quite broad and open ended: you may wish to change some parts of the existing code, or
you may not - again just be prepared to explain your reasoning. We're not looking for any particular "right answer", we just want to see how you might
approach such a situation in 'real life' and then discuss it during the interview.


## Orientation

The exercise is written in Groovy, because our real-life main application is written in Groovy (actually Grails: "Groovy on Rails"), but this is not a test of how well you know Groovy.
 Groovy is a JVM language, and if you wish you can simply write plain Java and it will still compile and run. The key differences between Groovy and Java are highlighted [here](https://groovy-lang.org/differences.html#:~:text=In%20Groovy%2C%20the%20methods%20which,based%20on%20the%20declared%20types.)

You'll see in the `Main` class that this application won't actually run. It doesn't need to run, and you don't need to make it run to complete the exercise.

If you're familiar with Spring Boot you'll expect to see url mappings on the controller methods. In Grails this is handled slightly differently, so don't be confused by
the absence of a url mapping. For example the `load` method in the `ContainerController`: just assume that an incoming POST request to, say, `/container/load` will hit that method.
Again, this application doesn't have to actually run - you don't need to implement a working API.

Again if you're familiar with Spring Boot you'll be used to accessing a database using a Repository pattern. This codebase essentially does the same thing
but with DAO classes.

The tests are written using the Spock framework. You don't need to have used Spock before to complete this test. Just
familiarise yourself with the [basics](https://spockframework.org/spock/docs/2.3/spock_primer.html).

You should interpret the sample application as 'brownfield' - i.e. not all of the existing code should be seen as well-written or in an ideal state.  Part of working with an established project is that some areas you need
to maintain or extend will often have issues with code style, formatting and/or design; use your own discretion if you feel you want, or need, to make changes (or not). Just be
prepared to explain your decisions afterwards. 

The code isn't based on any particular framework, and the classes are not in fact 'wired up' via dependency injection. 
You don't need to fix this. Assume that all dependencies on a 
class are properly instantiated/injected. 


## Domain Driven Language

The project and the terms used within it are based loosely on the DDL of the company.
The primary area the company operates in is vehicle logistics, where Assets (usually vehicles) are loaded onto Containers for transport.

The core terms used are:
* Asset - this is a physical product or unit that is being moved from location to location.  For example, a vehicle.
* Container - you can imagine this as being like a shipping container. The key thing to understand is that a Container can contain multiple Assets.


## TODO

* Implement the 'delete' method for the `ContainerController`
* Add an optional filter to the `list` method of `ContainerController` to filter by status
* Implement the logic for loading an Asset into a Container
* Add an `orientation` attribute to a `Container`
    * The orientation is used to determine which way a Container is facing, as a Container has a defined 'forwards' and 'backward'
* Add an `inventoryOrientation` attribute to the `Container` and the logic to set this value
    * The `inventoryOrientation` will be defined by the first asset being loaded
    * The inventory will always be loaded from the back into the first position,
        * e.g. if a Container is facing forwards, the assets will be loaded front-facing into the container from its back, and the `inventoryOrientation` will therefore be forwards too.
        * OR if the Container is facing backwards, the assets will be loaded front-facing into the container from its front, thus the `inventoryOrientation` will be backwards
* Add a method to ContainerController that returns a comma-separated String of Identifiers for any inventory loaded onto a given Container



## How to submit

Please submit your work as a Pull Request on the GitHub repository.
