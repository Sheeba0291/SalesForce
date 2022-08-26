package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewDashboard {
	/*
	 *  Test Steps: 
	 *  1. Login to https://login.salesforce.com 
	 *  2.Click on the toggle menu button from the left corner 
	 *  3. Click View All and click Dashboards from App Launcher
	 *  4. Click on the New Dashboard option 
	 *  5.Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
	 * 6.Click on Save and Verify Dashboard name."
	 * 
	 * Refer Step Video:
	 * https://drive.google.com/file/d/1mlZPIYFk53kNnlvcx4cHkhc4IoxXLIhq/view?usp=
	 * sharing"
	 */
	public static void main (String args[]) throws InterruptedException
	{
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

		// 3. Click view All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboards);

		// 4. Click on the New Dashboard option
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		// 5. Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
		String dashboardName = "Automation by Rajee";
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("(//input[@class='slds-input'])[1]")).sendKeys(dashboardName);
		
		// 6. Click on Create and Verify Dashboard name.
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		//WebElement findElement = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-has-divider_bottom']/span)[2]"));
		// driver.switchTo().defaultContent();
		String title = driver.getTitle();
		
		System.out.println(title);
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
