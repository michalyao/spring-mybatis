package me.yoryor.jdbc.sample;

import me.yoryor.jdbc.dao.ContactDao;
import me.yoryor.jdbc.domain.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AnnotationJdbcSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/datasource-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);


        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("heh");
        contact.setLastName("hah");
        contact.setBirthDate(new Date(LocalDate.of(1999, 12, 10).toEpochDay()));
        contactDao.update(contact);

        List<Contact> all = contactDao.findAll();
        List<Contact> chris = contactDao.findByFirstName("Chris");
        System.out.println(chris);
        all.forEach(System.out::println);
    }
}
