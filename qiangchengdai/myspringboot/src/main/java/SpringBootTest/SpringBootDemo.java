package SpringBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class SpringBootDemo {

    @RequestMapping("/")
    @ResponseBody
    String SpringBootTest(){
        return "hello word";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo.class,args);
    }
}
