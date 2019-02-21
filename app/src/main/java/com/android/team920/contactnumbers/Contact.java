package com.android.team920.contactnumbers;

public class Contact {

    protected String name,suggName,number;
    protected boolean like = false;

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

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
