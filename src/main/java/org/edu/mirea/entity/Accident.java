package org.edu.mirea.entity;

import javax.persistence.*;
import java.util.Calendar;
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
    @JoinColumn(name = "ID", updatable = false)
    private Creator creator;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID", updatable = false)
    private TextProof textProof;

    @OneToMany(mappedBy = "accident", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MediaProof> mediaProofs = new HashSet<MediaProof>();

    @Column(name = "ACCIDENT_ADDRESS", nullable = false, length = 4000, updatable = false)
    private String accidentAddress;

    @Column(name = "ACCIDENT_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar accidentDate;

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

    public Calendar getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Calendar accidentDate) {
        this.accidentDate = accidentDate;
    }
//endregion
}