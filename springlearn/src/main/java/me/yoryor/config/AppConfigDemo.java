package me.yoryor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigDemo {

    @Bean
    public Message message() {
        Message message =  new Message();
        message.setMsg(msg());
        return message;
    }


    @Bean
    public String msg() {
        return "hello world";
    }

}
