package com.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BrowserTest;

public class ParameterBase {
    public static WebDriver driver;

    @Parameters({"browserName"})
    @Test
    public void setUp(String browserName) throws InterruptedException {
        //Launch the chrome browser
        driver = BrowserTest.selectDriver(browserName);
        //Manage the window
        driver.manage().window().maximize();
        //Enter the url
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);

    }

    @AfterMethod
    public void tearDown(){
        //close the browser
        driver.close();
    }
}
