package me.yoryor.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public void displayAllContactSummary() {
        List result = entityManager
                .createQuery("select c.firstName, c.lastName, t.telNumber from Contact c left join c.contactTelDetails t where t.telType='Home'")
                .getResultList();
        int count = 0;

        for (Iterator i = result.iterator(); i.hasNext();) {
            Object[] values = (Object[]) i.next();
            System.out.println(++count + ": " + values[0] + ", " + values[1] + values[2]);
        }
    }

    @Override
    public List<ContactSummary> findAll() {
        List<ContactSummary> result = entityManager
                .createQuery("select new me.yoryor.jpa.ContactSummary(" +
                        "c.firstName, c.lastName, t.telNumber) " +
                        "from Contact c left join c.contactTelDetails t " +
                        "where t.telType='Home'", ContactSummary.class)
                .getResultList();
        return result;
    }
}
