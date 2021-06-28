package com.selenium.test.Pages;

import com.selenium.test.base.BaseProgram;

public class Navigate extends BaseProgram {

    public void navigate() throws InterruptedException {

        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
    }
}
