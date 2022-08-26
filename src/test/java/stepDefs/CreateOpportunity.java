package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateOpportunity extends ProjectSpecificMethods{
	
	String opportunityName = "";
	
	@And ("Click on Opportunity tab")
	public void clickOpportunityTab()
	{
		WebElement opportunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunityTab);
	}
	
	@And ("Enter Opportunity name as (.*)$")
	public void enterOpportunityName(String name)
	{
		opportunityName = name;
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]")).sendKeys(opportunityName);
	}
	
	@And ("Choose close date as Today")
	public void chooseDayAsToday()
	{
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();

	}
	@And ("Select Stage as (.*)$")
	public void selectStage(String stage)
	{
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

	}
	
	@Then ("click Save and VerifyOppurtunity Name")
	public void clickSaveAndVerifyOpportunity()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		String opportunityNameCaptured = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();

		Assert.assertEquals(opportunityNameCaptured, opportunityName);
	/*	if(opportunityNameCaptured.equals(opportunityName))
		{
			System.out.println("Opportunity Name Verified");
		}
		else
		{
			System.out.println("Opportunity Name MIS-MATCH");
		} */

	}

}
