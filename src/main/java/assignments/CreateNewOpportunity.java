package assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity {
	/*
	 * TestSteps:
	 *
	 * 1. Login to https://login.salesforce.com 
	 * 2. Click on toggle menu button from the left corner 
	 * 3. Click view All and click Sales from App Launcher
	 * 4. Click on Opportunity tab 
	 * 5. Click on New button 
	 * 6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and
	 * Store it
	 * 7. Choose close date as Today 
	 * 8. Select 'Stage' as Need Analysis
	 * 9. click Save and VerifyOppurtunity Name"
	 */


	/*
	 * 
	 * Refer Step Video:
     https://drive.google.com/file/d/1F-jMT0X-u-mx3ZM4ZyhFrFfOl9Dj06Ii/view?usp=sharing"
	 */

	public static void main(String[] args) throws IOException {
		// Setup WebDriverManager and initialize driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize(); 
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// 4. Click on Opportunity tab
		WebElement opportunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		//bcos it is a JS script, used JavaScript Executor click
		driver.executeScript("arguments[0].click();", opportunityTab);

		// 5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();

		// 6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,
		// Get the text and Store it
		String opportunityName = "Salesforce Automation by SHEEBA";
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]")).sendKeys(opportunityName);

		// 7. Choose close date as Today
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();

		// 8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

		// 9. click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		String opportunityNameCaptured = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
		
		System.out.println(opportunityNameCaptured);

		if(opportunityNameCaptured.equals(opportunityName))
		{
			System.out.println("Opportunity Name Verified");
		}
		else
		{
			System.out.println("Opportunity Name MIS-MATCH");
		}

		// Capture Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/salesforce/CreateOpportunity.png");
		FileUtils.copyFile(src, desc);

		System.out.println("Screenshot captured.");
	}

}
