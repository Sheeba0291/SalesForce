package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefs.ProjectSpecificMethods;

@CucumberOptions(features = "src\\test\\java\\features",
					glue = {"stepDefs", "hooks"},
					tags = "@smoke",
					monochrome = true,
					publish = true)

public class RunCucumberTest extends ProjectSpecificMethods{



}
