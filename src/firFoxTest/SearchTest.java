package firFoxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	

	
	@Test
	public  void validateSearch() {
		//setup Chromedriver
		WebDriverManager.chromedriver().setup();
		//create a webdriver object
		WebDriver driver = new ChromeDriver();
		
		//open the search 
		driver.get("https://www.google.com");
		//maximize the window
		driver.manage().window().maximize();
		//type in search box
		driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
		//trigger the search
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//caputre the webelement
		WebElement firstLink = driver.findElement(By.xpath("//*[@id=\"sports-app\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]"));
		String actualText = firstLink.getText();
		String expected = "FIFA World Cup Qatar 2022™";
		//addding assertion to the test
		Assert.assertTrue(actualText.equalsIgnoreCase(expected),
				"Expected " +expected+" but found >>"+ actualText);
		
		
		
		
		
		

	}

}
