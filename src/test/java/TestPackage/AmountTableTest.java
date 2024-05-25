package TestPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmountTableTest 
{

	WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException
	{ 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("abcd");
		driver.findElement(By.id("password")).sendKeys("abcd");

		driver.findElement(By.id("log-in")).click();

		Thread.sleep(3000);
	}

	@Test

	public void AmountDataTest() throws InterruptedException
	{
		boolean c = true;
		while(c==true)
		{		
			List <WebElement> rowlist = driver.findElements(By.xpath("//table/tbody/tr"));
			int row_size = rowlist.size();

			double data[] = new double[row_size];

			for (int i=1; i<=rowlist.size(); i++)
			{
				String txt = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();	


				String clr_txt = txt.replaceAll("[^0-9.+-]", "");

				double db = Double.parseDouble(clr_txt);

				data[i-1] = db;
			}
			boolean c1=true;
			f1: for (int i=0; i<data.length;i++)
			{
				f2: for (int j=i+1; j<data.length; j++)
				{
					if (data[i] < data[j])
					{
						c1=false;
					}
					else
					{
						driver.findElement(By.xpath("//th[@id='amount']")).click();
						Thread.sleep(3000);
						c1 = true;
						break f1;
					}

				}
			}

			c=c1;

		}

	}

	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
	}

}
