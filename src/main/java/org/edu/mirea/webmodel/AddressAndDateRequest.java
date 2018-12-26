package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mr.balalykin on 25.12.2018.
 */

public class AddressAndDateRequest implements Serializable {
    private String address;
    private Calendar date;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
