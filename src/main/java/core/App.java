package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App {
	static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     // if (driver.findElements(by).size() == 1) return true;
	     if (!driver.findElements(by).isEmpty()) return true; else return false;}


	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.OFF);
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
		driver.get("file:///Users/grygoriyzhurylo/Desktop/QA/Workspace/LAB_24/input.html");

		long bm_start = System.currentTimeMillis();
	
		if	(isElementPresent(By.id("id_fname"))) {
			driver.findElements(By.id("id_fname")).get(0).sendKeys("Grygoriy");
		} else {
			System.out.print("is element is not present");
		}
		
		long bm_finish = System.currentTimeMillis();
		
		System.out.println("Response time: " + (bm_finish - bm_start) + " ms");
		System.out.println(driver.findElements(By.id("id_fname")).size() == 1);
		driver.findElements(By.id("id_fname")).get(0).sendKeys("Grygoriy");
		System.out.print("...Script is still running");
		

		driver.quit();
	}
}