# Prima Diagnostics Automation Framework

## Overview

Prima Diagnostics Automation Framework is a Selenium-based test automation project developed to automate web application testing efficiently. The framework follows industry best practices and is designed to be scalable, maintainable, and reusable.

The framework supports UI automation, screenshot capturing, reporting, and data-driven testing to improve test coverage and reduce manual effort.

---

## Features

- Selenium WebDriver automation
- Java-based framework
- TestNG test execution
- Maven dependency management
- Page Object Model (POM) design pattern
- Reusable utility classes
- Automatic screenshot capture
- Explicit and implicit wait handling
- Cross-browser support
- Configurable test data
- HTML test reports
- Easy maintenance and scalability

---

## Technology Stack

| Technology | Version |
|-----------|----------|
| Java | 8+ |
| Selenium WebDriver | Latest |
| TestNG | Latest |
| Maven | Latest |
| Eclipse IDE | Recommended |
| Git | Version Control |

---

## Project Structure

```
src/main/java
│
├── Pages
├── Utilities
├── Base
├── Config
└── Helpers

src/test/java
│
├── TestCases
└── TestRunner

Screenshots
Reports
TestData
Configuration Files
```

---

## Framework Design

The framework follows the Page Object Model (POM) design pattern.

- Base Class
    - Driver initialization
    - Browser management
    - Common setup and teardown

- Page Classes
    - Store page locators
    - Page-specific methods

- Utility Classes
    - Screenshot utility
    - Wait utility
    - Common helper methods

- Test Classes
    - Execute test scenarios
    - Validate application functionality

---

## Prerequisites

Before running the project, ensure the following are installed:

- Java JDK 8 or above
- Maven
- Eclipse IDE
- Git
- Chrome Browser

---

## Installation

### Clone the repository

```bash
git clone https://github.com/your-username/PrimaDiagnostics.git
```

### Navigate to the project

```bash
cd PrimaDiagnostics
```

### Install dependencies

```bash
mvn clean install
```

---

## Running Tests

Run all test cases:

```bash
mvn test
```

Or execute TestNG XML from Eclipse:

```
Right Click -> testng.xml -> Run As -> TestNG Suite
```

---

## Screenshot Handling

The framework automatically captures screenshots:

- During test execution
- On test failures
- Before browser closure (if configured)

Screenshots are stored in:

```
/Screenshots
```

---

## Reporting

After execution, test reports are generated for result analysis.

Reports include:

- Pass/Fail status
- Execution time
- Test logs
- Screenshots for failures

---

## Browser Support

- Google Chrome
- Microsoft Edge
- Mozilla Firefox (optional)

---

## Best Practices Followed

- Page Object Model (POM)
- Reusable methods
- Modular framework structure
- Exception handling
- Configurable test execution
- Centralized utilities
- Clean coding standards

---

## Future Enhancements

- Parallel execution
- Jenkins CI/CD integration
- Docker support
- Data-driven testing
- API automation integration
- Extent Reports
- Cross-browser parallel execution
- Cloud execution using Selenium Grid

---

## Author

**Abiseik**

QA Automation Engineer

---

## Contributing

Contributions, suggestions, and improvements are welcome. Feel free to create a pull request or raise an issue.

---

## License

This project is intended for learning and internal automation purposes.
