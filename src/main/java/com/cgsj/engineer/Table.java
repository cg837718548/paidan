package com.cgsj.engineer;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Table {
    public int get_ID() {
        return this._ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    @JacksonXmlProperty
    int _ID;

    public String get_STATE() {
        return this._STATE;
    }

    public void set_STATE(String _STATE) {
        this._STATE = _STATE;
    }

    String _STATE;

    public int get_OWNERID() {
        return this._OWNERID;
    }

    public void set_OWNERID(int _OWNERID) {
        this._OWNERID = _OWNERID;
    }

    int _OWNERID;

    public int get_TENANTID() {
        return this._TENANTID;
    }

    public void set_TENANTID(int _TENANTID) {
        this._TENANTID = _TENANTID;
    }

    int _TENANTID;

    public String getZZZT() {
        return this.ZZZT;
    }

    public void setZZZT(String ZZZT) {
        this.ZZZT = ZZZT;
    }

    String ZZZT;

    public int getFWDBH() {
        return this.FWDBH;
    }

    public void setFWDBH(int FWDBH) {
        this.FWDBH = FWDBH;
    }

    int FWDBH;

    public String getFWDMC() {
        return this.FWDMC;
    }

    public void setFWDMC(String FWDMC) {
        this.FWDMC = FWDMC;
    }

    String FWDMC;

    public String getGCSBH() {
        return this.GCSBH;
    }

    public void setGCSBH(String GCSBH) {
        this.GCSBH = GCSBH;
    }

    @JacksonXmlProperty
    String GCSBH;

    public String getGCSXM() {
        return this.GCSXM;
    }

    public void setGCSXM(String GCSXM) {
        this.GCSXM = GCSXM;
    }

    @JacksonXmlProperty
    String GCSXM;

    public String getXB() {
        return this.XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    String XB;

    public double getSJHM() {
        return this.SJHM;
    }

    public void setSJHM(double SJHM) {
        this.SJHM = SJHM;
    }

    double SJHM;

    public String getZPSHTGBZ() {
        return this.ZPSHTGBZ;
    }

    public void setZPSHTGBZ(String ZPSHTGBZ) {
        this.ZPSHTGBZ = ZPSHTGBZ;
    }

    String ZPSHTGBZ;

    public String getZPSCQRBZ() {
        return this.ZPSCQRBZ;
    }

    public void setZPSCQRBZ(String ZPSCQRBZ) {
        this.ZPSCQRBZ = ZPSCQRBZ;
    }

    String ZPSCQRBZ;

    public String getFZBZ() {
        return this.FZBZ;
    }

    public void setFZBZ(String FZBZ) {
        this.FZBZ = FZBZ;
    }

    String FZBZ;

    public String get_OWNERNAME() {
        return this._OWNERNAME;
    }

    public void set_OWNERNAME(String _OWNERNAME) {
        this._OWNERNAME = _OWNERNAME;
    }

    String _OWNERNAME;

    public int get_BUSINESSUNITID() {
        return this._BUSINESSUNITID;
    }

    public void set_BUSINESSUNITID(int _BUSINESSUNITID) {
        this._BUSINESSUNITID = _BUSINESSUNITID;
    }

    int _BUSINESSUNITID;

    public int getrowid() {
        return this.rowid;
    }

    public void setrowid(int rowid) {
        this.rowid = rowid;
    }

    int rowid;

    public String getid() {
        return this.id;
    }

    public void setid(String id) {
        this.id = id;
    }

    String id;

    public int getrowOrder() {
        return this.rowOrder;
    }

    public void setrowOrder(int rowOrder) {
        this.rowOrder = rowOrder;
    }

    int rowOrder;

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }

    String text;

    public Object getGZZZT() {
        return this.GZZZT;
    }

    public void setGZZZT(Object GZZZT) {
        this.GZZZT = GZZZT;
    }

    Object GZZZT;

    public Object getFJSM() {
        return this.FJSM;
    }

    public void setFJSM(Object FJSM) {
        this.FJSM = FJSM;
    }

    Object FJSM;
}
