package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mr.balalykin on 26.12.2018.
 */
public class Period implements Serializable{
    private Calendar startPeriod;
    private Calendar finishPeriod;

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
