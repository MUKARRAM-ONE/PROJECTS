package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class CurrencyConverterGUI extends Application {

    private Label amountLabel, fromCurrencyLabel, toCurrencyLabel, resultLabel;
    private TextField amountField, resultField;
    private ComboBox<String> fromCurrencyComboBox, toCurrencyComboBox;
    private Button convertButton;

    // Exchange rates from PKR to other currencies
    private static final double[] exchangeRates = {
    		0.0036,   // PKR to USD
    		0.30,     // PKR to INR
    		0.0034,   // PKR to Euro
    		0.0011,   // PKR to Kuwaiti Dinar
    		0.013,    // PKR to UAE Dirham
    		0.013,    // PKR to Saudi Riyal
    		0.017     // PKR to Romanian Leu
    };

    // Names of currencies
    private static final String[] currencies = {
        "PKR", "US Dollar", "Indian Rupee", "Euro", "Kuwaiti Dinar",
        "UAE Dirham", "Saudi Riyal", "Romanian Leu"
    };

    @Override
    public void start(Stage primaryStage) {
    	
        GridPane grid = new GridPane();
        
        Scene scene = new Scene(grid,1360,690);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Currency Converter"); // Add this line
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.show();
        
     
 
        
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(15));
       
        amountLabel = new Label("Enter Amount:");
        grid.add(amountLabel, 0, 0);

        amountField = new TextField();
        amountField.setPrefWidth(400);
        grid.add(amountField, 1, 0);

        fromCurrencyLabel = new Label("From:");
        grid.add(fromCurrencyLabel, 0, 1);

        fromCurrencyComboBox = new ComboBox<>();
        fromCurrencyComboBox.getItems().addAll(currencies);
        fromCurrencyComboBox.setPrefWidth(400);
        fromCurrencyComboBox.getSelectionModel().select(0); // or fromCurrencyComboBox.setValue(fromCurrencyComboBox.getItems().get(0));
        grid.add(fromCurrencyComboBox, 1, 1);
       

        toCurrencyLabel = new Label("To:");
        grid.add(toCurrencyLabel, 0, 2);

        toCurrencyComboBox = new ComboBox<>();
        toCurrencyComboBox.getItems().addAll(currencies);
        toCurrencyComboBox.setPrefWidth(400);
        toCurrencyComboBox.getSelectionModel().select(0);
        grid.add(toCurrencyComboBox, 1, 2);

        
     // Creating an Alert
        Alert alert = new Alert(AlertType.INFORMATION);
     // setting the title of alert box
        alert.setTitle("Message");
     // setting header text 
        alert.setHeaderText(null);
     // setting content text
        alert.setContentText("Currency Converted Successfully!");
        
        convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
        	convertCurrency();
        	alert.showAndWait();
        });
        convertButton.setPrefWidth(400);
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(convertButton);
        grid.add(buttonBox, 1, 3);

        resultLabel = new Label("Converted Amount:");
        grid.add(resultLabel, 0, 6);

        resultField = new TextField();
        resultField.setEditable(false);
        grid.add(resultField, 1, 6);

      
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int fromIndex = fromCurrencyComboBox.getSelectionModel().getSelectedIndex();
            int toIndex = toCurrencyComboBox.getSelectionModel().getSelectedIndex();

            // Convert from PKR to selected currency
            double convertedAmount;
            if (fromIndex == 0) {
                convertedAmount = amount * exchangeRates[toIndex - 1];
            } else if (toIndex == 0) {
                convertedAmount = amount / exchangeRates[fromIndex - 1];
            } else {
                double pkrAmount = amount / exchangeRates[fromIndex - 1];
                convertedAmount = pkrAmount * exchangeRates[toIndex - 1];
            }

            resultField.setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException ex) {
            // Handle error
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}