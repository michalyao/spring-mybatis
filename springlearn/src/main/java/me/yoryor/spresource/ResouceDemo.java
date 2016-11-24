package me.yoryor.spresource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class ResouceDemo {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new GenericXmlApplicationContext();
//        Resource resource = applicationContext.getResource("classpath:Test.kt");
        Resource resource = applicationContext.getResource("classpath:Test.kt");
        System.out.println("resource length" + resource.contentLength());
        System.out.println(resource.createRelative("hello.text"));
        System.out.println(resource.exists());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile());
        System.out.println(resource.getURI());
    }
}
