package stepDefs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests{

	public static ChromeDriver driver;
	public int i=1;

	@BeforeMethod
	public void setUp() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void tearDown() throws IOException
	{
	/*	// Capture Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/salesforce/CreateAccounts.png");
		FileUtils.copyFile(src, desc);

		System.out.println("Screenshot captured."); */
		driver.close();
	} 
}
