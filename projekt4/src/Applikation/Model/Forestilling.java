package Applikation.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger;


    public Forestilling(String navn, LocalDate startDato, LocalDate slutdato) {

        this.navn = navn;
        this.startDato = this.startDato;
        this.slutDato = slutDato;
    }
    public String getNavn() {
        return navn;
    }
    public void addBetaling(LocalDate dato, Kunde kunde) {
        Bestilling bestilling = new Bestilling(dato, kunde, this);
    }
}

