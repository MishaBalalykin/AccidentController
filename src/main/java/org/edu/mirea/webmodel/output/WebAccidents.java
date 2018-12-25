package org.edu.mirea.webmodel.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mr.balalykin on 25.12.2018.
 */
public class WebAccidents implements Serializable{
    private List<WebAccident> webAccidents;

    public List<WebAccident> getWebAccidents() {
        return webAccidents;
    }

    public void setWebAccidents(List<WebAccident> webAccidents) {
        this.webAccidents = webAccidents;
    }
}
