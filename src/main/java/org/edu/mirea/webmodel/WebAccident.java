package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr.balalykin on 25.12.2018.
 */

public class WebAccident implements Serializable {
    private WebCreator creator;
    private WebTextProof textProof;
    private Set<WebMediaProof> mediaProofs = new HashSet<>();
    private String accidentAddress;
    private Calendar accidentDate;

    public WebCreator getCreator() {
        return creator;
    }

    public void setCreator(WebCreator creator) {
        this.creator = creator;
    }

    public WebTextProof getTextProof() {
        return textProof;
    }

    public void setTextProof(WebTextProof textProof) {
        this.textProof = textProof;
    }

    public Set<WebMediaProof> getMediaProofs() {
        return mediaProofs;
    }

    public void setMediaProofs(Set<WebMediaProof> mediaProofs) {
        this.mediaProofs = mediaProofs;
    }

    public String getAccidentAddress() {
        return accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress;
    }

    public Calendar getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Calendar accidentDate) {
        this.accidentDate = accidentDate;
    }
}
