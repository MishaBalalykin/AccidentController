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
//        creator.setCreatorId(2L);
        creator.setName("misha");
        creator.setOtherContacts("vk");
        creator.setPhoneNumber("+79260113914");

        TextProof textProof = new TextProof();
//        textProof.setCreatorId(2L);
        textProof.setProof("proof");

        MediaProof mediaProof = new MediaProof();
        mediaProof.setProof("mediaProof");
//        mediaProof.setProofId(2L);

        Accident accident = new Accident();
        accident.setAccidentAddress("address");
        accident.setAccidentDate(new Date());
//        accident.setAccidentId(2L);
        accident.setCreator(creator);
        accident.setTextProof(textProof);
//        mediaProof.setAccident(accident);
        Set set = new HashSet();
        set.add(mediaProof);
        accident.setMediaProofs(set);

        service.createEvent(accident);

    }

}