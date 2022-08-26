Feature: Create Dashboard under SalesForce Application

Background: Positive Login
Given Login to SalesForce Application
|userName|password|
|hari.radhakrishnan@qeagle.com|India$321|
And Click on toggle menu button from the left corner
And Click view All

@sanity
Scenario Outline: Create an Dashboard
Given Click Dashboards from App Launcher
And Click on the New Dashboard option
And Enter Name as <dashboardName>
Then Click on Create and Verify Dashboard name

Examples:
|dashboardName|
|SalesForce Automation by Rajee|
|Sales Automation by Karee|

 