package service.serviceImpl;

import entity.Accident;
import entity.Creator;
import entity.MediaProof;
import entity.TextProof;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
public class ServiceImplTest {
    private ServiceImpl service = new ServiceImpl();

    @Test
    public void createEvent() throws Exception {
        Creator misha = new Creator();
        misha.setName("misha");
        misha.setOtherContacts("https://vk.com/id*********");
        misha.setPhoneNumber("+7926011****");

        TextProof mishasTextProof = new TextProof();
        mishasTextProof.setProof("dtp with lory");

        Accident accidentCreatedByMisha = new Accident();
        accidentCreatedByMisha.setAccidentAddress("novomytishinsky prospect");
        accidentCreatedByMisha.setAccidentDate(new Date());
        accidentCreatedByMisha.setCreator(misha);
        accidentCreatedByMisha.setTextProof(mishasTextProof);

        MediaProof mishasFirstMediaProof = new MediaProof();
        mishasFirstMediaProof.setProof("it will be a video file");
        mishasFirstMediaProof.setAccident(accidentCreatedByMisha);
        MediaProof mishasSecondMediaProof = new MediaProof();
        mishasSecondMediaProof.setProof("it will be another video file");
        mishasSecondMediaProof.setAccident(accidentCreatedByMisha);


        accidentCreatedByMisha.addMediaProof(mishasFirstMediaProof);
        accidentCreatedByMisha.addMediaProof(mishasSecondMediaProof);

        service.createEvent(accidentCreatedByMisha);

//////////////////////////////////////////////////////////////////////////////

        Creator kostya = new Creator();
        kostya.setName("kostya");
        kostya.setOtherContacts("https://vk.com/id*********");
        kostya.setPhoneNumber("+7916183****");

        TextProof kostyasTextProof = new TextProof();
        kostyasTextProof.setProof("dtp with small car");

        Accident accidentCreatedByKostya = new Accident();
        accidentCreatedByKostya.setAccidentAddress("mira street");
        accidentCreatedByKostya.setAccidentDate(new Date());
        accidentCreatedByKostya.setCreator(kostya);
        accidentCreatedByKostya.setTextProof(kostyasTextProof);

        MediaProof kostyassFirstMediaProof = new MediaProof();
        kostyassFirstMediaProof.setProof("it will be a video file");
        kostyassFirstMediaProof.setAccident(accidentCreatedByKostya);
        MediaProof kostyasSecondMediaProof = new MediaProof();
        kostyasSecondMediaProof.setProof("it will be another video file");
        kostyasSecondMediaProof.setAccident(accidentCreatedByKostya);


        accidentCreatedByKostya.addMediaProof(kostyassFirstMediaProof);
        accidentCreatedByKostya.addMediaProof(kostyasSecondMediaProof);

        service.createEvent(accidentCreatedByKostya);


//////////////////////////////////////////////////////////////////////////////

        Creator olga = new Creator();
        olga.setName("olga");
        olga.setOtherContacts("https://vk.com/id*********");
        olga.setPhoneNumber("+7925184****");

        TextProof olgasTextProof = new TextProof();
        olgasTextProof.setProof("dtp with small people");

        Accident accidentCreatedByOlga = new Accident();
        accidentCreatedByOlga.setAccidentAddress("kulneva street");
        accidentCreatedByOlga.setAccidentDate(new Date());
        accidentCreatedByOlga.setCreator(olga);
        accidentCreatedByOlga.setTextProof(olgasTextProof);

        service.createEvent(accidentCreatedByOlga);


    }

    @Test
    public void getEventByPeriod() {
        String address = "mira street";
        Calendar startPeriod = new GregorianCalendar(2018, Calendar.DECEMBER, 20);
        Calendar finishPeriod = new GregorianCalendar(2018, Calendar.DECEMBER, 21);

        List<Accident> accidents = service.getEventByPeriod(address, startPeriod, finishPeriod);

        printEvent(accidents);
    }

    @Test
    public void getEventByDate() {
        String address = "mira street";
        Calendar date = new GregorianCalendar(2018, Calendar.DECEMBER, 20);

        List<Accident> accidents = service.getEventByDate(address, date);

        printEvent(accidents);
    }

    @Test
    public void getEventByAddress(){
        String address = "mira street";

        List<Accident> accidents = service.getEventByAddress(address);

        printEvent(accidents);
    }

    private void printEvent(List<Accident> accidents) {
        for (Accident accident : accidents) {
            System.out.println(accident.getAccidentAddress());
            System.out.println(accident.getAccidentDate());
            System.out.println(accident.getCreator());
            System.out.println(accident.getMediaProofs());
            System.out.println(accident.getTextProof());
            System.out.println();
        }
    }

}