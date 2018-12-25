package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mr.balalykin on 25.12.2018.
 */
public class AddressAndPeriodRequest implements Serializable{
    private String address;
    private Calendar startPeriod;
    private Calendar finishPeriod;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Calendar startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Calendar getFinishPeriod() {
        return finishPeriod;
    }

    public void setFinishPeriod(Calendar finishPeriod) {
        this.finishPeriod = finishPeriod;
    }
}
