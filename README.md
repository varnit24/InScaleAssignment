# InScaleAssignment

## Prerequisities
 - JDK 1.8 or later
 - Maven

## Description:
Used Selenium Webdriver along with Java to automate the web application. TestNG is used as testing framework.
All the page classes are present under Controller package.
There are 2 testNG.xml files present under resources folder.
 - googleSearch_TestNG.xml is created the run the test cases related to google search flow.
 - browser_TestNG.xml is created to do the cross browser testing of another website.

## How to run

- Use googleSearch_TestNG.xml to run the automation testsuite related to google search flow.
- Use browser_TestNG.xml to run the automation test suite related to cross browser testing of web application.

## Note: I have used only ChromeDriver and firefoxDriver to do the cross browser testing. Also, browser driver .exe files for mac are present under resources folder.
In case, you are using windows, please download the replace the .exe browser drives files and change the path format in the base class and test class files under src/java/test folder.

<img width="1425" alt="report" src="https://user-images.githubusercontent.com/16473120/53318306-443e1c00-38e8-11e9-996d-3bd565535cd3.png">
