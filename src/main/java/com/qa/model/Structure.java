package com.qa.model;

public class Structure {

     private String date;
     private String areaName;
     private String areaCode;
     private String confirmedRate;
     private String confirmedNew;
     private String confirmed;
     private String deathNew;
     private String death;
     private String deathRate;
     private String latestBy;

     public Structure(){}


    public Structure(String date, String areaName, String areaCode, String confirmedRate, String confirmedNew, String confirmed, String deathNew, String death, String deathRate, String latestBy) {
        this.date = date;
        this.areaName = areaName;
        this.areaCode = areaCode;
        this.confirmedRate = confirmedRate;
        this.confirmedNew = confirmedNew;
        this.confirmed = confirmed;
        this.deathNew = deathNew;
        this.death = death;
        this.deathRate = deathRate;
        this.latestBy = latestBy;
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

    public String getConfirmedNew() {
        return confirmedNew;
    }

    public void setConfirmedNew(String confirmedNew) {
        this.confirmedNew = confirmedNew;
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

    public String getLatestBy() {
        return latestBy;
    }

    public void setLatestBy(String latestBy) {
        this.latestBy = latestBy;
    }
}
