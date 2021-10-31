package com.cgsj.engineer;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Body {
	public GetDjListPageResponse getGetDjListPageResponse() { 
		 return this.GetDjListPageResponse; } 
	public void setGetDjListPageResponse(GetDjListPageResponse GetDjListPageResponse) { 
		 this.GetDjListPageResponse = GetDjListPageResponse; }
    @JacksonXmlProperty
	GetDjListPageResponse GetDjListPageResponse;
}
