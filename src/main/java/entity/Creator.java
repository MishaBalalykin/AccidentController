package entity;

import javax.persistence.*;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
@Entity
@Table(name = "CREATOR_INFO")
public class Creator {
    public Creator() {
    }

    @OneToOne(mappedBy = "creator")
    private Accident accident;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREATOR_INFO_SEQ")
    @SequenceGenerator(name = "CREATOR_INFO_SEQ",
            sequenceName = "CREATOR_INFO_SEQ", allocationSize = 1)
    @Column(name = "ACCIDENT_ID", insertable = false, updatable = false)
    private long creatorId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "OTHER_CONTACTS", length = 1000)
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
