package com.cgsj.workorder.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class diffgram {
    public NewDataSet getNewDataSet() {
        return this.NewDataSet;
    }

    public void setNewDataSet(NewDataSet NewDataSet) {
        this.NewDataSet = NewDataSet;
    }


    @JacksonXmlProperty
    NewDataSet NewDataSet;

    public String getdiffgr() {
        return this.diffgr;
    }

    public void setdiffgr(String diffgr) {
        this.diffgr = diffgr;
    }

    String diffgr;

    public String getmsdata() {
        return this.msdata;
    }

    public void setmsdata(String msdata) {
        this.msdata = msdata;
    }

    String msdata;

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }

    String text;
}
