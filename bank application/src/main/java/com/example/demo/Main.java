import com.example.demo.HomePage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        HomePage homePage = new HomePage(primaryStage);
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(new Scene(homePage.getView(), 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
