package controller.code.classGroups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "登录")
public class Login {

    public void sign1(){
        System.out.println("第一次登录");
    }

    public void sign2(){
        System.out.println("第二次登录");
    }

    public void sign3(){
        System.out.println("第三次登录");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("开始执行登录模块测试用例");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("登录模块测试用例执行结束");
    }
}
