package com.example.ayush.finalapp;

public class MeetDetails
{
    public String date,time,place,shopper,negotiator,negoname;
    public boolean isAccepted;

    public String getNegoname() {
        return negoname;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setNegoname(String negoname) {
        this.negoname = negoname;
    }

    public void setNegotiator(String negotiator) {
        this.negotiator = negotiator;
    }

    public void setShopper(String shopper) {
        this.shopper = shopper;
    }

    public String getNegotiator() {
        return negotiator;
    }

    public String getShopper() {
        return shopper;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }
    MeetDetails(){}
    MeetDetails(String shopper,String place,String date,String time,String negotiator,boolean isAccepted,String negoname)
    {
        this.date=date;
        this.place=place;
        this.time=time;
        this.negoname=negoname;
        this.negotiator=negotiator;
        this.shopper=shopper;
        this.isAccepted=isAccepted;
    }
}
