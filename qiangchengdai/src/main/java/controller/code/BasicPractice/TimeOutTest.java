package controller.code.BasicPractice;
import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 2000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(timeOut = 1000)
    public void testFiled() throws InterruptedException {
        Thread.sleep(2000);
    }
}
