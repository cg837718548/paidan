package com.cgsj.workorder.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GetDjListPageResult {
    public int getCode() {
        return this.Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    int Code;

    public Message getMessage() {
        return this.Message;
    }

    public void setMessage(Message Message) {
        this.Message = Message;
    }

    Message Message;

    public int getCount() {
        return this.Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    int Count;

    public Data getData() {
        return this.Data;
    }

    public void setData(Data Data) {
        this.Data = Data;
    }

    @JacksonXmlProperty
    Data Data;

    public String geta() {
        return this.a;
    }

    public void seta(String a) {
        this.a = a;
    }

    String a;

    public String geti() {
        return this.i;
    }

    public void seti(String i) {
        this.i = i;
    }

    String i;

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }

    String text;
}
