package Gui;

import Applikation.Controller.Controller;
import Applikation.Model.Forestilling;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class ForestillingWindow extends Stage {
    private Forestilling forestilling;
    private TextField navnTextField;
    private TextField startDatoTextField;
    private TextField slutDatoTextField;
    private Label errorLabel;
    private LocalDate slutDato;
    private LocalDate startDato;

    public ForestillingWindow(String title, Forestilling forestilling) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.forestilling = forestilling;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public ForestillingWindow(String title) {
        this(title, null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        pane.add(new Label("Name"), 0, 0);

        navnTextField = new TextField();
        pane.add(navnTextField, 0, 1);
        navnTextField.setPrefWidth(200);

        pane.add(new Label("Start dato"), 0, 2);
        pane.add(new Label("Slut dato"), 0, 4);

        startDatoTextField = new TextField();
        pane.add(startDatoTextField, 0, 3);
        slutDatoTextField = new TextField();
        pane.add(slutDatoTextField, 0, 5);

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");
        pane.add(errorLabel, 0, 6);

        Button cancelButton = new Button("Annuller");
        pane.add(cancelButton, 0, 7);
        GridPane.setHalignment(cancelButton, HPos.LEFT);
        cancelButton.setOnAction(event -> this.cancelAction());

        Button okButton = new Button("OK");
        pane.add(okButton, 0, 7);
        GridPane.setHalignment(okButton, HPos.RIGHT);
        okButton.setOnAction(event -> this.okAction());
    }

        private void cancelAction () {
            this.hide();
        }

        private void okAction () {
            String navn = navnTextField.getText().trim();
            String startDatoStr = startDatoTextField.getText().trim();
            String slutDatoStr = slutDatoTextField.getText().trim();


            if (navn.isEmpty()) {
                errorLabel.setText("Navn skal udfyldes"); // "Name must be filled in"
                return;
            }
            // Try to parse the start date
            try {
                startDato = LocalDate.parse(startDatoStr); // Assumes input is in ISO format (yyyy-MM-dd)
            } catch (Exception e) {
                errorLabel.setText("Ugyldigt start dato format (brug yyyy-MM-dd)"); // "Invalid start date format"
                return;
            }
            try {
                slutDato = LocalDate.parse(slutDatoStr);
            } catch (Exception e) {
                errorLabel.setText("Ugyldigt slut dato format (brug yyyy-MM-dd)"); // "Invalid end date format"
                return;
            }

            // Try to parse the end date
            if (slutDato.isBefore(startDato)) {
                errorLabel.setText("Slut dato skal være efter start dato");
                return;
            }

            try {
                if (this.forestilling != null) {
                    this.forestilling.setNavn(navn);
                    this.forestilling.setStartDato(startDato);
                    this.forestilling.setSlutDato(slutDato);
                } else {
                    // Create new forestilling and add it to Controller
                    this.forestilling = Controller.createForestilling(navn, startDato, slutDato);
                }
                this.close(); // Close the window after successful creation or update
            } catch (Exception e) {
                errorLabel.setText("Fejl under oprettelse/opdatering af forestilling");
            }
        }
    }

