package controller.code.BasicPractice;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void sign1(){
        System.out.println("第一次登录");
    }

    @Test
    public void sign2(){
        System.out.println("第二次登录");
    }

    @Test(enabled=false)  //忽略本条测试
    public void sign3(){
        System.out.println("第三次登录");
    }

    @Test
    public void sign4(){
        System.out.println("第四次登录");
    }
}
