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
│└──com/bookapi/assertions/
││└──WrappedAssert.java #extends TestNG’s built-in assertion capabilities by wrapping them with Log4j logging, ExtentReports integration
|└──com/bookapi/logs/
││└──ConsoleColors.java #provides ANSI escape codes to add colors, bold, underline, and background styles to console output for better readability
││└──WrappedReportLogger.java #wraps Log4j and ExtentReports to log messages with console colors and reporting integration
|└──com/bookapi/pojo/request/  #Request POJO classes
|└──com/bookapi/pojo/response/  #Response POJO classes
|└──com/bookapi/report/
||└──ExtentFactory.java # ExtentReports setu by integrating with ITestListener to generate HTML test reports.
|└──com.bookapi.reportBuilder

      

