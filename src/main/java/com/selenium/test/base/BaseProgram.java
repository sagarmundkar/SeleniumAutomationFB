package com.selenium.test.base;

import com.selenium.test.Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseProgram {
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        Logger logger = LogManager.getLogger(BaseProgram.class);

        WebDriverManager.chromedriver().setup();
        //Launch the chrome browser
        logger.debug("Launch chrome browser");
        driver = new ChromeDriver();
        //Manage the window
        logger.debug("Manage Window");
        driver.manage().window().maximize();
        //Enter the url
        logger.debug("Opening Website");
        driver.get("https://www.facebook.com/");

    }

    @AfterTest
    public void tearDown(){
        //close the browser
        driver.close();
        //quit the browser
        driver.quit();
    }
}
