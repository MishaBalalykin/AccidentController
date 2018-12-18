package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Entity
@Table(name = "MEDIA_PROOF")
public class MediaProof {
    @ManyToOne
    @JoinColumn(name = "PROOF_ID", insertable = false, updatable = false)
    private Accident accident;



    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MEDIA_PROOF_SEQ")
    @SequenceGenerator(name="MEDIA_PROOF_SEQ",
            sequenceName="MEDIA_PROOF_SEQ", allocationSize=1)
    @Column(name = "PROOF_ID")
    private long proofId;

    @Column(name = "PROOF")
    private String proof;

    //region getters and setters
    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public long getProofId() {
        return proofId;
    }

    public void setProofId(long proofId) {
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
