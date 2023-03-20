package com.hoffrogge.lehreinheiten.lehreinheit02.klassenstruktur;

public class StrukturEinerKlasse {

    private int zahlVariable;

    public StrukturEinerKlasse() {
    }

    public int getZahlVariable() {
        return zahlVariable;
    }

    public void setZahlVariable(int neueZahl) {
        this.zahlVariable = neueZahl;
    }

    public int countDown() {

        if (zahlVariable > 0) {
            zahlVariable = zahlVariable - 1;
            System.out.println("Countdown: " + zahlVariable);

            return zahlVariable;
        }

        System.out.println("Countdown beendet");

        return zahlVariable;
    }
}