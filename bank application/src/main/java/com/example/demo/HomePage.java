package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage {
    private VBox view;

    public HomePage(Stage primaryStage) {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to the Bank App");
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign up here!");

        loginButton.setOnAction(e -> {
            LoginPage loginPage = new LoginPage(primaryStage);
            primaryStage.getScene().setRoot(loginPage.getView());
        });

        signUpButton.setOnAction(e -> {
            SignUpPage signUpPage = new SignUpPage(primaryStage);
            primaryStage.getScene().setRoot(signUpPage.getView());
        });

        view.getChildren().addAll(welcomeLabel, loginButton, signUpButton);
    }

    public VBox getView() {
        return view;
    }
}
