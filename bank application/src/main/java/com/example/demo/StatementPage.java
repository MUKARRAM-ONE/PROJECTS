package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatementPage {
    private VBox view;

    public StatementPage(Stage primaryStage, String username) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label statementLabel = new Label("Account Statement");
        Label balanceLabel = new Label("Balance: $" + DatabaseHelper.getBalance(username));

        // Add more details as needed

        view.getChildren().addAll(statementLabel, balanceLabel);
    }

    public VBox getView() {
        return view;
    }
}
