package Applikation.Controller;

import Applikation.Model.*;
import Storage.Storage;

import java.time.LocalDate;

public class Controller {

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate Slutdato) {
        Forestilling forestilling = new Forestilling(navn, startDato, Slutdato);
        Storage.addForestilling(forestilling);
        return forestilling;
    }
    public static  Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn,mobil);
        Storage.addKunde(kunde);
        return kunde;
    }
    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række,nr, pris,pladsType);
        return plads;
    }

}
