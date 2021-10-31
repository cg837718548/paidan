package com.cgsj.workorder;

public class choice {
	public element getelement() { 
		 return this.element; } 
	public void setelement(element element) { 
		 this.element = element; } 
	element element;
	public int getminOccurs() { 
		 return this.minOccurs; } 
	public void setminOccurs(int minOccurs) { 
		 this.minOccurs = minOccurs; } 
	int minOccurs;
	public String getmaxOccurs() { 
		 return this.maxOccurs; } 
	public void setmaxOccurs(String maxOccurs) { 
		 this.maxOccurs = maxOccurs; } 
	String maxOccurs;
}
