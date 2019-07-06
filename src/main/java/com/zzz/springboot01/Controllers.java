package com.zzz.springboot01;

import com.zzz.springboot01.com.zzz.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**1. @Controller 一方面向IOC容器中注入bean，另一方面声明请求处理器
 * 2. @RestController和@RequestMapping是SpirngMVC的注解，不是SpringBoot特有的注解
 * 3. @RestController是@Controller和@ResponseBody的组合
 * 4. @RequestMapping 配置url映射
 * 5. @GetMapping 组合注解 相当于 @RequestMapping(method = RequestMethod.GET)
 * 6. @PostMapping 组合注解 相当于 @RequestMapping(method = RequestMethod.POST)
 * 7. @ExceptionHandler(value = Exception.class) 捕获异常 （用于统一异常处理）
 * 8. @ConfigurationProperties 把yml里面一组配置参数封装成一个类
 * 9. @Component 向SpringBoot注册一个类,泛指组件，当组件不好归类的时候，我们可以使用
 * 这个注解进行标注。
 * 10. @PathVariable 获取url中的数据 /100 （获取详细信息）
 * 11. @RequestParam 获取请求参数的值 ？id=100
 * 12. @Valid 表单验证在Controller层加上@valid，后紧跟BindingResult，通过
 * BingdingResult.getFieId.getDefaultMessage()获取错误信息，表单验证注解
 * 13. @Pointcut注解声明切入点
 * 14. @AfterReturning aop中用@AfterReturning获取返回的内容
 * @author Administrator
 */
@RestController
//@Controller
public class Controllers {

    private  final Map<String,Object> map = new HashMap<>();
    /**
     * 功能描述: 测试restful 协议， 从路径中获取字段
     * @param city_id
     * @param user_id
     * @return
     */
    @GetMapping("/{city_id}/{user_id}")
    public Map<String, Object> findObject(@PathVariable("city_id") String city_id, @PathVariable("user_id") String user_id){
        map.clear();
        map.put("city_id", city_id);
        map.put("user_id", user_id);
        return  map;
    }
      @RequestMapping("/test/{id}")
      public  String test (@PathVariable("id") int id){

        return  "SpringBoot HelloWord"+id;
      }

    @RequestMapping("/test01")
    public  String test01 (@RequestHeader("id") int id){

        return  "SpringBoot HelloWord"+id;
    }

    @GetMapping("/testGet/{id}")
    public  String get (@PathVariable("id") int id){
        return  "SpringBoot HelloWord"+id;
    }

    @PostMapping("/testPost/{id}")
    public  String post (@PathVariable("id") int id){
        return  "SpringBoot HelloWord"+id;
    }

    @DeleteMapping("/testDelete/{id}")
    public  String dele (@PathVariable("id") int id){
        return  "SpringBoot HelloWord"+id;
    }

    @PutMapping("/testPut/{id}")
    public  String put (@PathVariable("id") int id){
        return  "SpringBoot HelloWord"+id;
    }
    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     *      2、使用body传输数据
     * @param user
     * @return
     */
    @GetMapping("/save_user")
    public Object saveUser(User user){
        map.clear();
        map.put("user", user);
        return map;
    }

    /**
     * 异常测试
     * @return
     */
    @GetMapping(value="/abc")
    public Object testException(){
        int i = 5/0;
        return i;
    }
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.addObject("stackTrace", e.getStackTrace());
        modelAndView.setViewName("error");
        return modelAndView;
    }
    @Value("${test.env}")
    private String env;

    @RequestMapping("/bcd")
    public String testMultipartEnv(){
        return "当前启动环境为:[" + env + "]";
    }
/*spring-boot整合Freemarker*/
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("content", "Freemarker");
        return "index";
    }
}
