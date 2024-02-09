package runner;

import java.io.File;

import java.io.Reader;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@e2e" }, glue = { "stepDefinition" }, features = "./src/test/resources/Features", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:reports/*/report.html" })

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
//		Reader.loadXMLConfig(new File("src/test/resources/Config/report.xml"));
		
		  try {
	            File configFile = new File("src/test/resources/Config/report.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(configFile);    
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		

	}

}
