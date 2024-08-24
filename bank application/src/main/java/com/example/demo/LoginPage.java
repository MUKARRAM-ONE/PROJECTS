package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage {
    private VBox view;

    public LoginPage(Stage primaryStage) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label loginLabel = new Label("Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            if (DatabaseHelper.authenticateUser(usernameField.getText(), passwordField.getText())) {
                ProfilePage profilePage = new ProfilePage(primaryStage, usernameField.getText());
                primaryStage.getScene().setRoot(profilePage.getView());
            } else {
                // Show error message
                Label errorLabel = new Label("Invalid username or password");
                view.getChildren().add(errorLabel);
            }
        });

        view.getChildren().addAll(loginLabel, usernameField, passwordField, loginButton);
    }

    public VBox getView() {
        return view;
    }
}
