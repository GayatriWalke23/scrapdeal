package com.example.scrapdeal;

public class Buyer_details {
    private String Name;
    private String Description;
    private String Rate;
    private String Waste;

    // creating constructor for our variables.
    public Buyer_details(String Name, String Description, String Rate, String Waste){
        this.Description = Description;
        this.Name = Name;
        this.Rate= Rate;
        this.Waste= Waste;
    }

    // creating getter and setter methods.
    public String Name() {
        return Name;
    }

    public void Name(String Name) {
        this.Name = Name;
    }

    public String Description() {
        return Description;
    }

    public void Description(String Description) {
        this.Description = Description;
    }
    public String Rate() {
        return Rate;
    }

    public void Rate(String Rate) {
        this.Rate = Rate;
    }

    public String Waste() {
        return Waste;
    }

    public void Waste(String Waste) {
        this.Waste = Waste;
    }
}

