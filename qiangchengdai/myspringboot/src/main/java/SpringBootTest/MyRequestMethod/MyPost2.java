package SpringBootTest.MyRequestMethod;

import SpringBootTest.testData.LoginCase;
import SpringBootTest.testData.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


//@Log4j2
//@RestController
//@Api("/")
//public class MyPost2 {
//
//    @Autowired
//    private SqlSessionTemplate template;
//    //这个变量是用来装cookies信息的
//    private static Cookie cookie;
//
//    @ApiOperation(value = "获取post请求的cookie",httpMethod = "POST")
//    @RequestMapping(value = "/post/getCookie", method = RequestMethod.POST)
//    public String postCookie(HttpServletResponse response, @RequestParam(value = "userName",required = true) String userName,
//                                                           @RequestParam(value = "password",required = true) String password) {
//
//        try {
//            LoginCase cases = template.selectOne("getUser", userName);
//            if (cases.getUserName().equals(userName) && cases.getPassword().equals(password)) {
//                cookie = new Cookie("login", "success");
//                response.addCookie(cookie);
//                return "{\"code\":200,\"status\":\"success\",\"msg\":\"登录成功\"}";
//            }
//            return "{\"code\":102,\"status\":\"fail\",\"msg\":\"用户名或密码错误\"}";
//
//        } catch (NullPointerException e) {
//            return "{\"code\":101,\"status\":\"fail\",\"msg\":\"请注册后登陆\"}";
//        }
//    }
//
//    @ApiOperation(value = "post请求添加cookie",httpMethod = "POST")
//    @RequestMapping(value = "/post/addCookie",method = RequestMethod.POST)
//    public String addCookie(HttpServletRequest request,
//                            @RequestBody UserInfo user){
//
//        UserInfo u;
//        Cookie[] cookies = request.getCookies();
//        if(Objects.isNull(cookies)){
//            return "{\"code\":100,\"status\":\"fail\",\"msg\":\"请携带cookie信息请求\"}";
//        }
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals("login") && cookie.getValue().equals("success")
//            && user.getUserName().equals("zhangsan") && user.getAge().equals("18")){
//                //return "{\"code\":200,\"status\":\"success\",\"msg\":\"cookie添加成功\"}";
//                u = new UserInfo();
//                u.setUserName("lisi");
//                u.setAge("20");
//                return u.toString();
//            }
//        }
//        return "{\"code\":101,\"msg\":\"请上传正确的cookie信息\"}";
//   }
//}
