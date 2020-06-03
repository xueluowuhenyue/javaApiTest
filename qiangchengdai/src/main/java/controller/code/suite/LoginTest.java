package controller.code.suite;

import org.testng.annotations.*;

public class LoginTest {

    @Test
    public void loginTest1(){
        System.out.println("第一个用户登录成功");
    }

    @Test
    public void loginTest2(){
        System.out.println("第二个用户登录成功");
    }

    @Test
    public void loginTest3(){
        System.out.println("第三个用户登录成功");
    }

    @BeforeClass
    public void beforeLogin(){
        System.out.println("开始执行登录测试");
    }

    @AfterClass
    public void afterLogin(){
        System.out.println("登录测试执行结束");
    }
}
