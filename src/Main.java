import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Picture");
        Parent view = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
}
