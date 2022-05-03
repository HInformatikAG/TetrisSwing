package com.hoffrogge.lehreinheiten.uebungen.auto;

public class AutoDemo {

    public static void main(String[] args) {

        Auto porsche = new Auto(180, 70, "Porsche");
        porsche.fahre();

        Auto trabi = new Auto(55,50, "Trabi");
        trabi.fahre();

        System.out.println(porsche.getMarke() + " ist autobahntauglich? "+porsche.isAutobahntauglich());
        System.out.println(trabi.getMarke() + " ist autobahntauglich? "+trabi.isAutobahntauglich());

        tuneTrabi(trabi);

        trabi.fahre();
        System.out.println(trabi.getMarke() + " ist autobahntauglich? "+trabi.isAutobahntauglich());

        System.out.println("Verbrauch meines "+porsche.getMarke() + " ist "+porsche.berechneVerbrauch(1000));
        System.out.println("Verbrauch meines "+trabi.getMarke() + " ist "+trabi.berechneVerbrauch(700));
    }

    private static void tuneTrabi(Auto trabi) {
        trabi.setGeschwindigkeit(120);
    }
}
