package controller.code.Parameterized;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

    @Test
    @Parameters({"name","age"})
    public void login(String name,int age){
        System.out.println("他的名字是："+name+", 年龄是："+age+"岁！！！");
    }
}
