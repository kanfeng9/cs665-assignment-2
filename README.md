| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Zhiling Li                 |
| Date         | 02/21/2024                 |
| Course       | Spring                     |
| Assignment # | 2                          |

# Assignment Overview

This assignment tasked students with developing a notification system for a delivery service, aiming to connect retailers with local drivers for the efficient delivery of products. The system's core requirement was to implement a mechanism that allows shops to notify drivers about new delivery requests, without the need for a graphical user interface. Instead, the functionality of the system was to be demonstrated through unit tests.

## Objectives

The key objectives of this assignment were as follows:

- **Implement Core Classes**: Develop classes for `Shop`, `DeliveryRequest`, and `Driver`, ensuring that these core components interact seamlessly to facilitate the notification and handling of delivery requests.
- **Observer Pattern**: Apply the Observer design pattern to enable a decoupled architecture where drivers can be dynamically notified about new delivery requests from shops.
- **Unit Testing**: Demonstrate the system's functionality through comprehensive unit tests, simulating real-world usage scenarios and verifying the correct behavior of the notification mechanism.
- **Software Design Principles**: Incorporate fundamental software design principles and patterns to achieve a solution that is not only functional but also flexible, maintainable, and understandable.

## Expectations

- **Flexibility**: The system should be designed with flexibility in mind, allowing for the easy addition or removal of shops, drivers, and delivery request types.
- **Maintainability and Understandability**: The code should be well-organized, clearly commented, and adhere to best practices, making it easy for others to read, understand, and maintain.
- **Avoidance of Duplication**: Duplicated code should be minimized through the use of abstraction, inheritance, and other relevant design patterns, promoting reusability and efficiency.
- **Design Pattern Application**: Students were encouraged to identify and apply appropriate design patterns beyond the Observer pattern, justifying their choices based on the specific problems they solve within the context of the assignment.

## Deliverables

Students were required to submit the following deliverables:

- **Source Code**: A complete set of source files for the implemented system, adhering to the specified requirements and design principles.
- **Unit Tests**: A suite of unit tests demonstrating the functionality of the system and covering a range of scenarios to ensure robustness.
- **Documentation**: A detailed documentation, including an Implementation Description section, outlining the design decisions, applied principles and patterns, and explaining the system's architecture and behavior.

This assignment provided an opportunity to apply theoretical knowledge of software engineering principles and design patterns to a practical problem, reinforcing the importance of thoughtful design in software development.


# GitHub Repository Link:

https://github.com/kanfeng9/cs665-assignment-2

# Implementation Description

## Overview

This application leverages core software design principles and patterns to create a flexible, maintainable, and understandable notification system for a delivery service. The system is designed to notify drivers about delivery requests from shops, demonstrating a clear application of the Observer pattern, encapsulation, and single responsibility principle among others.

## Design Principles and Goals

### Flexibility

- **Observer Pattern**: At the heart of the application's flexibility is the Observer pattern, which decouples the system's components. This pattern allows for easy addition or removal of observers (drivers in this context) without altering the core logic of the notification system (`ShopCentralSystem`). New driver types, such as `BikeDriver` or `DroneDriver`, can be easily integrated by implementing the `ShopObserver` interface.
- **Open/Closed Principle**: The system is designed to be open for extension but closed for modification. For instance, adding new types of delivery requests or new observers doesn't require changes to the existing codebase but rather extending it. This principle ensures that the system's flexibility doesn't come at the cost of stability.

### Simplicity and Understandability

- **Clear Naming and Structuring**: The code follows clear naming conventions and is structured logically, making it intuitive to understand the role of each class and interface. For example, `ShopObserver` clearly defines what observers need to implement, and `ShopCentralSystem` acts as the central point for notification logic.
- **Encapsulation**: By encapsulating behavior and data within classes and using interfaces to define contracts, the implementation reduces complexity and enhances understandability. This approach hides the internal workings of classes, exposing only what is necessary for interaction.

### Avoidance of Duplicated Code

- **DRY Principle**: The application adheres to the "Don't Repeat Yourself" principle. Shared functionalities, such as notification mechanisms, are centralized in the `ShopCentralSystem`. This not only reduces duplication but also centralizes changes to the notification logic, minimizing the risk of inconsistencies.
- **Utilization of Inheritance and Interfaces**: Where applicable, inheritance is used judiciously to share common functionalities among different types of drivers, reducing code duplication while maintaining the flexibility to implement specific behaviors for each driver type.

### Use of Design Patterns

- **Observer Pattern**: Chosen for its effectiveness in creating a decoupled architecture where multiple observers (drivers) need to be notified of changes (delivery requests) without creating tight dependencies between them. This pattern enhances the system's ability to adapt to changes with minimal impact on the existing codebase.
- **Factory Method Pattern** (hypothetical addition): While not implemented in the provided snippets, the Factory Method pattern would be an ideal candidate for creating different types of `Driver` or `DeliveryRequest` objects. This pattern could further decouple object creation from its usage, enhancing flexibility and maintainability.

## Conclusion

The implementation of the delivery notification system demonstrates a thoughtful application of software design principles and patterns to achieve a system that is flexible, understandable, and maintainable. By leveraging the Observer pattern, emphasizing clear code organization, and adhering to principles like DRY and encapsulation, the application is well-positioned to accommodate future expansions or modifications with minimal disruption to the existing codebase.


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/)
on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a
standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains
information about the project, such as its dependencies, the build configuration, and the plugins used for building and
packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the
dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that
builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to
use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports,
and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the
behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is
annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the
code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and
easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code
they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all
required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time
changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for
manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool
that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems
or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and
other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately
obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to
meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the
development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues
later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential
security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source
tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as
well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on
any issues or violations of the coding standards defined in its configuration. This includes issues like code style,
code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices,
making it easier for other developers to read and maintain. It can also help to identify potential issues before the
code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a
wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing
tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




