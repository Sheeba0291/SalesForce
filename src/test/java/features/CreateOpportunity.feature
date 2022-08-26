Feature: Create Opportunity under SalesForce Application

Background: Positive Login
Given Login to SalesForce Application
|userName|password|
|hari.radhakrishnan@qeagle.com|India$321|
And Click on toggle menu button from the left corner
And Click view All

@functional
Scenario Outline: Create an Opportunity
Given Click Sales from App Launcher
And Click on Opportunity tab
And Click on New button
And Enter Opportunity name as <opportunityName>
And Choose close date as Today
And Select Stage as <stageName>
Then click Save and VerifyOppurtunity Name

Examples:
|opportunityName|stageName|
|Salesforce Automation by SHEEBA|Need Analysis|
 
