package org.edu.mirea.mapper;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.entity.MediaProof;
import org.edu.mirea.webmodel.output.WebAccident;
import org.edu.mirea.webmodel.output.WebAccidents;
import org.edu.mirea.webmodel.output.WebMediaProof;
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
    public WebAccidents map(List<Accident> accidents){
        WebAccidents webAccidents = new WebAccidents();
        List<WebAccident> listWebAccidents = new ArrayList<>();

        for (Accident accident : accidents) {
            listWebAccidents.add(map(accident));
        }
        webAccidents.setWebAccidents(listWebAccidents);
        return webAccidents;
    }

    private WebAccident map(Accident accident){
        WebAccident webAccident = new WebAccident();
        Set<MediaProof> mediaProofs = accident.getMediaProofs();
        Set<WebMediaProof> webMediaProofs = new HashSet<>();

        webAccident.setAccidentAddress(accident.getAccidentAddress());
        webAccident.setAccidentDate(accident.getAccidentDate());
        webAccident.setCreator(accident.getCreator());
        webAccident.setTextProof(accident.getTextProof());
        webMediaProofs.addAll(mediaProofs.stream().map(this::map).collect(Collectors.toList()));
        webAccident.setMediaProofs(webMediaProofs);

        return webAccident;
    }

    private WebMediaProof map(MediaProof mediaProof){
        WebMediaProof webMediaProof = new WebMediaProof();

        webMediaProof.setMediaProof(mediaProof.getProof());

        return webMediaProof;
    }
}
