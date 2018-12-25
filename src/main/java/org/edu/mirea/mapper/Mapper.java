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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mr.balalykin on 25.12.2018.
 */
@Component
public class Mapper {
    public List<WebAccident> map(List<Accident> accidents) {
        List<WebAccident> webAccidents = new ArrayList<>();

        for (Accident accident : accidents) {
            webAccidents.add(map(accident));
        }
        return webAccidents;
    }

    private WebAccident map(Accident accident) {
        WebAccident webAccident = new WebAccident();
        Set<MediaProof> mediaProofs = accident.getMediaProofs();
        Set<WebMediaProof> webMediaProofs = new HashSet<>();

        webAccident.setAccidentAddress(accident.getAccidentAddress());
        webAccident.setAccidentDate(accident.getAccidentDate());
        webAccident.setCreator(map(accident.getCreator()));
        webAccident.setTextProof(map(accident.getTextProof()));
        webMediaProofs.addAll(mediaProofs.stream().map(this::map).collect(Collectors.toList()));
        webAccident.setMediaProofs(webMediaProofs);

        return webAccident;
    }

    private WebMediaProof map(MediaProof mediaProof) {
        WebMediaProof webMediaProof = new WebMediaProof();

        webMediaProof.setMediaProof(mediaProof.getProof());

        return webMediaProof;
    }

    private WebCreator map(Creator creator) {
        WebCreator webCreator = new WebCreator();
        webCreator.setName(creator.getName());
        webCreator.setPhoneNumber(creator.getPhoneNumber());
        webCreator.setOtherContacts(creator.getOtherContacts());
        return webCreator;
    }

    private WebTextProof map(TextProof textProof) {
        WebTextProof webTextProof = new WebTextProof();
        webTextProof.setProof(textProof.getProof());
        return webTextProof;
    }
}
