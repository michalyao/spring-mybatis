package me.yoryor.jpa;

import me.yoryor.hibernate.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);

    default List<Contact> findAllByNativeQuery() {
        return null;
    }

    default List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        return null;
    }
}
