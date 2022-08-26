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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {
	/*
	 *  Test Steps:
	 *  1. Login to https://login.salesforce.com 
	 *  2. Click on toggle menu button from the left corner
	 *  3. Click view All and click Sales from App Launcher
	 *  4. Click on Accounts tab 
	 *  5. Click on New button 
	 *  6. Enter 'your name' as account name 
	 *  7. Select Ownership as Public
	 *  8. Click save and verify Account name "
	 * 
	 * 
	 * Refer Step Video:
	 * https://drive.google.com/file/d/1XuOUyaqiqbNOlLelFAeRfR7VSZOpZk23/view?usp=
	 * sharing"
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException, IOException {
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
		
		// 4. Click on Accounts tab
		WebElement accountsTab = driver.findElement(By.xpath("//span[text()='Accounts']"));
		//bcos it is a JS script, used JavaScript Executor click
		driver.executeScript("arguments[0].click();", accountsTab);
		
		// 5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		// 6. Enter 'your name' as account name
		String name = "Sheeba Murugan";
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(name);
		
		// 7. Select Ownership as Public 
		WebElement ownerShip = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));

		// Used JS executor bcos was getting ElementClickIntercepted Exception
		driver.executeScript("arguments[0].click();", ownerShip);
		driver.findElement(By.xpath("(//span[text()='Public'])[1]")).click();
		
		// 8. Click save and verify Account name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String accountNameCaptured = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		if(accountNameCaptured.equals(name))
		{
			System.out.println("Account Name Verified");
		}
		else
		{
			System.out.println("Account Name MIS-MATCH");
		}
		
		// Capture Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/salesforce/CreateAccounts.png");
		FileUtils.copyFile(src, desc);
		
		System.out.println("Screenshot captured.");
		
		
	}
}
