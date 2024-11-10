package Gui;

import Applikation.Controller.Controller;
import Applikation.Model.Bestilling;
import Applikation.Model.Forestilling;
import Applikation.Model.Kunde;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class ForestillingPane extends GridPane {
    private TextField forestillingNavnTextField;
    private TextField kundeNavnTextField;
    private TextField startDatoTextfield;
    private TextField slutDatoTextField;
    private TextField kundeMobilTextField;
    private ListView<Forestilling> forestillingListView;
    private ListView<Kunde> kundeListView;
    private TextArea kundeInfoTextArea;


    public ForestillingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        this.add(new Label("Forestillinger"), 0, 0, 1, 1);

        forestillingListView = new ListView<>();
        this.add(forestillingListView, 0, 1, 1, 3);
        forestillingListView.setPrefWidth(300);
        forestillingListView.setPrefHeight(200);

        kundeListView = new ListView<>();
        this.add(kundeListView, 2, 1, 1, 3);
        kundeListView.setPrefWidth(300);
        kundeListView.setPrefHeight(200);

        updateForestillingListView();
        updateKundeListView();

        this.add(new Label("Kunder"), 2, 0, 1, 1);

        kundeInfoTextArea = new TextArea();
        this.add(kundeInfoTextArea, 2, 1, 1, 3);
        kundeInfoTextArea.setPrefWidth(300);
        kundeInfoTextArea.setPrefHeight(200);
        kundeInfoTextArea.setEditable(false);

        Label forestillingNavnLabel = new Label("Forestillingens navn");
        this.add(forestillingNavnLabel, 0, 4, 1, 1);

        Label startDatoLabel = new Label("Start dato");
        this.add(startDatoLabel, 0, 5, 1, 1);

        Label slutDatoLabel = new Label("Slut Dato");
        this.add(slutDatoLabel, 0, 6, 1, 1);

        Label kundeNavnLabel = new Label("Kunde navn");
        this.add(kundeNavnLabel, 2, 4, 1, 1);

        Label kundeMobilLabel = new Label("Kunde mobil");
        this.add(kundeMobilLabel, 2, 5, 1, 1);

        forestillingNavnTextField = new TextField();
        this.add(forestillingNavnTextField, 1, 4, 1, 1);
        forestillingNavnTextField.setEditable(false);

        startDatoTextfield = new TextField();
        this.add(startDatoTextfield, 1, 5, 1, 1);
        startDatoTextfield.setEditable(false);

        slutDatoTextField = new TextField();
        this.add(slutDatoTextField, 1, 6, 1, 1);
        slutDatoTextField.setEditable(false);

        kundeNavnTextField = new TextField();
        this.add(kundeNavnTextField, 3, 4, 1, 1);
        kundeNavnTextField.setEditable(false);

        kundeMobilTextField = new TextField();
        this.add(kundeMobilTextField, 3, 5, 1, 1);
        kundeMobilTextField.setEditable(false);

        setAlignment(Pos.CENTER_LEFT);


        HBox hboxButton = new HBox(40);
        this.add(hboxButton, 0, 7, 3, 1);
        hboxButton.setPadding(new Insets(10, 0, 0, 0));
        hboxButton.setAlignment(Pos.BASELINE_CENTER);

        Button opretForestilling = new Button("Opret forestilling");
        hboxButton.getChildren().add(opretForestilling);
        opretForestilling.setOnAction(event -> this.opretForestillingAction());

        Button opretKunde = new Button("Opret kunde");
        hboxButton.getChildren().add(opretKunde);
        opretKunde.setOnAction(event -> this.opretKunde());


        //Listners
        forestillingListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Update text fields when a forestilling is selected
                updateForestillingDetails(newValue);
            }
        });

        // Select the first item if available
        if (!forestillingListView.getItems().isEmpty()) {
            forestillingListView.getSelectionModel().select(0);
        }
        if (!kundeListView.getItems().isEmpty()) {
            kundeListView.getSelectionModel().select(0);

        }
    }


    private void updateForestillingListView() {
        ObservableList<Forestilling> forestillingList = FXCollections.observableArrayList(Controller.getForestillinger());
        forestillingListView.setItems(forestillingList);
    }


    private void updateKundeListView() {
        ObservableList<Kunde> kundeList = FXCollections.observableArrayList(Controller.getKunder());
        kundeListView.setItems(kundeList);
    }


    private void opretForestillingAction() {
        new ForestillingWindow("Opret forestilling").showAndWait();
        updateForestillingListView();
        int index = forestillingListView.getItems().size() - 1;
        forestillingListView.getSelectionModel().select(index);
    }

    private void opretKunde() {
        new KundeWindow("Opret kunde").showAndWait();
        updateKundeListView();
        int index = kundeListView.getItems().size() - 1;
        kundeListView.getSelectionModel().select(index);
    }

    private void updateForestillingDetails(Forestilling forestilling) {
        // Populate the text fields with data from the selected forestilling
        forestillingNavnTextField.setText(forestilling.getNavn());
        startDatoTextfield.setText(forestilling.getStartDato().toString());
        slutDatoTextField.setText(forestilling.getSlutDato().toString());

        kundeInfoTextArea.clear();

        StringBuilder kundeInfo = new StringBuilder("");
        if (forestilling.getBestillinger() != null && !forestilling.getBestillinger().isEmpty()) {
            for (Bestilling bestilling : forestilling.getBestillinger()) {
                Kunde kunde = bestilling.getKunde(); // Get the Kunde associated with this Bestilling
                kundeInfo.append("Kunde: ").append(kunde.getKundeNavn()).append("\n")
                        .append("Mobil: ").append(kunde.getKundeMobil()).append("\n")
                        .append("Dato: ").append(bestilling.getDato()).append("\n\n");
            }
        } else {
            // If no bestillinger, add a message saying so
            kundeInfo.append("Ingen bestillinger for denne forestilling.\n");

            kundeInfoTextArea.setText(kundeInfo.toString());

            ObservableList<Kunde> relatedKundeList = FXCollections.observableArrayList();
            for (Bestilling bestilling : forestilling.getBestillinger()) {
                relatedKundeList.add(bestilling.getKunde());
            }
            kundeListView.setItems(relatedKundeList);
        }


    }
}


