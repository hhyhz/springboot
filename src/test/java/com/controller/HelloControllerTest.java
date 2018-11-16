package com.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {


    //@Autowired
    private MockMvc mockMvc;

    @Autowired
    HelloController helloController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        //MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        // mockMvc = MockMvcBuilders.standaloneSteup(userController).build(); //单个类  拦截器无效
    }


    @Test
    public void helloTest() throws Exception {

        System.out.println("================================开始请求================================");
        RequestBuilder request = MockMvcRequestBuilders.post("/hello")
                .contentType(MediaType.TEXT_HTML);

        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("状态码正确", status == 200);
        Assert.assertFalse("状态码错误", status != 200);
        Assert.assertTrue("网页标题正确", content.contains("<title>Wellcome</title>"));

        System.out.println("返回结果：" + status);
        System.out.println(content);

        System.out.println("================================正确完成请求================================");

    }


}