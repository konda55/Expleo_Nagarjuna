package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

	private WebDriver driver;

	public void launchDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void browseApp(String url) {
		driver.get(url);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void hardWait(int millisecs) {
		try {
			Thread.sleep(millisecs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement waitUntilVisible(WebElement element, int seconds) {
		return new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
	}
}
