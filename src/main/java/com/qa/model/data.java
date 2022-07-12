package com.qa.model;


import javax.xml.crypto.Data;
import java.util.List;

public class data {

    private int length;
    private int maxPageLimit;
    private int totalRecords;
    private List<DataModel> data;

    public data (){


    }


    public data(int length, int maxPageLimit, int totalRecords, List<DataModel> data) {
        this.length = length;
        this.maxPageLimit = maxPageLimit;
        this.totalRecords = totalRecords;
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMaxPageLimit() {
        return maxPageLimit;
    }

    public void setMaxPageLimit(int maxPageLimit) {
        this.maxPageLimit = maxPageLimit;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }
}
