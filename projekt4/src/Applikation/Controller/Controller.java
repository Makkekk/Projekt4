package Applikation.Controller;

import Applikation.Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate Slutdato) {
        Forestilling forestilling = new Forestilling(navn, startDato, Slutdato);
        Storage.addForestilling(forestilling);
        return forestilling;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForstillinger();
    }


    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
        return kunde;
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
        return plads;

    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }


    public static void addKunde(Kunde newKunde) {
    }

    public static Bestilling opretBestilling(Kunde kunde, Forestilling forestilling, LocalDate dato) {
        Bestilling bestilling = new Bestilling(dato, kunde, forestilling);
    return bestilling;
    }

}



