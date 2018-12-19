package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Entity
@Table(name = "ACCIDENT")
public class Accident {
    public Accident() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCIDENT_SEQ")
    @SequenceGenerator(name = "ACCIDENT_SEQ",
            sequenceName = "ACCIDENT_SEQ", allocationSize = 1)
    @Column(name = "ID", updatable = false)
    private long accidentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Creator creator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private TextProof textProof;

    @OneToMany(mappedBy = "accident", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MediaProof> mediaProofs = new HashSet<MediaProof>();

    @Column(name = "ACCIDENT_ADDRESS", nullable = false, length = 4000)
    private String accidentAddress;

    @Column(name = "ACCIDENT_DATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date accidentDate;

    public void addMediaProof(MediaProof mediaProof) {
        mediaProofs.add(mediaProof);
        mediaProof.setAccident(this);
    }

    public void removeMediaProof(MediaProof mediaProof) {
        mediaProofs.remove(mediaProof);
        mediaProof.setAccident(null);
    }

    //region getters and setters

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public TextProof getTextProof() {
        return textProof;
    }

    public void setTextProof(TextProof textProof) {
        this.textProof = textProof;
    }

    public Set<MediaProof> getMediaProofs() {
        return mediaProofs;
    }

    public void setMediaProofs(Set<MediaProof> mediaProofs) {
        this.mediaProofs = mediaProofs;
    }

    public long getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(long accidentId) {
        this.accidentId = accidentId;
    }

    public String getAccidentAddress() {
        return accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }
//endregion
}