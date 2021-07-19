package com.selenium.test.Pages;
import com.selenium.test.base.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Login extends BaseProgram {
    //Create Logger instance
    Logger logger = LogManager.getLogger(Login.class);

    //Login to the Facebook page using valid email
    @FindBy(name = "email")
    WebElement email;

    //Login to the Facebook page using valid password
    @FindBy(name = "pass")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbutton;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void LoginApplication() throws InterruptedException {
        logger.info("Entering the Email");
        email.sendKeys("shreemundkar@gmail.com");
        logger.info("Entering the Password");
        password.sendKeys("SagarMundkar@1234");
        logger.info("Click on button");
        loginbutton.click();
        logger.debug("Wait for some time");
        Thread.sleep(100);

        String actualurl = "https://www.facebook.com/";
        String expectedurl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);

    }
}



