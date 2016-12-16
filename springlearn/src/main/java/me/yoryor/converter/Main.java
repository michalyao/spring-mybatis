package me.yoryor.converter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/convert.xml");
        ctx.refresh();
        Contact chris = ctx.getBean("chris", Contact.class);
        System.out.println("Chirs info: " + chris);

        Contact myContact = ctx.getBean("myContact", Contact.class);
        System.out.println("My info: " + myContact);
    }
}
