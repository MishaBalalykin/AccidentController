package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
@Entity
@Table(name = "TEXT_PROOF")
public class TextProof {
    @OneToOne(optional = true, mappedBy = "textProof")
    private Accident accident;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TEXT_PROOF_SEQ")
    @SequenceGenerator(name="TEXT_PROOF_SEQ",
            sequenceName="TEXT_PROOF_SEQ", allocationSize=1)
    @Column(name = "PROOF_ID", insertable = false, updatable = false)
    private long proofId;

    @Column(name = "PROOF", nullable = false, length = 4000)
    private String proof;

    //region getters and setters
    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public long getCreatorId() {
        return proofId;
    }

    public void setCreatorId(long proofId) {
        this.proofId = proofId;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
    //endregion
}
