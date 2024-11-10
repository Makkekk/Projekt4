package Gui;

import Applikation.Controller.Controller;
import Applikation.Model.Kunde;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KundeWindow extends Stage {
    private TextField kundeNavnTextField;
    private TextField kundeMobilTextField;

    public KundeWindow(String title) {
        // Set the title of the window
        this.setTitle(title);

        // Create a layout (GridPane for organizing fields)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);

        // Add labels and text fields for Kunde details
        Label kundeNavnLabel = new Label("Kunde navn:");
        grid.add(kundeNavnLabel, 0, 0);

        kundeNavnTextField = new TextField();
        grid.add(kundeNavnTextField, 1, 0);

        Label kundeMobilLabel = new Label("Kunde mobil:");
        grid.add(kundeMobilLabel, 0, 1);

        kundeMobilTextField = new TextField();
        grid.add(kundeMobilTextField, 1, 1);

        // Create buttons
        Button saveButton = new Button("Gem");
        Button cancelButton = new Button("Annuller");

        saveButton.setOnAction(event -> {
            // Get the input values from the text fields
            String navn = kundeNavnTextField.getText();
            String mobil = kundeMobilTextField.getText();

            // Check if all fields are filled
            if (navn.isEmpty() || mobil.isEmpty()) {
                // Show an alert if the fields are not complete
                Alert alert = new Alert(Alert.AlertType.WARNING, "Alle felter skal udfyldes!", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Create a new Kunde object and add it using the Controller
                Kunde newKunde = new Kunde(navn, mobil);
                Controller.addKunde(newKunde);

                // Close the window after adding the Kunde
                this.close();
            }
        });

        // Handle cancel action
        cancelButton.setOnAction(event -> {
            // Close the window without doing anything
            this.close();
        });

        // Add the buttons to the grid
        grid.add(saveButton, 0, 2);
        grid.add(cancelButton, 1, 2);

        // Create a Scene and set it on the Stage (window)
        Scene scene = new Scene(grid, 300, 200);
        this.setScene(scene);
    }

}