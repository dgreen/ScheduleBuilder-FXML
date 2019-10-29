/*
 * File: App.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  schedulebldrfxml - EE333 Fall 2019
 * Vers: 1.0.1 10/28/2019 dgg - initial coding
 */
package edu.uab.dgreen.schedulebldrfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    /**
     * Read in FXML description and start the GUI
     * @param stage - where to show
     * @throws IOException - if there are IO problems
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        scene = new Scene(loadFXML("MainPage"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Schedule Builder w/ FXML");
        stage.getIcons()
                    .add(new Image("file:resources/icon-128-128.png"));
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * Provide a reference to the stage
     * 
     * Added to support determining when stage gains focus
     * @return stage
     */
    protected static Stage getStage() {
        return stage;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Start here, launch (in side Application super class)
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
    
    

}