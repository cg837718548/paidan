package com.cgsj.workorder;

public class element {
	public String getname() { 
		 return this.name; } 
	public void setname(String name) { 
		 this.name = name; } 
	String name;
	public String gettype() { 
		 return this.type; } 
	public void settype(String type) { 
		 this.type = type; } 
	String type;
	public int getminOccurs() { 
		 return this.minOccurs; } 
	public void setminOccurs(int minOccurs) { 
		 this.minOccurs = minOccurs; } 
	int minOccurs;
	public complexType getcomplexType() { 
		 return this.complexType; } 
	public void setcomplexType(complexType complexType) { 
		 this.complexType = complexType; } 
	complexType complexType;
	public boolean getIsDataSet() { 
		 return this.IsDataSet; } 
	public void setIsDataSet(boolean IsDataSet) { 
		 this.IsDataSet = IsDataSet; } 
	boolean IsDataSet;
	public Object getLocale() { 
		 return this.Locale; } 
	public void setLocale(Object Locale) { 
		 this.Locale = Locale; } 
	Object Locale;
}
