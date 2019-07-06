package com.zzz.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot 项目一般都会有*Application的入口类，这个入口类中有main方法，
 * 这是一个标准的java应用程序的入口
 * @SpringBootApplication是springboot的核心注解，它是一个组合注解
 * @SpringBootConfiguration：表示Application作为配置文件存在
 * @EnableAutoConfiguration：表示启用SpringBoot内置的自动配置功能
 * @ComponentScan : 扫描bean，路径为Application类所在package以及package下的子路径，
 * 在spring boot中bean都放置在该路径以及子路径下。
 *
 */
@ServletComponentScan
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {

        SpringApplication.run(Springboot01Application.class, args);
    }

}
