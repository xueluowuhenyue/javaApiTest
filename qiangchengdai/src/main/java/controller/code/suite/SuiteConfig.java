package controller.code.suite;

import org.testng.annotations.BeforeSuite;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件开始运行啦");
    }

    @BeforeSuite
    public void afterSuite(){
        System.out.println("测试套件运行结束啦");
    }
}
