package utility;

import com.selenium.test.base.BaseProgram;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import utility.Listerners.ListenerTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Listeners(ListenerTest.class)
public class Screenshot extends BaseProgram {

    public void screenshot(String screenshotName,String Result) throws IOException {

        Date d = new Date();
        //printing actual date
        String date = d.toString();
        System.out.println(date);

        String date1 = date.replaceAll(":","_");
        System.out.println(date1);

        driver.get("https://www.facebook.com");
        //Typecating driver object to takescreenshot interface
        TakesScreenshot ts = (TakesScreenshot) driver;
        //getting the source file using getScreenShot
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        //create screenshot folder in project directory
        File destFile = new File(".\\screenshot\\"+Result+"\\"+screenshotName+"_"+date1+".png");
        FileUtils.copyFile(srcFile,destFile);
    }
}
