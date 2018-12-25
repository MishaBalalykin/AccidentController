package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.entity.Creator;
import org.edu.mirea.entity.MediaProof;
import org.edu.mirea.entity.TextProof;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
@Ignore
public class ServiceImplTest {
    private int year = 2018;
    private int month = Calendar.DECEMBER;
    private int day1 = 21;

    private ServiceImpl service = new ServiceImpl();

    @Test
    public void createEvent() throws Exception {
        Creator misha = new Creator();
        misha.setName("misha");
        misha.setOtherContacts("https://vk.com/id*********");
        misha.setPhoneNumber("+7926011****");

        TextProof mishasTextProof = new TextProof();
        mishasTextProof.setProof("dtp with lory");

        Calendar eventDate = new GregorianCalendar();
        eventDate.set(year, month, day1);
        eventDate.setTime(new Date());

        Accident accidentCreatedByMisha = new Accident();
        accidentCreatedByMisha.setAccidentAddress("novomytishinsky prospect");
        accidentCreatedByMisha.setAccidentDate(eventDate);
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
        accidentCreatedByKostya.setAccidentDate(eventDate);
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
        accidentCreatedByOlga.setAccidentDate(eventDate);
        accidentCreatedByOlga.setCreator(olga);
        accidentCreatedByOlga.setTextProof(olgasTextProof);

        service.createEvent(accidentCreatedByOlga);


    }

    @Test
    public void getEventByPeriod() {
        String address = "mira street";
        Calendar startPeriod = new GregorianCalendar(year, month, day1);
        int day2 = 22;
        Calendar finishPeriod = new GregorianCalendar(year, month, day2);

        List<Accident> accidents = service.getEventByPeriod(address, startPeriod, finishPeriod);

        printEvent(accidents);
    }

    @Test
    public void getEventByDate() {
        String address = "mira street";
        Calendar date = new GregorianCalendar(year, month, day1);

        List<Accident> accidents = service.getEventByDate(address, date);

        printEvent(accidents);
    }

    @Test
    public void getEventByAddress(){
//        String address = "mira street";

//        List<Accident> accidents = service.getEventByAddress(address);

//        printEvent(accidents);
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