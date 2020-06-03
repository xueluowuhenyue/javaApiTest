package SpringBootTest.MyRequestMethod;

import SpringBootTest.testData.LoginCase;
import SpringBootTest.testData.User;
import SpringBootTest.testData.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import org.mybatis.spring.SqlSessionTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;


@Log4j2
@RestController
@Api("/")
public class MyPostMethod {

    @Autowired
    private SqlSessionTemplate template;
    //这个变量是用来装cookies信息的
    private static Cookie cookie;

    @ApiOperation(value = "获取登陆请求的cookie",httpMethod = "POST")
    @RequestMapping(value = "/getCookie", method = RequestMethod.POST)
    public String postCookie(HttpServletResponse response, @RequestParam(value = "userName",required = true) String userName,
                                                           @RequestParam(value = "password",required = true) String password) {

        try {
            LoginCase cases = template.selectOne("getUser", userName);
            if (cases.getUserName().equals(userName) && cases.getPassword().equals(password)) {
                cookie = new Cookie("login", "success");
                response.addCookie(cookie);
                return "{\"code\":200,\"status\":\"success\",\"msg\":\"登录成功\"}";
            }
            return "{\"code\":102,\"status\":\"fail\",\"msg\":\"用户名或密码错误\"}";

        } catch (NullPointerException e) {
            return "{\"code\":101,\"status\":\"fail\",\"msg\":\"请注册后登陆\"}";
        }
    }

    @ApiOperation(value = "获取登陆请求的cookie",httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postCookie(HttpServletResponse response,
                             @RequestBody User user) {

        try {
            LoginCase cases = template.selectOne("getUser", user.getUserName());
            if (cases.getUserName().equals(user.getUserName()) && cases.getPassword().equals(user.getPassword())) {
                cookie = new Cookie("login", "success");
                response.addCookie(cookie);
                return "{\"code\":200,\"status\":\"success\",\"msg\":\"登录成功\"}";
            }
            return "{\"code\":102,\"status\":\"fail\",\"msg\":\"用户名或密码错误\"}";

        } catch (NullPointerException e) {
            return "{\"code\":101,\"status\":\"fail\",\"msg\":\"请注册后登陆\"}";
        }
    }


    @ApiOperation(value = "用户注册",httpMethod = "POST")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request,
                           @RequestBody User user){
        Cookie[] cookies = request.getCookies();
        if(Objects.nonNull(cookies)){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("login") && cookie.getValue().equals("success")
                && user.getUserName().length() <=10 && user.getPassword().length() <=8){
                    System.out.println(user.toString());
                    template.insert("addUser",user);
                    return "{\"code\":200,\"status\":\"success\",\"msg\":\"注册成功\"}";
                }
                else {
                    return "{\"code\":201,\"status\":\"success\",\"msg\":\"cookie错误或数据长度错误\"}";
                }
            }
        }
        return "{\"code\":202,\"status\":\"fail\",\"msg\":\"cookie为空\"}";
    }

    @ApiOperation(value = "添加用户",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(HttpServletRequest request,
                          @RequestParam String userName,
                          @RequestParam String password,
                          @RequestParam String sex,
                          @RequestParam String age){

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("success")){
                if(userName.length() <=16 && password.length() <=16){
                   return  "{\"code\":200,\"status\":\"success\",\"msg\":\"注册成功\"}";
                }
                return "{\"code\":201,\"status\":\"success\",\"msg\":\"数据错误\"}";
            }
            return "{\"code\":202,\"status\":\"success\",\"msg\":\"cookie错误\"}";
        }
        return "{\"code\":203,\"status\":\"success\",\"msg\":\"服务器错误\"}";
    }
}
