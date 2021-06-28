package com.selenium.test;
import com.selenium.test.Pages.*;
import com.selenium.test.base.BaseProgram;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Demo extends BaseProgram {
    @Test
    public void registration() throws InterruptedException, AWTException {
        Registration registration = new Registration(driver);
        registration.registration();
    }


    @Test
    public void logininfo() throws InterruptedException {
        Login login = new Login(driver);
        login.LoginApplication();
    }

   @Test
    public void navigateinfo() throws InterruptedException {
        Navigate navigate = new Navigate();
        navigate.navigate();
    }

   /* @Test
    public void logoutInfo(){
        Logout logout =new Logout();
        logout.logout();
    }*/

    @Test
    public void screenshotInfo() throws IOException {
        Screenshot screenshot = new Screenshot();
        screenshot.screenshot("facebook_browser");
    }

   /* @Test
    public void postpage() throws InterruptedException {
        PostPage postPage = new PostPage(driver);
        postPage.Post_to_page();
    }*/


}

