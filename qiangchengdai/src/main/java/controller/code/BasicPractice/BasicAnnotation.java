package controller.code.BasicPractice;
import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void test1(){
        System.out.println("第一条测试用例");
    }

    @Test
    public void test2(){
        System.out.println("第二条测试用例");
    }

    @BeforeMethod
    public void beforeFunction(){
        System.out.println("在方法执行之前执行");
    }

    @AfterMethod
    public void afterFunction(){
        System.out.println("在方法执行之后执行");
    }

    @BeforeClass
    public void beforeCLASS(){
        System.out.println("在类执行之前执行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("在类执行之后执行");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
