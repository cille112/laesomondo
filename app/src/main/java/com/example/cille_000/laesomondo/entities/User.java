package com.example.cille_000.laesomondo.entities;


public class  User {

    private String name;
    private String date;
    private int avatar;
    private int lix;
    private int speed;
    private int xp;
    private int textSize;

    public User(String name, String date, int avatar, int textSize){
        this.name = name;
        this.date = date;
        this.avatar = avatar;
        this.textSize = textSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getLix() {
        return lix;
    }

    public void setLix(int lix) {
        this.lix = lix;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int xp) {
        this.xp = this.xp+xp;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}
