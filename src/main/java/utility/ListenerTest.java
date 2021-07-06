package utility.Listerners;

import com.selenium.test.base.BaseProgram;
import org.testng.ITestResult;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import utility.Screenshot;

import java.io.IOException;

public class ListenerTest extends BaseProgram implements ITestListener
{
    Screenshot screenshot = new Screenshot();
    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        System.out.println("The name of the testcase failed is :"+Result.getName());
        try {
            screenshot.screenshot(Result.getName(), "failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
        try {
            screenshot.screenshot(Result.getName(),"Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}