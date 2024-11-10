package Storage;

import Applikation.Model.Bestilling;
import Applikation.Model.Forestilling;
import Applikation.Model.Kunde;
import Applikation.Model.Plads;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();
    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static ArrayList<Forestilling> getForstillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }
    public static void addForestilling(Forestilling forestilling) {
        forestillinger.add(forestilling);
    }
    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }
    public static void addPlads(Plads plads) {
        pladser.add(plads);
    }
    public static void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public static void removeKunde(Kunde kunde) {
        kunder.remove(kunde);

    }
    public static void removeForestilling(Forestilling forestilling) {
        forestillinger.remove(forestilling);

    }
    public static void removeBestilling(Bestilling bestilling) {
        bestillinger.remove(bestilling);
    }


}
