package com.cgsj.engineer.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GetDjListPageResponse {
    public GetDjListPageResult getGetDjListPageResult() {
        return this.GetDjListPageResult;
    }

    public void setGetDjListPageResult(GetDjListPageResult GetDjListPageResult) {
        this.GetDjListPageResult = GetDjListPageResult;
    }

    @JacksonXmlProperty
    GetDjListPageResult GetDjListPageResult;

    public String getxmlns() {
        return this.xmlns;
    }

    public void setxmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    String xmlns;

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }

    String text;
}
