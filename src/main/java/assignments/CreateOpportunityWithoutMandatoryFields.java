package assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunityWithoutMandatoryFields {
	/*
	 * 
	 * 
	 * Test Steps: 
	 * 1. Login to https://login.salesforce.com 
	 * 2. Click on toggle menu button from the left corner 
	 * 3. Click view All and click Sales from App Launcher
	 * 4. Click on Opportunity tab 
	 * 5. Click on New button 
	 * 6. Choose Close date as Tomorrow Date
	 * 7. Click on save 
	 * 8. Verify the Alert message (Completethis field) displayed for Name and Stage"
	 * 
	 * 
	 * 
	 * Refer Step Video:
	 * https://drive.google.com/file/d/1wHnOAbyBfjU5zIb1AY62nsefNucxMK4t/view?usp=
	 * sharing"
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// Setup WebDriverManager and initialize driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize(); 
		
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		

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

		// 7. Choose close date as Tomorrow Date
	/*	driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		Thread.sleep(2000);
		WebElement tomorrow = driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(tomorrow));
		driver.executeScript("arguments[0].click();", tomorrow); */
		
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//	wait.until
		// localdate + 1 day
		
		// 7. click Save 
		Thread.sleep(4000);
		
		WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", save);
		
		 // 8. Verify the Alert message (Completethis field) displayed for Name and Stage"

		List<WebElement> errors = driver.findElements(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a"));
	System.out.println(errors.size());
	for (int i = 0; i < errors.size(); i++) {
		String text = errors.get(i).getText();
		System.out.println(text);
	}
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
		
//		// Capture Screenshot
//		File src = driver.getScreenshotAs(OutputType.FILE);
//		File desc = new File("./snaps/salesforce/opportunitywoFields.png");
//		FileUtils.copyFile(src, desc);
//
//		System.out.println("Screenshot captured.");
	}
}
