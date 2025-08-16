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

## Sample Report
[Download Sample Report](./report/Sample_15_August_10_pm_37_13_Report.html)

## Validation Covered
Validation is handled through the *WrappedAssert* class, which extends TestNG’s built-in assertions with Log4j and ExtentReports integration.

1. Header and body validations are covered within the test cases.
2. Schema validation is built into the *ApiClient* class.
3. Status code validation is also built into the *ApiClient* class.
4. Negative test cases are included as well.


## Project Architecture
- Each Request is covered under a test class file of same name. like *Get All Books* request test class name "GetAllBooksTest.java"
- a test class can have multiple testcases.
- in each testcases, logs are written using WrappedReportLogger class. these logs are displayed on the console as well as the Extent Report!
- ApiClient.class sends HTTP requests like GET, POST, PUT, DELETE and validates responses against expected status codes and JSON schemas. For validation inside ApiClient.class, I have used WrappedAssert.class.
- In order to send request with different combination like request with Auth Token, request with Body And No Auth Token etc. I have implemented RequestBuilder.class. these spec builder method of RequestBuilder.class, can accept Path and Query Params as well.

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
    │

src/main/resources/
└── schemas/                            # contains all the response schemas which are used ApiClient.java for validation
└── log4j2.xml                          # log4j file


src/test/java/
└── com/bookapi/testcases/
    ├── assertions/                     # All the testcases are written here

config.properties                       
pom.xml                                     
testng.xml


## All the tools used

- Maven 3.8.4+
- Java 17+
- Git
- Any IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)
- RestAssured
- TestNG
- log4j2
- ExtentReports
- GitHub Actions: CI/CD pipeline for automated testing and deployment


