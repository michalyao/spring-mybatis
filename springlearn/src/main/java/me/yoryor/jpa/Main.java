package me.yoryor.jpa;

import me.yoryor.hibernate.entity.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/jpa2.xml");
        ctx.refresh();
        Contact contact1 = new Contact();
        contact1.setBirthDate(Date.from(Instant.now()));
        contact1.setFirstName("heh");
        contact1.setLastName("hah");

        ContactService contactService = (ContactService) ctx.getBean("jpaContactService");
        ContactSummaryService contactSummaryService = (ContactSummaryService) ctx.getBean("contactSummaryService");
//        contactDao.save(contact1);
//        Contact contact = contactDao.findById(1L);
//        System.out.println(contact);
        List<Contact> all = contactService.findAll();
        all.forEach(contact -> {
            System.out.println(contact.getId() + contact.getLastName() + contact.getBirthDate());
        });

        contactService.findAllWithDetail().forEach(System.out::println);
        contactSummaryService.findAll().forEach(System.out::println);

    }
}
