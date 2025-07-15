# My Java Project

## Overview
This is a simple Java project that demonstrates the use of Gradle for building, testing, and integrating with SonarQube for code quality analysis.

## Project Structure
```
my-java-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── App.java
│   │   └── resources
│   ├── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── AppTest.java
│       └── resources
├── build.gradle
├── settings.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd my-java-project
   ```

2. **Build the project:**
   Use the Gradle wrapper to build the project:
   ```
   ./gradlew build
   ```

3. **Run tests:**
   To execute the tests, run:
   ```
   ./gradlew test
   ```

4. **Generate coverage reports:**
   Coverage reports can be generated using:
   ```
   ./gradlew jacocoTestReport
   ```

5. **SonarQube Integration:**
   Ensure that SonarQube is running in a Docker container. You can start SonarQube using:
   ```
   docker run -d -p 9000:9000 sonarqube
   ```

   To analyze the project with SonarQube, run:
   ```
   ./gradlew sonarqube -Dsonar.projectKey=my-java-project -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<your-sonarqube-token>
   ```

## Usage
After building the project, you can run the application using:
```
java -cp build/libs/my-java-project.jar com.example.App
```

## License
This project is licensed under the MIT License.