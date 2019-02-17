package org.edu.mirea.webmodel;

import java.io.Serializable;
import java.util.*;

/**
 * Created by mr.balalykin on 25.12.2018.
 */

public class WebAccident implements Serializable {
    private WebCreator creator;
    private WebTextProof textProof;
    private List<WebMediaProof> mediaProofs = new ArrayList<>();
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

    public List<WebMediaProof> getMediaProofs() {
        return mediaProofs;
    }

    public void setMediaProofs(List<WebMediaProof> mediaProofs) {
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
