package controller.code.CreateReport;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases {

    @Test
    public void case1(){
        Assert.assertEquals(1,3-2);
    }

    @Test
    public void case2(){
        Assert.assertEquals("abc","a"+"b"+"c");
    }

    @Test(timeOut = 1000)
    public void case3() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(timeOut = 1000)
    public void case4(){
        Assert.assertEquals(1,Thread.currentThread().getId());
    }

}
