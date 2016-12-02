package me.yoryor.jpa;

import me.yoryor.hibernate.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    private static final String ALL_CONTACT = "select id, first_name, last_name, birth_date, version from contact";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = entityManager
                .createNamedQuery("Contact.findAll", Contact.class)
                .getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = entityManager
                .createNamedQuery("Contact.findAllWithDetail", Contact.class)
                .getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
        Contact contact = entityManager
                .createNamedQuery("Contact.findById", Contact.class)
                .setParameter("id", id)
                .getSingleResult();
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) { // new obj ? insert(persist) else update(merge)
            entityManager.persist(contact);
        } else {
            entityManager.merge(contact);
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        // merge state to current persistence context
        Contact merge = entityManager.merge(contact);
        entityManager.remove(merge);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllByNativeQuery() {
        return entityManager
//                .createNativeQuery(ALL_CONTACT, Contact.class) // class or sqlresultmapping
                .createNativeQuery(ALL_CONTACT, "contactResult")
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); // 1. create builder
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class); // 2. specific result type
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class); // 3. from -> Root as query basic
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        criteriaQuery.select(contactRoot).distinct(true);
        Predicate predicate = cb.conjunction();
        if (firstName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
            predicate = cb.and(predicate, p);
        }
        if (lastName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
            predicate = cb.and(predicate, p);
        }
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
