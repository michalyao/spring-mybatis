package me.yoryor;

import me.yoryor.config.AppConfigDemo;
import me.yoryor.config.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Startup {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context.xml");
//        ctx.refresh();
//        ctx.registerShutdownHook();
////
////        Message beanExample = (Message) ctx.getBean("beanExample");
////        System.out.println(beanExample.toString());
//
//        Publisher pub = (Publisher) ctx.getBean("publisher");
//        pub.publish("hello world!");
//        pub.publish("Spring start ...");


//        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);

            ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfigDemo.class);
            Message example = (Message) cxt.getBean("message", Message.class);
            System.out.println(example.getMsg());
    }
}
