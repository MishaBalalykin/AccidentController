package org.edu.mirea.mapper;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.entity.Creator;
import org.edu.mirea.entity.MediaProof;
import org.edu.mirea.entity.TextProof;
import org.edu.mirea.webmodel.WebAccident;
import org.edu.mirea.webmodel.WebCreator;
import org.edu.mirea.webmodel.WebMediaProof;
import org.edu.mirea.webmodel.WebTextProof;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mr.balalykin on 25.12.2018.
 */

@Component
public class Mapper {
    /**
     * @param webAccident
     * @return Accident
     * <p>
     * Mapping WebAccident to Accident entity
     */
    public Accident map(WebAccident webAccident) {
        Accident accident = new Accident();
        List<WebMediaProof> webMediaProofs = webAccident.getMediaProofs();
        List<MediaProof> mediaProofs = new ArrayList<>();

        accident.setAccidentAddress(webAccident.getAccidentAddress());
        accident.setAccidentDate(webAccident.getAccidentDate());
        accident.setTextProof(map(webAccident.getTextProof()));
        accident.setCreator(map(webAccident.getCreator()));
        for (WebMediaProof webMediaProof : webMediaProofs) {
            MediaProof mediaProof = new MediaProof();
            mediaProof.setProof(webMediaProof.getMediaProof().getBytes());
            mediaProof.setAccident(accident);
            mediaProofs.add(mediaProof);
        }
        accident.setMediaProofs(mediaProofs);
        return accident;
    }

    /**
     * @param webTextProof
     * @return TextProof
     * <p>
     * Mapping WebTextProof to TextProof entity
     */
    private TextProof map(WebTextProof webTextProof) {
        TextProof textProof = new TextProof();
        textProof.setProof(webTextProof.getProof());
        return textProof;
    }

    /**
     * @param webCreator
     * @return Creator
     * <p>
     * Mapping WebCreator to Creator entity
     */
    private Creator map(WebCreator webCreator) {
        Creator creator = new Creator();
        creator.setName(webCreator.getName());
        creator.setPhoneNumber(webCreator.getPhoneNumber());
        creator.setOtherContacts(webCreator.getOtherContacts());
        return creator;
    }

    /**
     * @param webMediaProof
     * @return MediaProof
     * <p>
     * Mapping WebMediaProof to MediaProof entity
     */
    private MediaProof map(WebMediaProof webMediaProof) {
        MediaProof mediaProof = new MediaProof();
        mediaProof.setProof(webMediaProof.getMediaProof().getBytes());
        return mediaProof;
    }

    /**
     * @param accidents
     * @return List<WebAccident>
     * <p>
     * Mapping list of accidents entity to list web models
     */
    public List<WebAccident> map(List<Accident> accidents) {
        List<WebAccident> webAccidents = new ArrayList<>();

        for (Accident accident : accidents) {
            webAccidents.add(map(accident));
        }
        return webAccidents;
    }

    /**
     * @param accident
     * @return WebAccident
     * <p>
     * Mapping Accident entity to WebAccident web model
     */
    private WebAccident map(Accident accident) {
        WebAccident webAccident = new WebAccident();
        List<MediaProof> mediaProofs = accident.getMediaProofs();
        List<WebMediaProof> webMediaProofs = new ArrayList<>();

        webAccident.setAccidentAddress(accident.getAccidentAddress());
        webAccident.setAccidentDate(accident.getAccidentDate());
        webAccident.setCreator(map(accident.getCreator()));
        webAccident.setTextProof(map(accident.getTextProof()));
        webMediaProofs.addAll(mediaProofs.stream().map(this::map).collect(Collectors.toList()));
        webAccident.setMediaProofs(webMediaProofs);

        return webAccident;
    }

    /**
     * @param mediaProof
     * @return WebMediaProof
     * <p>
     * Mapping MediaProof entity to WebMediaProof web model
     */
    private WebMediaProof map(MediaProof mediaProof) {
        WebMediaProof webMediaProof = new WebMediaProof();

        webMediaProof.setMediaProof(new String(mediaProof.getProof()));

        return webMediaProof;
    }

    /**
     * @param creator
     * @return WebCreator
     * <p>
     * Mapping Creator entity to WebCreator web model
     */
    private WebCreator map(Creator creator) {
        WebCreator webCreator = new WebCreator();
        webCreator.setName(creator.getName());
        webCreator.setPhoneNumber(creator.getPhoneNumber());
        webCreator.setOtherContacts(creator.getOtherContacts());
        return webCreator;
    }

    /**
     * @param textProof
     * @return WebTextProof
     * <p>
     * Mapping TextProof entity to WebTextProof web model
     */
    private WebTextProof map(TextProof textProof) {
        WebTextProof webTextProof = new WebTextProof();
        webTextProof.setProof(textProof.getProof());
        return webTextProof;
    }
}
