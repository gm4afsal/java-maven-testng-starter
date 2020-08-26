package com.qualityworkscg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Page {
  
  protected WebDriver driver;
  
  public Page(WebDriver driver2) {
    this.driver = driver2;
  }

  public void navigate(String url) {
    driver.navigate().to(url);
  }
  
  public String getTitle() {
    return driver.getTitle();
  }

  public void tearDown() {
    try {
      this.driver.quit();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
}
