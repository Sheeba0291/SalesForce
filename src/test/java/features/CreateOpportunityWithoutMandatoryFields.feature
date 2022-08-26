Feature: Create Opportunity under SalesForce Application

Background: Positive Login
Given Login to SalesForce Application
|userName|password|
|hari.radhakrishnan@qeagle.com|India$321|
And Click on toggle menu button from the left corner
And Click view All

@regression
Scenario: Create an Opportunity without mandatory fields
Given Click Sales from App Launcher
And Click on Opportunity tab
And Click on New button
And Choose close date as Today
Then click Save and Verify Alert Message

