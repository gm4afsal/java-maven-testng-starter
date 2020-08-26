package com.qualityworkscg.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qualityworkscg.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class  AbstractTest {
  
  protected static Page page;
  public WebDriver driver;
  
  @BeforeTest
  @Parameters({"url"})
  public void setup(String url) throws MalformedURLException {

	  System.out.println("Browser: Chrome");
      
      WebDriverManager.chromedriver().setup();
    
      DesiredCapabilities capabilities = new DesiredCapabilities();
      
      ChromeOptions options = new ChromeOptions();
      
      
      options.merge(capabilities);

     // options.addArguments("--headless");
      
      options.addArguments("start-maximized"); 
      options.addArguments("enable-automation"); 
      options.addArguments("--no-sandbox"); 
      options.addArguments("--disable-infobars"); 
      options.addArguments("--disable-dev-shm-usage"); //Linux 
      options.addArguments("--disable-browser-side-navigation"); 
      options.addArguments("--disable-gpu"); //Windows
      
      options.addArguments("--disable-web-security");
      
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
      
    page = new Page(driver);
    page.navigate(url);
  }

  @AfterTest
  public void afterTest() {
    page.tearDown();
  }
}
