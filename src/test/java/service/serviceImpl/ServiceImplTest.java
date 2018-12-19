package service.serviceImpl;

import entity.Accident;
import entity.Creator;
import entity.MediaProof;
import entity.TextProof;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
public class ServiceImplTest {
    //    @Ignore
    @Test
    public void createEvent() throws Exception {

        ServiceImpl service = new ServiceImpl();

        Creator creator = new Creator();
        creator.setName("misha");
        creator.setOtherContacts("vk");
        creator.setPhoneNumber("+79260113914");

        TextProof textProof = new TextProof();
        textProof.setProof("proof");


        Accident accident = new Accident();
        accident.setAccidentAddress("address");
        accident.setAccidentDate(new Date());
        accident.setCreator(creator);
        accident.setTextProof(textProof);

        MediaProof mediaProof = new MediaProof();
        mediaProof.setProof("mediaProof");
        mediaProof.setAccident(accident);
        MediaProof mediaProof1 = new MediaProof();
        mediaProof1.setProof("MEDIAPROOF");
        mediaProof1.setAccident(accident);
        MediaProof mediaProof2 = new MediaProof();
        mediaProof2.setProof("MEDIAproof");

        accident.addMediaProof(mediaProof);
        accident.addMediaProof(mediaProof1);

        service.createEvent(accident);
    }

}