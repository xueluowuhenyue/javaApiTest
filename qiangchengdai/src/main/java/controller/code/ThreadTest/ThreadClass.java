package controller.code.ThreadTest;
import org.testng.annotations.Test;

public class ThreadClass {

    @Test(invocationCount = 3,threadPoolSize =1)
    public void test1(){
        System.out.println("线程Id是："+Thread.currentThread().getId());
    }
}
