package org.edu.mirea.entity;

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

    @ManyToOne
    @JoinColumn(name = "ACCIDENT_ID", updatable = false)
    private Accident accident;

    @Column(name = "PROOF", updatable = false)
    private String proof;

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

    /*public long getProofId() {
        return proofId;
    }

    public void setProofId(long proofId) {
        this.proofId = proofId;
    }*/

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
    //endregion

    //region equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaProof that = (MediaProof) o;

        if (id != that.id) return false;
        if (accident != null ? !accident.equals(that.accident) : that.accident != null) return false;
        return proof != null ? proof.equals(that.proof) : that.proof == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accident != null ? accident.hashCode() : 0);
        result = 31 * result + (proof != null ? proof.hashCode() : 0);
        return result;
    }
    //endregion
}
