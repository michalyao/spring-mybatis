package me.yoryor.jpa;

import me.yoryor.hibernate.entity.Contact;
import me.yoryor.hibernate.entity.ContactTelDetail;
import me.yoryor.hibernate.entity.Hobby;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contact.class)
public abstract class Contact_ {

	public static volatile SingularAttribute<Contact, String> firstName;
	public static volatile SingularAttribute<Contact, String> lastName;
	public static volatile SetAttribute<Contact, Hobby> hobbies;
	public static volatile SingularAttribute<Contact, Long> id;
	public static volatile SingularAttribute<Contact, Integer> version;
	public static volatile SingularAttribute<Contact, Date> birthDate;
	public static volatile SetAttribute<Contact, ContactTelDetail> contactTelDetails;

}

