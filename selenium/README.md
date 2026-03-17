# Selenium Practice Framework (Java)

A small practice automation project built to refresh and demonstrate core QA automation concepts in Java using Selenium.

## What this project demonstrates

This repo shows hands-on practice with:

- Selenium WebDriver
- Explicit waits with `WebDriverWait` and `ExpectedConditions`
- TestNG test structure and assertions
- Page Object Model (POM)
- Basic Cucumber / BDD setup
- Externalized test data/constants
- Login workflow validation against a sample site

The practice site used is:
- `https://the-internet.herokuapp.com/login`

## Tech stack

- Java
- Selenium WebDriver
- TestNG
- Cucumber
- Maven

## Project structure

- `pages`
  - `LoginPage`
  - `SecureAreaPage`

- `stepdefinitions`
  - `LoginSteps`

- `runners`
  - `LoginRunner`

- `testdata`
  - `LoginTestData`

- test classes
  - raw Selenium / TestNG examples
  - POM-based flow example

- feature files
  - `src/test/resources/features/login.feature`

## What is included

### 1. Basic Selenium / TestNG practice
Examples covering:
- locating elements
- entering text
- clicking buttons
- validating URL changes
- validating messages
- positive and negative login scenarios

### 2. Page Object Model (POM)
The login flow was refactored into page classes so that:
- page classes own locators and actions
- test classes focus on flow and assertions

### 3. Basic Cucumber / BDD example
A small working BDD example was added using:
- feature file
- step definitions
- hooks
- runner class

This example reuses the existing page objects underneath.

## Current working scenarios

- Valid login
- Invalid login
- Login then logout flow
- Valid login via Cucumber feature

## How to run

### TestNG examples
Run the TestNG test classes directly from the IDE or via Maven.

### Cucumber runner
Run the Cucumber runner class:
- `LoginRunner`

### Maven
You can also run tests through Maven from the project root.

## Notes

This project is intended as a learning / refresh repo, not a full production framework.

The goal was to practice and demonstrate:
- Selenium fundamentals
- framework organization
- POM basics
- BDD basics

## Future improvements

Possible future enhancements:
- better config management
- cleaner hooks separation
- GitHub Actions / CI integration
- additional BDD scenarios
- API testing examples
- stronger README/run instructions

## Author note

This project was built as part of skills refresh in Java-based test automation.
