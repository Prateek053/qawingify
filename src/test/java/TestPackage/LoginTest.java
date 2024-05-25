package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.LoginPage;

public class LoginTest {

	public String baseUrl = "https://sakshingp.github.io/assignment/login.html";
	public WebDriver driver;

	@BeforeTest
	public void setup()
	{
		System.out.println("Before test is executed");

		driver = new ChromeDriver();

		driver.get(baseUrl);
		driver.manage().window().maximize();

		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10,0));
	}


	@Test(priority = 1)
	public void loginwithoutdata() throws InterruptedException
	{				
		LoginPage lg = new LoginPage(driver);

		//click on the login button
		lg.clickBtn();
		Thread.sleep(3000);

		String act_error = "Both Username and Password must be present"+" ";

		String error_msg = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();

		Assert.assertEquals(act_error.trim(), error_msg.trim());


	}
	
	
	@Test(priority = 2)
	public void loginwithspacechar() throws InterruptedException
	{

		LoginPage lg = new LoginPage(driver);

		//enter username
		lg.setUserName(" ");

		//enter password
		lg.setPassword(" ");

		//click on the login button
		lg.clickBtn();
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void loginwithoutusername() throws InterruptedException
	{
		LoginPage lg = new LoginPage(driver);

		//enter username
		lg.setUserName("");

		//enter password
		lg.setPassword(" ");

		//click on the login button
		lg.clickBtn();
		Thread.sleep(3000);

		String act_error = "Username must be present";

		String error_msg = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();

		Assert.assertEquals(act_error.trim(), error_msg.trim());
	}

	@Test(priority = 4)
	public void loginwithoutpassword() throws InterruptedException
	{
		LoginPage lg = new LoginPage(driver);

		//enter username
		lg.setUserName(" ");

		//enter password
		lg.setPassword("");

		//click on the login button
		lg.clickBtn();
		Thread.sleep(3000);

		String act_error = "Password must be present";

		String error_msg = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();

		Assert.assertEquals(act_error.trim(), error_msg.trim());
	}


	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
}
