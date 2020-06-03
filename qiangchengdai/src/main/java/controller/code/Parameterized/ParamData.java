package controller.code.Parameterized;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class ParamData {
/*    @Test(dataProvider = "data")
    public void login(String name,int age){
        System.out.println("他的名字是："+name+", 年龄是："+age+"岁！！！");
    }

    //第一种参数化
    @DataProvider(name="data")
    public Object[][] paramData(){
        Object[][] O =new Object[][]{
                {"星星",10},
                {"月亮",20},
                {"太阳",30}
        };
        return O;
    }*/

    //第二种参数化
    @Test(dataProvider = "methodData")
    public void sign1(String name,int age){
        System.out.println("他的名字是："+name+", 年龄是："+age+"岁！！！");
    }

    @Test(dataProvider = "methodData")
    public void sign2(String name,int age){
        System.out.println("他的名字是："+name+", 年龄是："+age+"岁！！！");
    }

    @Test(dataProvider = "methodData")
    public void sign3(String name,int age){
        System.out.println("他的名字是："+name+", 年龄是："+age+"岁！！！");
    }

    @DataProvider(name = "methodData")
    public Object[][] paramDataTest(Method method){
        Object[][] res;
        if(method.getName().equals("sign1")){
            res = new Object[][]{
                    {"张三",18},
                    {"李四",16}
            };
        }
        else if(method.getName().equals("sign2")){
            res = new Object[][]{
                    {"王五",20},
                    {"赵六",22}
            };
        }
        else{
            res = new Object[][]{
                    {"周七",24},
                    {"吴八",25}
            };
        }
        return res;
    }
}
