package com.hoffrogge.lehreinheiten.uebungen.auto;

import com.hoffrogge.lehreinheiten.uebungen.Autobahn;

public class Auto {

    private int geschwindigkeit;
    private int maxTankInhalt;
    private String marke;

    public Auto() {
    }

    public Auto(int geschwindigkeit, int maxTankInhalt, String marke) {
        this.geschwindigkeit = geschwindigkeit;
        this.maxTankInhalt = maxTankInhalt;
        this.marke = marke;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void fahre() {
        System.out.println("Mein " + marke + " fährt " + geschwindigkeit + " km/h");
    }

    public double berechneVerbrauch(double gefahreneKilometer){
        double verbrauchProLiter = maxTankInhalt / gefahreneKilometer;
        double verbrauchProHundertLiter = verbrauchProLiter * 100;
        return verbrauchProHundertLiter;
    }

    public boolean isAutobahntauglich() {
        return this.geschwindigkeit >= Autobahn.AUTOBAHN_MINDESTGESCHWINDIGKEIT;
    }
}