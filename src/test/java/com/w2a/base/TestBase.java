package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException {
		if(driver == null) {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			    driver= new InternetExplorerDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
		}
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		if(driver != null)
			driver.quit();
	}

}
