package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFunction {

	public CommonFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver driver;
	public String userEmail = "nguyen.phuc.kim.luyen@framgia.com";
	public String userPassword = "Iwtdstfynnl!1";
	
	public void login()
	{		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/a")).click();
		driver.findElement(By.id("user_email")).sendKeys(userEmail);
		driver.findElement(By.id("user_password")).sendKeys(userPassword);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/form/div[4]/button")).click();		
	}
	

	public void logout()
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/nav/div/div/ul[2]/li[5]/a/img")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/nav/div/div/ul[2]/li[5]/div/div[4]/a")).click();
    }

}
