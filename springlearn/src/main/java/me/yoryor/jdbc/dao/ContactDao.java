package me.yoryor.jdbc.dao;

import me.yoryor.jdbc.domain.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findLastNameById(long id);
    String findFirstNameById(long id);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Long id);

    List<Contact> findAllWithDetail();

}
