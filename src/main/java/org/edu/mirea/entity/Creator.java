package org.edu.mirea.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Entity
@Table(name = "CREATOR_INFO")
public class Creator {
    public Creator() {
    }

    @JsonIgnore
    @OneToOne(mappedBy = "creator")
    private Accident accident;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREATOR_INFO_SEQ")
    @SequenceGenerator(name = "CREATOR_INFO_SEQ",
            sequenceName = "CREATOR_INFO_SEQ", allocationSize = 1)
    @Column(name = "ACCIDENT_ID", updatable = false)
    private long creatorId;

    @Column(name = "NAME", updatable = false)
    private String name;

    @Column(name = "PHONE_NUMBER", length = 12, nullable = false, updatable = false)
    private String phoneNumber;

    @Column(name = "OTHER_CONTACTS", length = 1000, updatable = false)
    private String otherContacts;

    //region getters and setters
    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherContacts() {
        return otherContacts;
    }

    public void setOtherContacts(String otherContacts) {
        this.otherContacts = otherContacts;
    }
//endregion
}
