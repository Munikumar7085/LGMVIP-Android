package com.example.covid_19tracker.models;
//Stores the data fetched from the api
public class Model {

    public Model(int active, int confirmed, int deceased, int recovered,String location) {
        this.active = active;
        this.confirmed = confirmed;
        this.deceased = deceased;
        this.recovered = recovered;
        this.location=location;
    }

   public int active;
    public int confirmed;
   public int deceased;
   public int recovered;
   public String location;





}
