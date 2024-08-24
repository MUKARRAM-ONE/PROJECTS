package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TransferPage {
    private VBox view;

    public TransferPage(Stage primaryStage, String username) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label transferLabel = new Label("Transfer Funds");
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient Username");
        TextField amountField = new TextField();
        amountField.setPromptText("Amount");
        Button transferButton = new Button("Transfer");

        transferButton.setOnAction(e -> {
            String recipient = recipientField.getText();
            double amount = Double.parseDouble(amountField.getText());
            if (DatabaseHelper.updateBalance(username, -amount) && DatabaseHelper.updateBalance(recipient, amount)) {
                ProfilePage profilePage = new ProfilePage(primaryStage, username);
                primaryStage.getScene().setRoot(profilePage.getView());
            } else {
                // Show error message
                Label errorLabel = new Label("Transfer failed");
                view.getChildren().add(errorLabel);
            }
        });

        view.getChildren().addAll(transferLabel, recipientField, amountField, transferButton);
    }

    public VBox getView() {
        return view;
    }
}
