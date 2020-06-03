package SpringBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan("SpringBootTest")  //定义需要扫描的包，括号里传包名
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
