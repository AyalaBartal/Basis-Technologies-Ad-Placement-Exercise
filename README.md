# Basis-Technologies-Ad-Placement-Exercise

1) An overview of your design decisions
My goal was to create a short, clean, and extendable project that is easy to read, understand and modify for new features. So, I design it in Agile and clean architecture. 
The app code is designed with clean/onion/layer architecture. It has 3 separate domains/models for the input, core/logic/internal and output layers. The core logic is made only of native java and is independent from the source of input (files), its format (csv), the trigger (rest api), the output (print to console) and any external framework except from the dependency manager itself. SpringBoot is used for both dependency injection and rest api. For simplicity, native java is used to read and parse the input and to write the output. However, the code can easily be modified to use an external tool to read the input or write the output if it's required.

2) Programming Language and frameworks
I choose the programming language and frameworks that are common in the industry so that it will be easy to build, run, test, read, understand and modify the project.
Programming language: Java 8 (not 17) - old but stable, most popular version of java.
Dependency manager: Maven
Framework: Springboot
Test framework: junit, mockito 
Json: gson

 
3) How to run the project
Install git, java jre/jdk 8 and maven
Use git to extract the project source files from its bundle
Use maven to build the project from source into jar
Note: I also added the jar file as backup method
Use java to run the jar
Use curl to send requests to the app/server rest api:
    For Linux the commands are:
        - curl -X POST -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_placement" -d '{"placmentFile":"files\\placements.csv", "deliveryFile":"files\\deliveries.csv"}'
        - curl -X POST -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_date_range" -d '{ "placmentFile" : "files\\placements.csv", "deliveryFile" : "files\\deliveries.csv", "startDate" : "11/22/2020", "endDate" : "12/05/2020" }'
    Fo Windows the commands are:
        - curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_placement" -d "{\"placmentFile\":\"files\\placements.csv\", \"deliveryFile\":\"files\\deliveries.csv\"}"
        - curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_date_range" -d "{ \"placmentFile\":\"files\\placements.csv\", \"deliveryFile\":\"files\\deliveries.csv\", \"startDate\":\"11/22/2020\", \"endDate\":\"12/5/2020\"}"

Use maven to run unit test
