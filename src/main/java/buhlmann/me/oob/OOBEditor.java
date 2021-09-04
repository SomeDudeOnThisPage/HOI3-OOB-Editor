package buhlmann.me.oob;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class OOBEditor extends Application {

    /** Root stage. */
    public static Stage STAGE;

    @Override
    public void start(Stage stage) throws Exception {
        OOBEditor.STAGE = stage;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
