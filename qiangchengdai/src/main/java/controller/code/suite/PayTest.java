package controller.code.suite;

import org.testng.annotations.*;

public class PayTest {

    @Test
    public void output1(){
        System.out.println("第一次支付成功");
    }

    @Test
    public void output2(){
        System.out.println("第二次支付成功");
    }

    @Test(enabled = false) //忽略本条测试用例
    public void output3(){
        System.out.println("第三次支付成功");
    }

    @BeforeClass
    public void beforePay(){
        System.out.println("开始执行支付测试");
    }

    @AfterClass
    public void afterPay(){
        System.out.println("支付测试测试执行结束");
    }
}
