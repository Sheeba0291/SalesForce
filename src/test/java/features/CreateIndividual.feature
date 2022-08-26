Feature: Create Individual under SalesForce Application

Background: Positive Login
Given Login to SalesForce Application
|userName|password|
|hari.radhakrishnan@qeagle.com|India$321|
And Click on toggle menu button from the left corner
And Click view All

@smoke
Scenario Outline: Create an Individual
Given click Individuals from App Launcher
And Click on the Dropdown icon in the Individuals tab
And Click on New Individual 
And Enter the Last Name as <lastName>
Then Click save and verify Individuals Name

Examples:
|lastName|
|Murugan|
|Karthik|