package windowelementhandle;

import com.selenium.test.base.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FileUpload extends BaseProgram {

    @FindBy(xpath = "//span[contains(text(),'Photo/Video')]")
    WebElement CreatePost;

    public  FileUpload(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void Upload() throws IOException, InterruptedException {
        CreatePost.click();
        Thread.sleep(1000);
        autoIt();
        Thread.sleep(3000);
    }

    public void autoIt() throws IOException {
        Runtime.getRuntime().exec("C:\\Users\\Administrator\\Documents\\FileUpload.exe");
    }
}