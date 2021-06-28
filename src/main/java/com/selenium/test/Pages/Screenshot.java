package com.selenium.test.Pages;

import com.selenium.test.base.BaseProgram;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot extends BaseProgram {

    public void screenshot(String screenshotName) throws IOException {
        Date d = new Date();
        //printing actual date
        String date = d.toString();
        System.out.println(date);

        String date1 = date.replaceAll(":","_");
        System.out.println(date1);

        driver.get("https://www.facebook.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        //create screenshot folder in project directory
        File destFile = new File(".\\screenshot\\"+date1+"\\"+screenshotName+".png");
        FileUtils.copyFile(srcFile,destFile);
    }


}
