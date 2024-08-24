package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfilePage {
    private VBox view;

    public ProfilePage(Stage primaryStage, String username) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label profileLabel = new Label("Profile Page");
        Label nameLabel = new Label("Name: " + username);
        Label balanceLabel = new Label("Balance: $" + DatabaseHelper.getBalance(username));

        Button transferButton = new Button("Transfer Funds");
        transferButton.setOnAction(e -> {
            TransferPage transferPage = new TransferPage(primaryStage, username);
            primaryStage.getScene().setRoot(transferPage.getView());
        });

        Button statementButton = new Button("Account Statement");
        statementButton.setOnAction(e -> {
            StatementPage statementPage = new StatementPage(primaryStage, username);
            primaryStage.getScene().setRoot(statementPage.getView());
        });

        view.getChildren().addAll(profileLabel, nameLabel, balanceLabel, transferButton, statementButton);
    }

    public VBox getView() {
        return view;
    }
}
