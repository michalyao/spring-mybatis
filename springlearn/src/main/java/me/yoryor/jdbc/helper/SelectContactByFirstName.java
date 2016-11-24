package me.yoryor.jdbc.helper;

import me.yoryor.jdbc.domain.Contact;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectContactByFirstName extends MappingSqlQuery<Contact> {
    private static final String SQL_FIND_BY_FRIST_NAME =
            "select * from contact where first_name = :first_name";

    public SelectContactByFirstName(DataSource ds) {
        super(ds, SQL_FIND_BY_FRIST_NAME);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
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
