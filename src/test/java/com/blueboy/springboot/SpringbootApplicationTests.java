package com.blueboy.springboot;

import com.blueboy.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 *
 * 可以在测试期间很方便的类似编码一样进行注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootApplicationTests {

    //自动注入
    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Autowired
    ApplicationContext ioc;
    //测试容器中有没有helloService
    //当在主配置类上面加上注解@ImportResource(locations = {"classpath:bean.xml"})之后，
    //ioc容器中就有了这个service类了
    @Test
    public void testHelloService(){
        System.out.println(ioc.containsBean("helloService"));
    }

}
