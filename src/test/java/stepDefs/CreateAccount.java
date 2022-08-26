package stepDefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccount extends ProjectSpecificMethods{
	
	String accountName;

	@Given ("Login to SalesForce Application")
	public void login(DataTable data)
	{
		List<List<String>> asList = data.asLists();
		driver.manage().window().maximize(); 
		driver.findElement(By.id("username")).sendKeys(asList.get(1).get(0));
		driver.findElement(By.id("password")).sendKeys(asList.get(1).get(1));
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And ("Click on toggle menu button from the left corner")
	public void toggleMenu()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@And ("Click view All")
	public void clickViewAll()
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();	
	}

	@Given ("Click Sales from App Launcher")
	public void clickSales()
	{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}

	@And ("Click on Accounts tab")
	public void clickAccountsTab()
	{
		WebElement accountsTab = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accountsTab);
	}

	@And ("Click on New button")
	public void clickNewButton()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}

	@And ("Enter account name as (.*)$")
	public void enterYourName(String name)
	{
		accountName = name;
		// String name = "Sheeba Murugan";
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(accountName);
	}
	
	@And ("Select Ownership as Public")
	public void selectOwnership()
	{
		WebElement ownerShip = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].click();", ownerShip);
		driver.findElement(By.xpath("(//span[text()='Public'])[1]")).click();
	}
	
	@Then ("Click save and verify Account name")
	public void clickSaveAndVerifyAccountName()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String accountNameCaptured = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		Assert.assertEquals(accountNameCaptured, accountName);
/*		if(accountNameCaptured.equals(accountName))
		{
			System.out.println("Account Name Verified");
		}
		else
		{
			System.out.println("Account Name MIS-MATCH");
		} */
	}

}
