package com.qualityworkscg.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qualityworkscg.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class  AbstractTest {
  
  protected static Page page;
  
  @BeforeTest
  @Parameters({"url"})
  public void setup(String url) {

	  System.out.println("Browser: Chrome");
      
      WebDriverManager.chromedriver().setup();
    
      DesiredCapabilities capabilities = new DesiredCapabilities();
      
      ChromeOptions options = new ChromeOptions();
      
      
      options.merge(capabilities);

      options.addArguments("--headless");
      
      options.addArguments("start-maximized"); 
      options.addArguments("enable-automation"); 
      options.addArguments("--no-sandbox"); 
      options.addArguments("--disable-infobars"); 
      options.addArguments("--disable-dev-shm-usage"); //Linux 
      options.addArguments("--disable-browser-side-navigation"); 
      options.addArguments("--disable-gpu"); //Windows
      
      options.addArguments("--disable-web-security");
      
       
      
    page = new Page(new ChromeDriver(options));
    page.navigate(url);
  }

  @AfterTest
  public void afterTest() {
    page.tearDown();
  }
}
