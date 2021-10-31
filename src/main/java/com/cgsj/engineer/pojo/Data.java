package com.cgsj.engineer.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Data {
	public schema getschema() { 
		 return this.schema; } 
	public void setschema(schema schema) { 
		 this.schema = schema; } 
	schema schema;
	public diffgram getdiffgram() { 
		 return this.diffgram; } 
	public void setdiffgram(diffgram diffgram) { 
		 this.diffgram = diffgram; }
    @JacksonXmlProperty
	diffgram diffgram;
}
