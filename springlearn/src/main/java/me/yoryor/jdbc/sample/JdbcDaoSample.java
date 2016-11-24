package me.yoryor.jdbc.sample;

import me.yoryor.jdbc.dao.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/datasource.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("jdbcContactDao", ContactDao.class);

        System.out.println(contactDao.findFirstNameById(4));
        System.out.println(contactDao.findAll());
        System.out.println(contactDao.findAllWithDetail());
    }
}
