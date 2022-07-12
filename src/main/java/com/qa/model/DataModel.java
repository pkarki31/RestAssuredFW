package com.qa.model;

public class DataModel {




    private  String date;
    private  String areaName;
    private  String areaCode;
    private  String confirmedRate;
    private  String latestBy;
    private  String confirmed;
    private  String deathNew;
    private  String death;
    private  String deathRate;

    public DataModel (){

    }

    public DataModel(String date, String areaName, String areaCode, String confirmedRate, String latestBy, String confirmed, String deathNew, String death, String deathRate) {
        this.date = date;
        this.areaName = areaName;
        this.areaCode = areaCode;
        this.confirmedRate = confirmedRate;
        this.latestBy = latestBy;
        this.confirmed = confirmed;
        this.deathNew = deathNew;
        this.death = death;
        this.deathRate = deathRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getConfirmedRate() {
        return confirmedRate;
    }

    public void setConfirmedRate(String confirmedRate) {
        this.confirmedRate = confirmedRate;
    }

    public String getLatestBy() {
        return latestBy;
    }

    public void setLatestBy(String latestBy) {
        this.latestBy = latestBy;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeathNew() {
        return deathNew;
    }

    public void setDeathNew(String deathNew) {
        this.deathNew = deathNew;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(String deathRate) {
        this.deathRate = deathRate;
    }



}
