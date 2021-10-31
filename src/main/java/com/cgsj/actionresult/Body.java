package com.cgsj.actionresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Body {
    public DoTransActionResponse getDoTransActionResponse() {
        return this.DoTransActionResponse;
    }

    public void setDoTransActionResponse(DoTransActionResponse DoTransActionResponse) {
        this.DoTransActionResponse = DoTransActionResponse;
    }

    @JacksonXmlProperty
    DoTransActionResponse DoTransActionResponse;
}
