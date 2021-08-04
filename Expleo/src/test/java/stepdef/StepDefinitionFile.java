package stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import WebDriver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.DOMchallenge;



public class StepDefinitionFile {
	private DriverManager driverManager;
	private DOMchallenge domchallenge;
	private Properties prop;
	private static final int WAIT_TIME = 7;
	String url_del;
	String url_edit;
	String url;
	String title2;

	@Before
	public void init() {
		driverManager = new DriverManager();
		prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverManager.launchDriver(prop.getProperty("Browser"));
		domchallenge = new DOMchallenge(driverManager.getDriver());
	}
	
	@After
	public void tearDown() {
		if(driverManager.getDriver()!=null) {
			driverManager.getDriver().quit();
		}
	}
	
	@Given("^Challenging DOM URL is available$")
	public void launchAPP() {
		driverManager.browseApp(prop.getProperty("AppURL"));
		driverManager.getDriver().getTitle();
	}
	
	@When("^I click the links and buttons on the web page$")
	public void enterMyData() {
		// Verify page has been loaded
		url = driverManager.getDriver().getCurrentUrl();
		System.out.println("Current Page is: " +url);
	}
	
	@Then("^Respective actions will take place$")
	public void results() {

		// Click on Delete button and Verify the URL
		driverManager.clickOnElement(driverManager.waitUntilVisible(domchallenge.delett, WAIT_TIME));
		driverManager.hardWait(1000);
		url_del = driverManager.getDriver().getCurrentUrl();
		System.out.println(url_del);
		Assert.assertEquals(true,url_del.contains("delete"));

		// Click on edit button and Verify the URL
		driverManager.clickOnElement(driverManager.waitUntilVisible(domchallenge.editt, WAIT_TIME));
		driverManager.hardWait(1000);
		url_edit = driverManager.getDriver().getCurrentUrl();
		System.out.println(url_edit);
		Assert.assertEquals(true,url_edit.contains("edit"));


		// Size of the table
		List<WebElement> cols = driverManager.getDriver().findElements(By.xpath("//thead/tr[1]/th"));
		int num_cols = cols.size();
		List<WebElement> rows = driverManager.getDriver().findElements(By.xpath("//tbody/tr"));
		int num_rows = rows.size();

		System.out.println("number of columns is: " +num_cols);
		System.out.println("number of columns is: " +num_rows);
		Assert.assertEquals(7,num_cols);
		Assert.assertEquals(10,num_rows);

		// Verify Header Title
		String Title = driverManager.getText(domchallenge.header);
		System.out.println("The Header Title is: " +Title);
		Assert.assertEquals(true,Title.contains("Challenging DOM"));


		// Verify the Header Paragraph
		String Para = driverManager.getText(domchallenge.paragraph);
		System.out.println("The Header Para is: " +Para);
		Assert.assertEquals(true,Para.contains("The hardest part in"));


		// Verify Table Header
		String Col_name = driverManager.getText(domchallenge.Sit_column);
		System.out.println("Column name is: " +Col_name);
		Assert.assertEquals(true,Col_name.contains("Sit"));

		// Verify Table Data
		String Col_data = driverManager.getText(domchallenge.luvaret2_data);
		System.out.println("Column data is: " +Col_data);
		Assert.assertEquals(true,Col_data.contains("Iuvaret2"));

		// Verify the number of buttons
		int no_buttons = driverManager.getDriver().findElements(By.xpath("//div[@class='large-2 columns']/a")).size();
		System.out.println("Button count is: " +no_buttons);
		Assert.assertEquals(3,no_buttons);

		// Click on the buttons
		driverManager.hardWait(2000);
		driverManager.getDriver().findElement(By.xpath("//div[@class='large-2 columns']/a[1]")).click();

		// Click on the link at the bottom of the page
		driverManager.hardWait(1000);
		driverManager.clickOnElement(domchallenge.bottomlink);
		driverManager.hardWait(1000);

		System.out.println("\n\n Test Completed \n\n\t");
	}
}
