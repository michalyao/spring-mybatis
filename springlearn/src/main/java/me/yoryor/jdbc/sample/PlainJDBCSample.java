package me.yoryor.jdbc.sample;

import me.yoryor.jdbc.dao.ContactDao;
import me.yoryor.jdbc.domain.Contact;
import me.yoryor.jdbc.impl.ContactDaoPureImpl;

import java.util.List;

public class PlainJDBCSample {
    private static ContactDao contactDao = new ContactDaoPureImpl();

    public static void main(String[] args) {
        System.out.println("List initial contact data:");
        List<Contact> all = contactDao.findAll();
        for (Contact contact : all) {
            System.out.println(contact);
        }
    }
}
