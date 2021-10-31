package com.cgsj.pojos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "NewDataSet")
public class NewDataSet {
    @JacksonXmlProperty(localName = "Table")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Engineer> engineers;

    public NewDataSet(List<Engineer> engineers) {
        this.engineers = engineers;
    }

    public List<Engineer> getEngineers() {
        return engineers;
    }

    public NewDataSet setEngineers(List<Engineer> engineers) {
        this.engineers = engineers;
        return this;
    }

    public NewDataSet() {
    }
}
