package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DOMchallenge {
	
	@FindBy(xpath = "//div[@class='large-2 columns']/a")
	public WebElement buttons;

	@FindBy(xpath = "//div[@class='large-2 columns']/a[1]")
	public WebElement button1;

	@FindBy(xpath = "//canvas[@id='canvas']")
	public WebElement canvas;
	
	@FindBy(xpath = "//a[contains(text(),'Elemental Selenium')]")
	public WebElement bottomlink;
	
	@FindBy(xpath = "//h3[contains(text(),'Challenging DOM')]")
	public WebElement header;
	
	@FindBy(xpath = "//p[contains(text(),'The hardest part in automated web testing is find')]")
	public WebElement paragraph;
	
	@FindBy(xpath = "//thead/tr/th[4]")
	public WebElement Sit_column;
	
	@FindBy(xpath = "//tbody/tr[3]/td[1]")
	public WebElement luvaret2_data;
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]")
	public WebElement editt;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[2]")
	public WebElement delett;
	
	public DOMchallenge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
