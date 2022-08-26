Feature: Create Account under SalesForce Application

Background: Positive Login
Given Login to SalesForce Application
|userName|password|
|hari.radhakrishnan@qeagle.com|India$321|
And Click on toggle menu button from the left corner
And Click view All

@smoke
Scenario Outline: Create an Account
Given Click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter account name as <accountName>
And Select Ownership as Public
Then Click save and verify Account name

Examples:
|accountName|
|Sheeba|
|Karthik|