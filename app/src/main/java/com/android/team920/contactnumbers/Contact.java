package com.android.team920.contactnumbers;

public class Contact {

    protected String name,suggName,number;

    public Contact(String name,String number){
        this.name=name;
        this.number=number;
    }

    public Contact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuggName() {
        return suggName;
    }

    public void setSuggName(String suggName) {
        this.suggName = suggName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
