package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        scene = new Scene(root,600,400);
        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(620);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(620);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }



    public static void main(String[] args) {
        launch(args);
    }
}
