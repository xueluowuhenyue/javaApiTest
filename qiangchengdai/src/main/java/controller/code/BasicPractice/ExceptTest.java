package controller.code.BasicPractice;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class ExceptTest {
//    @Test
//    public void loginSuccess(){
//        System.out.println("登录成功");
//    }

    @Test(expectedExceptions = RuntimeException.class)
    public void loginFailed(){
        System.out.println("登录失败");
        throw new RuntimeException();
    }
}
