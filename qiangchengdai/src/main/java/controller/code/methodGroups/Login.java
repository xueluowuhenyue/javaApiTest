package controller.code.methodGroups;

import org.testng.annotations.Test;

public class Login {

    @Test(groups = "分组一")
    public void sign1(){
        System.out.println("第一次登录");
    }

    @Test(groups = "分组一")
    public void sign2(){
        System.out.println("第二次登录");
    }

    @Test(groups = "分组二")
    public void sign3(){
        System.out.println("第三次登录");
    }

    @Test(groups = "分组二")
    public void sign4(){
        System.out.println("第四次登录");
    }
}
