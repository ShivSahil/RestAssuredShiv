# RestAssured Framework for testing Book API (By Shiv Sahil Guleri)

## How to Run the Tests

### Prerequisites

- Maven 3.8.4+
- Java 17+
- Git
- Any IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)
- Run Book Store API on local machine after reading the Book API's own README.md file

### Steps to Execute

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/bookapi-tests.git
   cd RestAssuredShiv
2. Run the Scenarios
   ```bash
   mvn clean test
3. to see report. Reports are generated with a time stamped named for easy identification
   cd RestAssuredShiv/report


## FrameWork structure
```
src/main/java/
└── com/bookapi/
    ├── assertions/
    │   └── WrappedAssert.java          #  TestNG’s built-in assertion capabilities by wrapping them with Log4j + extent repor
    │
    │── endPoints/
    │   └── EndPoints.java              # holds all API endpoint paths as constants for easy reuse and maintainability.
    │
    ├── logs/
    │   ├── ConsoleColors.java          # #provides colored console output for better readability
    │   └── WrappedReportLogger.java    # wraps Log4j + ExtentReports to log messages with console colors and reporting integration
    │
    ├── pojo/
    │   ├── request/                    # Request POJO classes
    │   └── response/                   # Response POJO classes
    │
    ├── report/
    │   └── ExtentFactory.java          # ExtentReports setup by integrating with ITestListener to generate HTML test report
    │
    └── reportBuilder/                  
    │   └── ApiClient.java              # sends HTTP requests and validates responses against expected status codes and JSON schemas.
    │   └── RequestBuilder.java         # reusable RestAssured request specifications with optional auth, body, and parameters.
    │
    │── utils/
    │   └── ConfigurationManager.java   # access config.properties file
    │   └── DataGenerator.java          # provides utility methods to generate random test data such as email, ID, password, and year.
    │   └── EnvConfigResolver.java      # dynamically loads environment-specific configuration based on the selected environment
      

