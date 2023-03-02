package com.example.project;

public class Word {


    private String JpWord;
    private String Hurigana;
    private String Mean;

    public Word(){
        this.JpWord= JpWord;
        this.Hurigana= Hurigana;
        this.Mean = Mean;
    }


    public String getJpWord() {
        return JpWord;
    }

    public void setJpWord(String jpword) {
        this.JpWord = jpword;
    }

    public String getHurigana() {
        return Hurigana;
    }

    public void setHurigana(String hurigana) {
        this.Hurigana = hurigana;
    }

    public String getMean() {
        return Mean;
    }

    public void setMean(String mean) {
        this.Mean = mean;
    }
}


