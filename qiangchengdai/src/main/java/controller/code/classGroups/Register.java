package controller.code.classGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "注册")
public class Register {
    public void register1(){
        System.out.println("第一次注册");
    }

    public void register2(){
        System.out.println("第二次注册");
    }

    public void register3(){
        System.out.println("第三次注册");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("开始执行注册模块测试用例");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("注册模块测试用例执行结束");
    }
}
