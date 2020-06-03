package SpringBootTest.MyRequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController  //加上标签才可以被识别
@Api(value = "/")
class MyGetMethod {
    @RequestMapping(value = "/get/cookie", method = RequestMethod.GET)
    @ApiOperation(value = "获取get请求的cookie",httpMethod = "GET")
    public String getCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "success");
        response.addCookie(cookie);
        return "{\"code\":200,\"status\":\"success\",\"msg\":\"cookie获取成功\"}";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @ApiOperation(value = "添加cookie的get请求",httpMethod = "GET")
    @RequestMapping(value = "/add/cookie", method = RequestMethod.GET)
    public String addCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "{\"code\":100,\"status\":\"fail\",\"msg\":\"请携带cookie信息请求\"}";
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("success")) {
                return "{\"code\":200,\"status\":\"success\"}";
            }
        }
        return "{\"code\":101,\"msg\":\"请上传正确的cookie信息\"}";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求。
     * 第一种实现方式 url: key=value&key=value
     * 我们来模拟获取商品列表
     */
    @ApiOperation(value = "第一种方法添加参数",httpMethod = "GET")
    @RequestMapping(value ="/add/param", method = RequestMethod.GET)
    public Map<String,Integer> addParam(@RequestParam Integer start,
                                        @RequestParam Integer end) {

        Map<String,Integer> myList = new HashMap<>();

        myList.put("java", 10);
        myList.put("python", 15);
        myList.put("c++", 20);
        myList.put("linux", 24);
        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     */
    @ApiOperation(value = "第二种方法添加参数",httpMethod = "GET")
    @RequestMapping(value = "/get/goods/{start}/{end}")
    public Map getGoods(@PathVariable Integer start,
                        @PathVariable Integer end){

        Map<String, Integer> goodsList = new HashMap<>();

        goodsList.put("语文", 10);
        goodsList.put("数学", 15);
        goodsList.put("英语", 20);
        goodsList.put("历史", 24);
        return goodsList;
    }
}