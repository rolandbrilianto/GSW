package com.example.goldenstatewarrior;

public class UserHelperClass {
    String id, versus, tanggal, time, finalScore;

    public UserHelperClass() {
    }

    public UserHelperClass(String Id, String Versus, String Tanggal, String Time, String FinalScore) {
        id = Id;
        versus = Versus;
        tanggal = Tanggal;
        time = Time;
        finalScore = FinalScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String Versus) {
        this.versus = Versus;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.tanggal = Tanggal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String Time) {
        this.time = Time;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String FinalScore) {
        this.finalScore = FinalScore;
    }
}
