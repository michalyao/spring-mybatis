package me.yoryor.jdbc.domain;

import java.io.Serializable;

public class ContactTelDetail implements Serializable{
    private long id;
    private long contactId;
    private String telType;
    private String telNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetail that = (ContactTelDetail) o;

        if (id != that.id) return false;
        if (contactId != that.contactId) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;
        return telNumber != null ? telNumber.equals(that.telNumber) : that.telNumber == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (contactId ^ (contactId >>> 32));
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactTelDetail{");
        sb.append("id=").append(id);
        sb.append(", contactId=").append(contactId);
        sb.append(", telType='").append(telType).append('\'');
        sb.append(", telNumber='").append(telNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
