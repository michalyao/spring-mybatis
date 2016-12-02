package me.yoryor.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    private String hobbyId;
    private Set<Contact> contacts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
    joinColumns = @JoinColumn(name = "HOBBY_ID"),
    inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Id
    @Column(name = "HOBBY_ID")
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hobby{");
        sb.append("hobbyId='").append(hobbyId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
