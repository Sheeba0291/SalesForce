package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateIndividual extends ProjectSpecificMethods{
	
	String lastName = "";
	
	@Given ("click Individuals from App Launcher")
	public void clickIndividuals()
	{
		WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));

		// used JS executor scroll into view bcos it was not scrolling the page and throeing ClickIntercepted Exception.
		driver.executeScript("arguments[0].scrollIntoView();", individuals);

		individuals.click();
	}
	
	@And ("Click on the Dropdown icon in the Individuals tab")
	public void clickDropdown()
	{
		
	}
	
	@And ("Click on New Individual")
	public void clickNewIndividual()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@And ("Enter the Last Name as (.*)$")
	public void enterLastName(String name)
	{
		lastName = name;
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
	}
	@Then ("Click save and verify Individuals Name")
	public void clickSaveAndVerifyIndividual()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String lastNameCaptured = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
		Assert.assertEquals(lastNameCaptured, lastName);
		
	/*	if(lastNameCaptured.equals(lastName))
		{
			System.out.println("Individual Name Verified");
		}
		else
		{
			System.out.println("Individual Name MIS-MATCH");
		} */
	}
	
}
