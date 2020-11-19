package com.k.meuhesaplama;

public class dersModel {
    private String adi;
    private double vize;
    private double finalnotu;
    private double kredi;
    private double ortalama;
    private double gecmeNotu;
    private int sayi;




    public dersModel(){}

    public dersModel(String adi, double vize, double finalnotu, double kredi, double ortalama,double gecmeNotu,int sayi) {
        this.adi=adi;
        this.vize = vize;
        this.finalnotu = finalnotu;
        this.kredi = kredi;
        this.ortalama = ortalama;
        this.gecmeNotu=gecmeNotu;
        this.sayi=sayi;

    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public double getVize() {
        return vize;
    }

    public void setVize(double vize) {
        this.vize = vize;
    }

    public double getFinalnotu() {
        return finalnotu;
    }

    public void setFinalnotu(double finalnotu) {
        this.finalnotu = finalnotu;
    }

    public double getKredi() {
        return kredi;
    }

    public void setKredi(double kredi) {
        this.kredi = kredi;
    }

    public double getOrtalama() {
        return ortalama;
    }

    public void setOrtalama(double ortalama) {
        this.ortalama = ortalama;
    }

    public double getGecmeNotu() {
        return gecmeNotu;
    }

    public void setGecmeNotu(double gecmeNotu) {
        this.gecmeNotu = gecmeNotu;
    }

    public int getSayi() {
        return sayi;
    }

    public void setSayi(int sayi) {
        this.sayi = sayi;
    }
}
