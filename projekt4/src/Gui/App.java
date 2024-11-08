package Gui;

import Applikation.Controller.Controller;
import Applikation.Model.Forestilling;
import Applikation.Model.Kunde;
import Applikation.Model.Plads;
import Applikation.Model.PladsType;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
    }
    public static void initStorage() {
        //Forestillinger
        Forestilling evita = Controller.createForestilling("Evita", LocalDate.of(2024,8,10), LocalDate.of(2023,8,20));
        Forestilling lykkePer = Controller.createForestilling("Lykke Per", LocalDate.of(2023,9,1), LocalDate.of(2023,8,30));
        Forestilling chess = Controller.createForestilling("Chess", LocalDate.of(2023,8,21),LocalDate.of(2023,8,30));

        //Kunder
        Kunde andersHansen = Controller.createKunde("Anders Hansen", "11223344");
        Kunde peterJensen = Controller.createKunde("Peter Jensen","12345678");
        Kunde nielsMadsen = Controller.createKunde("Niels Madsen","12341234");


        for (int række = 1; række < 15 ; række++) {
            for (int plads = 1; plads < 20; plads++){
                if(række < 6){
                    if(plads < 19 && plads < 2) {
                        Controller.createPlads(række, plads, 500, PladsType.STANDARD);

                    }
                    if (række == 10 && plads >=8 && plads <= 12) {
                        Controller.createPlads(række,plads,2,Pladstype.);

                    }
                }

                Plads pladsgu = Controller.createPlads(række, plads,500, PladsType.STANDARD);


            }

        }
    }

}
