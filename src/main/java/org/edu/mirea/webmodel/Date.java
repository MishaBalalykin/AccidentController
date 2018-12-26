package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mr.balalykin on 26.12.2018.
 */
public class Date implements Serializable{
    private Calendar date;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
