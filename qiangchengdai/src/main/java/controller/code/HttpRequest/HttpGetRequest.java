package controller.code.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ResourceBundle;


public class HttpGetRequest {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookie;
//    @Test
//    public void getUrl(){
//        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
//        this.url=bundle.getString("test.ip") + bundle.getString("test.home");
//        System.out.println(this.url);
//    }
    @Test
    public void getCookie() throws IOException {
        HttpGet get = new HttpGet("http://127.0.0.1:6789/home");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        // 获取cookie
        this.cookie = client.getCookieStore();
        HttpEntity entity = response.getEntity();
        String res= EntityUtils.toString(entity);
        System.out.println(res);
    }

    @Test(dependsOnMethods = "getCookie")
    public void commitCookie() throws IOException {
        HttpGet get = new HttpGet("http://127.0.0.1:6789/cookie");
        DefaultHttpClient client = new DefaultHttpClient();
        // 添加cookie
        client.setCookieStore(this.cookie);
        System.out.println(this.cookie);
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        int code = response.getStatusLine().getStatusCode();
        String res= EntityUtils.toString(entity);
        System.out.println(res);
        try{
            Assert.assertEquals(200,code);
        }
        catch(ArithmeticException e){
            //System.out.println("断言错误"+e);
            e.printStackTrace();
        }
        System.out.println("测试结束");
    }
}
