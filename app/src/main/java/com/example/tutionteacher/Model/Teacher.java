package com.example.tutionteacher.Model;

import com.google.gson.annotations.SerializedName;

public class Teacher  {


    @SerializedName("Name")
    String name;

    @SerializedName("Subject")
    String subject;

    @SerializedName("Fees")
    String fees;

    Double lat;

    @SerializedName("long")
    Double longi;







    public Teacher(String name, String subject, String fees, Double lat, Double longi) {
        this.name = name;
        this.subject = subject;
        this.fees = fees;
        this.lat = lat;
        this.longi = longi;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getFees() {
        return fees;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLongi() {
        return longi;
    }

}