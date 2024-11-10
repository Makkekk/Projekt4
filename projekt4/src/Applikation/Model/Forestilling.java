package Applikation.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>(); // Aggregated bestilling objects.
    private ArrayList<Forestilling> forestillinger =  new ArrayList<>();


    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {

        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;

    }
    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }
    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
}


    @Override
    public String toString() {
        return "Forestilling{" +
                "navn='" + navn + '\'' +
                ", startDato=" + startDato +
                ", slutDato=" + slutDato +
                ", bestillinger=" + bestillinger +
                '}';
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }


    }


