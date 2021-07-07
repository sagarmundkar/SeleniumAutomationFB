package com.selenium.test.Pages;

import com.selenium.test.base.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Registration extends BaseProgram {

    Logger logger = LogManager.getLogger(Registration.class);

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")
    WebElement createaccount;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement LastName;

    @FindBy(xpath = "//input[@name='reg_email__']")
    WebElement Email;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    WebElement ReEnterEmail;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    WebElement Password;

    @FindBy(xpath ="//select[@name='birthday_day']")
    WebElement Day;

    @FindBy(xpath ="//select[@name='birthday_month']")
    WebElement Month;

    @FindBy(xpath ="//select[@id='year']")
   WebElement Year;

    @FindBy(xpath = "//input[@type='radio' and @value='1']")
    WebElement Gender;

    @FindBy(name = "websubmit")
    WebElement SignUp;

    public Registration(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void registration() throws InterruptedException, AWTException {

        Thread.sleep(2000);
        logger.info("Create A New Account");
        createaccount.click();
        Thread.sleep(2000);

        Robot r = new Robot();

        //Using Robot class create the mouse event and Keyboard event
        r.mouseMove(201 ,204);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        logger.info("Enter first name");
        FirstName.sendKeys("Sagar");
        Thread.sleep(1000);

        // press Key TAB
        r.keyPress(KeyEvent.VK_TAB);
        // Release Key TAB
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        logger.info("Enter last name");
        LastName.sendKeys("Mundkar");
        Thread.sleep(1000);

        // press Key TAB
        r.keyPress(KeyEvent.VK_TAB);
        //release Key Tab
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        logger.info("Enter email");
        Email.sendKeys("*****@gmail.com");
        Thread.sleep(1000);

        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        //Entering Reconformation email
        logger.info("Enter Reconfirmation email");
        ReEnterEmail.sendKeys("*****@gmail.com");
        Thread.sleep(1000);

        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        logger.info("Enter password");
        Password.sendKeys("1234@13");
        Thread.sleep(1000);

        logger.info("Select Day");
        Select daydropdown = new Select(Day);
        daydropdown.selectByVisibleText("12");
        Thread.sleep(1000);

        logger.info("Select month");
        Select monthdropdown = new Select(Month);
        monthdropdown.selectByValue("5");
        Thread.sleep(1000);

        logger.info("Select year");
        Select yeardropdown = new Select(Year);
        yeardropdown.selectByValue("1993");
        Thread.sleep(1000);

        logger.debug("Click on gender");
        Gender.click();
        Thread.sleep(1000);

        logger.debug("Click on signup");
        SignUp.click();
        Thread.sleep(1000);

        String actualurl = "https://www.facebook.com/";
        String expectedurl = driver.getCurrentUrl();
        //Assert.assertEquals(expectedurl,actualurl);
        if (actualurl.contains(expectedurl)) {
            System.out.println("Registration Page is Displayed!");
        }
        else {
            System.out.println("Registration Page is not Displayed!");
        }



    }

}
