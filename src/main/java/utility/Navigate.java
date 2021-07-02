package com.selenium.test.Pages;

import com.selenium.test.base.BaseProgram;

public class Navigate extends BaseProgram {

    public void navigate() throws InterruptedException {
        //Navigate to facebook page
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(1000);

        //Navigate to immediate back page
        driver.navigate().back();
        Thread.sleep(1000);

        //Navigate to immediate forward page
        driver.navigate().forward();
        Thread.sleep(1000);

        //Refresh the current web page
        driver.navigate().refresh();
        Thread.sleep(1000);
    }
}
