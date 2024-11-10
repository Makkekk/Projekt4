package Gui;

import Applikation.Controller.Controller;
import Applikation.Model.*;
import Storage.Storage;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        // testPrint();
        Application.launch(StartWindow.class);
    }

    public static void initStorage() {
        //Forestillinger
        Forestilling evita = Controller.createForestilling("Evita", LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 20));
        Forestilling lykkePer = Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 10, 30));
        Forestilling chess = Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        //Kunder
        Kunde andersHansen = Controller.createKunde("Anders Hansen", "11223344");
        Kunde peterJensen = Controller.createKunde("Peter Jensen", "12345678");
        Kunde nielsMadsen = Controller.createKunde("Niels Madsen", "12341234");

        //
        Bestilling andersBestiling = Controller.opretBestilling(andersHansen,evita,LocalDate.now());


        // Pladser
        for (int række = 1; række <= 15; række++) {
            for (int plads = 1; plads <= 20; plads++) {
                //Specialle pladser - Kørestol (K) Og ekstra benplads (EB)

                if (række == 10 && plads >= 8 && plads <= 12) {
                    Controller.createPlads(række, plads, 500, PladsType.KØRESTOL);
                } else if (række == 11 && plads >= 8 && plads <= 12) {
                    Controller.createPlads(række,plads,500,PladsType.EKSTRABEN);
                }
else {
                    // Green seats
                    if ((række >= 1 && række <= 5 && (plads == 1 || plads == 2)) ||  // Grøn: række 1-5, plads 1-2
                            (række == 5 && (plads == 19 || plads == 20)) ||               // Grøn: række 5, plads 19-20
                            (række >= 6 && række <= 10 && plads >= 3 && plads <= 18)) {   // grøn: række 6-10, plads 3-18
                        Controller.createPlads(række, plads, 450, PladsType.STANDARD);
                    }
                    // Yellow seats
                    else if (række >= 1 && række <= 5 && plads >= 3 && plads <= 18) {  // Gul: række 1-5, plads 3-18
                        Controller.createPlads(række, plads, 500, PladsType.STANDARD);
                    }
                    // Blue seats
                    else if ((række >= 6 && række <= 15 && (plads == 1 || plads == 2)) ||  // blå: række 6-15, plads 1-2
                            (række >= 6 && række <= 15 && (plads == 19 || plads == 20)) || // blå: række 6-15, plads 19-20
                            (række >= 11 && række <= 15 && plads >= 3 && plads <= 18)) {   // blå: række 11-15, plads 3-18
                        Controller.createPlads(række, plads, 400, PladsType.STANDARD);
                    }
                }

                }
            }
        }

/*
    public static void testPrint() {
        System.out.println("Forestillinger:");
        for (Forestilling forestilling : Storage.getForstillinger()) {
            System.out.println(forestilling);
        }

        System.out.println("\nKunder:");
        for (Kunde kunde : Storage.getKunder()) {
            System.out.println(kunde);
        }

        System.out.println("\nPladser:");
        for (Plads plads : Storage.getPladser()) {
            System.out.println(plads);

        }
    }*/
}