package WSM_LOGOUT;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import util.CommonFunction;
import util.VariableSettings;

@Test
public class wsmLogout extends CommonFunction {

	// public WebDriver driver;
	public String expected = null;
	public String actual = null;
	

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.setProperty(VariableSettings.LIB_GECKO,VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		login();
		Thread.sleep(10000);
		logout();
	}

	@Test(priority = 0)
	public void TC01_MessageLogout() {
		WebElement message = driver.findElement(By.id("flash-message"));
		actual = message.getText();
		expected = "Signed out successfully.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void TC02_LoginScreen() {
		// Thread.sleep(3000);
		expected = "Framgia Vietnam WSM portal and application";
		actual = driver.findElement(By.className("wsm-slogan")).getText();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void TC03_ErrorMessage() throws InterruptedException {
		driver.get("https://wsm.framgia.vn/en/dashboard/user_settings/edit");
		// Thread.sleep(10000);
		WebElement message = driver.findElement(By.id("flash-message"));
		actual = message.getText();
		expected = "You need to sign in or sign up before continuing.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void TC04_LogoutAtAnyPage() throws InterruptedException {
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		login();
		Thread.sleep(10000);
		driver.get("https://wsm.framgia.vn/en/dashboard/user_settings/edit");
		Thread.sleep(5000);
		logout();
		TC01_MessageLogout();
		TC02_LoginScreen();
	}

	@Test(priority = 4)
	public void TC05_NavigateAfterLogout()
	{
		driver.navigate().back();
		expected = "https://wsm.framgia.vn/en";
		actual = driver.getCurrentUrl().toString();
     	Assert.assertEquals(actual, expected);
		}

}
