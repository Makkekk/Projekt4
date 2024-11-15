package Applikation.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private ArrayList<Plads> Pladser;
    private Forestilling forestilling;

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {

        this.kunde = kunde;
        this.forestilling = forestilling;
        this.dato = dato;
        this.Pladser = new ArrayList<>();
        kunde.addBestilling(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }
}
