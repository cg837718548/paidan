package com.cgsj.actionresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DoTransActionResponse {
    public boolean getDoTransActionResult() {
        return this.DoTransActionResult;
    }

    public void setDoTransActionResult(boolean DoTransActionResult) {
        this.DoTransActionResult = DoTransActionResult;
    }

    @JacksonXmlProperty
    boolean DoTransActionResult;

    public String getxmlns() {
        return this.xmlns;
    }

    public void setxmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    String xmlns;

    public boolean gettext() {
        return this.text;
    }

    public void settext(boolean text) {
        this.text = text;
    }

    boolean text;
}
