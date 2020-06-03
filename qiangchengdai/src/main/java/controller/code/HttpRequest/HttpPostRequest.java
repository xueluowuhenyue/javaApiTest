package controller.code.HttpRequest;

import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HttpPostRequest {
    private CookieStore cookie;

    @Test
    public void getCookie() throws IOException {
        HttpPost post = new HttpPost("http://127.0.0.1:6789/data");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
        // 获取cookie
        this.cookie = client.getCookieStore();
        System.out.println(this.cookie);
        //HttpEntity entity = response.getEntity();
        //String res = EntityUtils.toString(entity);
    }

    @Test(dependsOnMethods = "getCookie")
    protected void addCookie() throws IOException {
        // 声明请求方法 和地址
        HttpPost post = new HttpPost("http://127.0.0.1:6789/add/cookie");
        //声明一个Client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","zhangsan");
        param.put("age","18");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        post.setHeader("User-Agent","Apache-HttpClient/4.5.6");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        // 添加cookie
        client.setCookieStore(this.cookie);

        HttpResponse response = client.execute(post);
        //int code =response.getStatusLine().getStatusCode();

        //将返回结果转换成字符串
        String res = EntityUtils.toString(response.getEntity());
        System.out.println(res);

        //将返回的响应结果字符串转化成为json对象
        //JsonObject resultJson = new JsonObject(res);
        JSONObject object= new JSONObject(res);

        //获取json中到结果值
        String code = (String) object.get("code");
        String status = (String) object.get("status");

        //具体的判断返回结果的值
        Assert.assertEquals("200",code);
        Assert.assertEquals("success",status);
    }
}