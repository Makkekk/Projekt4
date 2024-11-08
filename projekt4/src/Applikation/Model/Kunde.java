package Applikation.Model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger;

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void addBestilling(Bestilling bestilling) {
        if(!bestillinger.contains(bestilling)){
            bestillinger.add(bestilling);
        }
    }
}
