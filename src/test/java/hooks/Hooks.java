package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import stepDefs.ProjectSpecificMethods;

public class Hooks extends ProjectSpecificMethods{
	
	@Before
	public void startUp()
	{
		System.out.println("Feature file : "+i);
	}
	
	@After
	public void endOfFeature() throws IOException
	{
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/salesforce/Featurefile"+i+".png");
		FileUtils.copyFile(src, desc);
		i++;
	}

	
}
