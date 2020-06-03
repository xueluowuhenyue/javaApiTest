package controller.code.classGroups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "支付")
public class Pay {

    public void pay1(){
        System.out.println("第一次支付");
    }

    public void pay2(){
        System.out.println("第二次支付");
    }

    public void pay3(){
        System.out.println("第三次支付");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("开始执行支付模块测试用例");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("支付模块测试用例执行结束");
    }
}
