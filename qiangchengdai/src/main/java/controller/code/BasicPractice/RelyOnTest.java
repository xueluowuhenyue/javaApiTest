package controller.code.BasicPractice;

import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class RelyOnTest {

    @Test(expectedExceptions = TimeoutException.class)
    public void register(){
        System.out.println("注册成功");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = "register")
    public void login(){
        System.out.println("登录成功");
    }
}
