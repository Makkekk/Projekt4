package Storage;

import Applikation.Model.Bestilling;
import Applikation.Model.Forestilling;
import Applikation.Model.Kunde;
import Applikation.Model.Plads;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Kunde> kunder;
    private static ArrayList<Forestilling> forstillinger;
    private static ArrayList<Plads> pladser;
    private static ArrayList<Bestilling> bestillinger;


    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static ArrayList<Forestilling> getForstillinger() {
        return new ArrayList<>(forstillinger);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger) ;
    }
    public static void addForestilling(Forestilling forestilling) {
        forstillinger.add(forestilling);
    }
    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }
    public static void addPlads(Plads plads) {
        pladser.add(plads);
    }
    public static void addBestilling(Forestilling bestilling) {
        bestillinger.add(bestilling);
    }

}
