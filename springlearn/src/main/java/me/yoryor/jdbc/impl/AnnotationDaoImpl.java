package me.yoryor.jdbc.impl;

import me.yoryor.jdbc.dao.ContactDao;
import me.yoryor.jdbc.domain.Contact;
import me.yoryor.jdbc.helper.SelectAllContacts;
import me.yoryor.jdbc.helper.SelectContactByFirstName;
import me.yoryor.jdbc.helper.UpdateContact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class AnnotationDaoImpl implements ContactDao {
    private static final Log LOG = LogFactory.getLog(AnnotationDaoImpl.class);
    private DataSource dataSource;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;

    private SelectAllContacts selectAllContacts;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    /**
     * named parameters
     * @param firstName
     * @return
     */
    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findLastNameById(long id) {
        return null;
    }

    @Override
    public String findFirstNameById(long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        paramMap.put("id", contact.getId());
        updateContact.updateByNamedParam(paramMap);
        LOG.info("update successed: " + contact.getId());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }
}
