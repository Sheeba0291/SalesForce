package stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateOpportunityWithoutMandatoryFields extends ProjectSpecificMethods{


	@Then ("click Save and Verify Alert Message")
	public void clickSaveAndVerifyAlert()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		List<WebElement> errors = driver.findElements(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a"));

		boolean name = false;
		boolean stage = false;

		for (WebElement eachError : errors) {
			String text = eachError.getText();
			if(text.equals("Opportunity Name"))
				name = true;
			else if(text.equals("Stage"))
				stage = true;
		}

		if (name&&stage)
			System.out.println("Alert message is verified");
		else
			System.out.println("Alert message is NOT verified");

	}

}
