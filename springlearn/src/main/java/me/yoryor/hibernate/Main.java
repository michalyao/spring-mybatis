package me.yoryor.hibernate;

import me.yoryor.hibernate.entity.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/hibernate.xml");
        ctx.refresh();
        Contact contact1 = new Contact();
        contact1.setBirthDate(Date.from(Instant.now()));
        contact1.setFirstName("heh");
        contact1.setLastName("hah");

        ContactDao contactDao = (ContactDao) ctx.getBean("contactDao");
        contactDao.save(contact1);
        Contact contact = contactDao.findById(1L);
        System.out.println(contact);
        contactDao.findAllWithDetail().forEach(System.out::println);
    }
}
