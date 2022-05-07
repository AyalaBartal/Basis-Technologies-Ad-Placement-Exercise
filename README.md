# Basis-Technologies-Ad-Placement-Exercise

1) An overview of your design decisions
My goal was to create a short, clean, and extendable project that is easy to read, understand and modify for new features. So, I design it in Agile and clean architecture. 
I work alone in an agile and TDD development mythology. E.g. I started from a minimal viable product with tests and added more features, tests and code with each git commit. 
The app code is designed with clean/onion/layer architecture. It has 3 separate domains/models for the input, core/logic/internal and output layers. The core logic is made only of native java and is independent from the source of input (files), its format (csv), the trigger (rest api), the output (print to console) and any external framework except from the dependency manager itself. SpringBoot is used for both dependency injection and rest api. For simplicity, native java is used to read and parse the input and to write the output. However, the code can easily be modified to use an external tool to read the input or write the output if it's required.

2) Programming Language and frameworks
I choose the programming language and frameworks that are common in the industry so that it will be easy to build, run, test, read, understand and modify the project.
Programming language: Java 8 (not 17) - old but stable, most popular version of java.
Dependency manager: Maven 
Framework: Springboot
Test framework: junit, mockito, rest-assured, 
Json: gson, jackson

 
3) How to run the project
Install git, java jre/jdk 8 and maven
Use git to extract the project source files from its bundle
Use maven to build the project from source into jar
Note: I also added the jar file as backup method
Use java to run the jar
Use curl to send requests to the app/server rest api- for each api the correct command can be found as a comment above the code on the Controller class.
Use maven to run unit test
