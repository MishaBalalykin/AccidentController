package org.edu.mirea.webmodel.output;

import java.io.Serializable;

/**
 * Created by mr.balalykin on 25.12.2018.
 */
public class WebCreator implements Serializable {
    private String name;
    private String phoneNumber;
    private String otherContacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherContacts() {
        return otherContacts;
    }

    public void setOtherContacts(String otherContacts) {
        this.otherContacts = otherContacts;
    }
}
