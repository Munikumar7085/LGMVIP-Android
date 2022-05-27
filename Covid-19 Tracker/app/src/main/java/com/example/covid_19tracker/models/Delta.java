package com.example.covid_19tracker.models;
//Stores the data fetched from the api
public class Delta {
    int active;
    int deceased;
    int recovered;
    public int getActive() {
        return active;
    }

    public int getDeceased() {
        return deceased;
    }

    public int getRecovered() {
        return recovered;
    }


    public Delta(int active, int deceased, int recovered)
    {
        this.active=active;
        this.deceased=deceased;
        this.recovered=recovered;
    }
}
