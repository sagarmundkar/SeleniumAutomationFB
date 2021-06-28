package com.selenium.test.Pages;
import com.selenium.test.base.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Login extends BaseProgram{

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbutton;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void LoginApplication() throws InterruptedException {
        email.sendKeys("******@gmail.com");
        password.sendKeys("*********");
        loginbutton.click();
        Thread.sleep(1000);

        String actualurl = "https://www.facebook.com/";
        String expectedurl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);
    }
}



