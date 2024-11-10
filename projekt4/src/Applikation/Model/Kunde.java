package Applikation.Model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getKundeNavn() {
        return navn;
    }

    public String getKundeMobil() {
        return mobil;
    }

    public void addBestilling(Bestilling bestilling) {
        if(!bestillinger.contains(bestilling)){
            this.bestillinger.add(bestilling);
        }
    }


    @Override
    public String toString() {
        return "Kunde{" +
                "navn='" + navn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", bestillinger=" + bestillinger +
                '}';
    }


    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;

    }
}
