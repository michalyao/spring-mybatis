package me.yoryor.jdbc.helper;

import me.yoryor.jdbc.domain.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static final String SQL_SELECT_ALL_CONTACT =
            "select * from contact";

    public SelectAllContacts(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }

    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println("executed by MappingSqlQuery... ");
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthDate(resultSet.getDate("birth_date"));
        return contact;
    }
}
