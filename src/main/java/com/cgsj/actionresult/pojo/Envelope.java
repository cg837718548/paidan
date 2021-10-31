package com.cgsj.actionresult.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Envelope {
    public Body getBody() {
        return this.Body;
    }

    public void setBody(Body Body) {
        this.Body = Body;
    }

    @JacksonXmlProperty
    Body Body;

    public String gets() {
        return this.s;
    }

    public void sets(String s) {
        this.s = s;
    }

    String s;

    public boolean gettext() {
        return this.text;
    }

    public void settext(boolean text) {
        this.text = text;
    }

    boolean text;


    public Boolean getResult(){
        return this.getBody().getDoTransActionResponse().getDoTransActionResult();
    }
}
