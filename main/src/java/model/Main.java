package model;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
//        QuickSort insertionSort=new QuickSort(100,999,500000,4);
//        insertionSort.buildStatistics();
//        System.out.println(insertionSort.getTimeList());
//        Platform.exit();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = new File("main/src/java/view/MainWindow.fxml").toURL();
        Parent root= FXMLLoader.load(url);
        Scene value = new Scene(root, 520, 500);
//        value.getStylesheets().add(getClass().getResource("FieldStyle.css").toExternalForm());
        primaryStage.setScene(value);
        primaryStage.setResizable(false);
        primaryStage.setTitle("hhhhh");
        primaryStage.show();
    }
}
