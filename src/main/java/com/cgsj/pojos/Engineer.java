package com.cgsj.pojos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Engineer {
    @JacksonXmlProperty(localName = "GCSXM")
    private String gcsxm;
    @JacksonXmlProperty(localName = "GCSBH")
    private String gcsbh;

    public String getGcsxm() {
        return gcsxm;
    }

    public Engineer setGcsxm(String gcsxm) {
        this.gcsxm = gcsxm;
        return this;
    }

    public String getGcsbh() {
        return gcsbh;
    }

    public Engineer setGcsbh(String gcsbh) {
        this.gcsbh = gcsbh;
        return this;
    }

    public Engineer(String gcsxm, String gcsbh) {
        this.gcsxm = gcsxm;
        this.gcsbh = gcsbh;
    }

    public Engineer() {
    }
}


