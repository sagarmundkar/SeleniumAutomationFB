package com.selenium.test;

import com.selenium.test.base.BaseProgram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ReadExcelFile;

public class DataDrivenLogin extends BaseProgram {

    //Login to the Facebook page using valid email
    @FindBy(name = "email")
    WebElement email;

    //Login to the Facebook page using valid password
    @FindBy(name = "pass")
    WebElement password;

    //Submit valid details
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbutton;

    public DataDrivenLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Test(dataProvider = "LoginDetails")
    public void Login(String Username, String Password) throws InterruptedException {
        email.sendKeys(Username);
        password.sendKeys(Password);
        loginbutton.click();
        Thread.sleep(1000);
        String actualurl = "https://www.facebook.com/";
        String expectedurl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);

    }
    @Test
    public void Logout() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/div[1]/div[1]/i[1]")).click();
        Thread.sleep(1000);
    }


    @DataProvider(name = "LoginDetails")
    public Object[][] getData(){
        String sheetPath = "C:\\Users\\Administrator\\IdeaProjects\\FacebookLogin\\TestData\\sheet.xlsx";

        Object data[][] = testData(sheetPath,"Credentials");
        return data;
    }


    public Object[][] testData(String sheetPath,String sheetName){

        //String projectPath = System.getProperty("user.dir");
        ReadExcelFile excel = new ReadExcelFile(sheetPath,sheetName);
        int rowCount = ReadExcelFile.getRowCount();
        int colCount = ReadExcelFile.getColCount();


        //creating 2 dimentional object array
        Object data[][] = new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                String cellData = ReadExcelFile.getCellData(i,j);
                //String getCellNumber = null;
                //System.out.println(cellData+"|" );
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;

    }

}

