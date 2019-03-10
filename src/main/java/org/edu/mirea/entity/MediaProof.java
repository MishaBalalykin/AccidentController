package org.edu.mirea.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Entity
@Table(name = "MEDIA_PROOF")
public class MediaProof {
    public MediaProof() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDIA_PROOF_SEQ")
    @SequenceGenerator(name = "MEDIA_PROOF_SEQ",
            sequenceName = "MEDIA_PROOF_SEQ", allocationSize = 1)
    @Column(updatable = false)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCIDENT_ID", updatable = false)
    private Accident accident;

    @Column(name = "PROOF", updatable = false)
    private byte[] proof;

    //region getters and setters
    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }
    //endregion
}
