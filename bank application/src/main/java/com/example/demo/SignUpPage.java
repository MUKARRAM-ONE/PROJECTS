package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpPage {
    private VBox view;

    public SignUpPage(Stage primaryStage) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label signUpLabel = new Label("Sign Up");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button signUpButton = new Button("Sign Up");

        signUpButton.setOnAction(e -> {
            if (DatabaseHelper.createUser(usernameField.getText(), passwordField.getText())) {
                HomePage homePage = new HomePage(primaryStage);
                primaryStage.getScene().setRoot(homePage.getView());
            } else {
                // Show error message
                Label errorLabel = new Label("Username already exists");
                view.getChildren().add(errorLabel);
            }
        });

        view.getChildren().addAll(signUpLabel, usernameField, passwordField, signUpButton);
    }

    public VBox getView() {
        return view;
    }
}
