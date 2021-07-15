package com.selenium.test;

import windowelementhandle.FileUpload;
import com.selenium.test.pages.Login;
import com.selenium.test.base.BaseProgram;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadTest extends BaseProgram {

    @Test
    public void FileUpload() throws InterruptedException, IOException {
        Login login = new Login(driver);
        login.LoginApplication();

        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.Upload();
    }
}
