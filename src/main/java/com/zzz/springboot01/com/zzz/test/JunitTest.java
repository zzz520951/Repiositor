package com.zzz.springboot01.com.zzz.test;

import com.zzz.springboot01.Springboot01Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 测试用例
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Springboot01Application.class})//指定启动类
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本
public class JunitTest {
    /**
     * 测试方法
     */
    @Test
   public  void  test(){

   }

    //@Before //在每个测试方法前执行
    //@BeforeClass //在测试方法前执行一次
    public  void  testBefore(){

    }

    //@After
    //@AfterClass
    public  void  testAfter(){

    }
    /**
     * 基于RESTful风格的SpringMVC的测试，我们可以测试完整的Spring MVC流程，
     * 即从URL请求到控制器处理，再到视图渲染都可以测试。
     */
    /**
     *  注入一个web应用环境(容器)
     */

    /**
     * @Resource注入bean
     *  @Autowired 自动注入
     */
    @Autowired
    private WebApplicationContext  webApplicationContext;
    /**
     * mvc环境对象
     */
    private MockMvc mockMvc;

    /**
     * 初始化mvc环境对象
     */
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    /**
     * 测试例子
     */
    @Test
    public  void  restfulMvcTest () throws Exception{
                     //执行请求
                    //构建请求
                   //添加验证规则 验证执行后的结果是否符合规则
                 //添加结果处理器
        //最后返回相应的MvcResult
        String str = mockMvc.perform(MockMvcRequestBuilders.get("/1/2")
               .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andReturn().getResponse().getContentAsString();
        System.out.println(str);
    }









}
