package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//find web element using locators.
	WebDriver d;
	
	@FindBy (id = "username")
	WebElement username;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (id = "log-in")
	WebElement loginbtn;


public LoginPage (WebDriver driver)
{
	d = driver;
	PageFactory.initElements(d, this);
}

public void setUserName(String name)
{
	username.clear();
	username.sendKeys(name);
}

public void setPassword(String pass)
{
	password.clear();
	password.sendKeys(pass);
}

public void clickBtn()
{
	loginbtn.click();;
}

}