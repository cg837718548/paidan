package com.cgsj.engineer;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class NewDataSet {
    public List<Table> getTable() {
        return this.Table;
    }

    public void setTable(List<Table> Table) {
        this.Table = Table;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Table")
    List<Table> Table;

    public Object getxmlns() {
        return this.xmlns;
    }

    public void setxmlns(Object xmlns) {
        this.xmlns = xmlns;
    }

    Object xmlns;

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }

    String text;
}
