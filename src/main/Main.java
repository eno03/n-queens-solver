/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import frames.WelcomeFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wint4
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        WelcomeFrame welcomeFrame = new WelcomeFrame();
        Scene welcomeScene = new Scene(welcomeFrame, 430, 215);
        welcomeFrame.setStyle("-fx-background-color: darkgray");

        Controller.getInstance().setPrimaryStage(primaryStage);
        Controller.getInstance().setWelcomeFrame(welcomeFrame);
        Controller.getInstance().setWelcomeScene(welcomeScene);
        Controller.getInstance().getPrimaryStage().setScene(welcomeScene);

        primaryStage.setTitle("N-Queen Problem");
        primaryStage.setScene(welcomeScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
