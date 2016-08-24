package org.yaoyao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yaoyao.entity.User;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void test() {
        System.out.println(userService.getUserById("666"));
//        System.out.println(userService.addUser(new User()));
    }
}