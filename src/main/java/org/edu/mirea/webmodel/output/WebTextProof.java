package org.edu.mirea.webmodel.output;

import java.io.Serializable;

/**
 * Created by mr.balalykin on 25.12.2018.
 */
public class WebTextProof implements Serializable {
    private String proof;

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
}
