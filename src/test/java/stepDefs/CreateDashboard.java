package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateDashboard extends ProjectSpecificMethods{

	String dashboardName = "";

	@Given ("Click Dashboards from App Launcher")
	public void clickDashboardLink()
	{
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboards);
	}

	@And ("Click on the New Dashboard option")
	public void clickNewDashboardButton()
	{
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	}

	@And ("Enter Name as (.*)$")
	public void enterDashboardName(String name)
	{
		dashboardName = name;
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("(//input[@class='slds-input'])[1]")).sendKeys(dashboardName);
	}

	@Then ("Click on Create and Verify Dashboard name")
	public void clickCreateAndVerifyDashboardName() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Create']")).click();

		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		// System.out.println(title);

		if(title.contains(dashboardName))
		{
			System.out.println("Dashboard Name Verified");
		}
		else
		{
			System.out.println("Dashboard Name MIS-MATCH");
		}
	}



}
