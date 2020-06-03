package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.User;
import com.course.model.AddUserCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test
    public void addUserTrue() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addusercase = session.selectOne("addUserCase",1);
        System.out.println(addusercase.toString());

        TestConfig.addUserUrl= ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        System.out.println(TestConfig.addUserUrl);

        //获取请求结果
        String res = getResult(addusercase);
        Assert.assertEquals(addusercase.getExpected(),res);
    }

    @Test
    public void addUserFalse() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addusercase = session.selectOne("addUserCase",2);
        System.out.println(addusercase.toString());

        TestConfig.addUserUrl= ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        System.out.println(TestConfig.addUserUrl);

        //获取请求结果
        String res = getResult(addusercase);
        Assert.assertEquals(addusercase.getExpected(),res);
    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);

        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
//        param.put("isDelete",addUserCase.getIsDelete());
//        param.put("permission",addUserCase.getPermission());

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        // 添加参数
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookies
        TestConfig.client.setCookieStore(TestConfig.cookie);
        System.out.println(TestConfig.cookie);
        //发送请求

        HttpResponse response= TestConfig.client.execute(post);
        String Result = EntityUtils.toString(response.getEntity());

        JSONObject ob = new JSONObject(Result);
        System.out.println(Result);
        return ob.get("msg").toString();
    }
}