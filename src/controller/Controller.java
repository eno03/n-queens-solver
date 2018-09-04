/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import frames.MainFrame;
import frames.WelcomeFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author wint4
 */
public class Controller {

    private static Controller instance = null;
    private Stage primaryStage;
    private WelcomeFrame welcomeFrame;
    private Scene welcomeScene;
    private MainFrame mainFrame;
    private Scene mainScene;
    private int N;
    private int[] solution;
    private Label[][] fields;

    private Controller() {
        welcomeFrame = null;
        welcomeScene = null;
        mainFrame = null;
        mainScene = null;
        fields = null;
        solution = null;
        N = 0;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public WelcomeFrame getWelcomeFrame() {
        return welcomeFrame;
    }

    public void setWelcomeFrame(WelcomeFrame welcomeFrame) {
        this.welcomeFrame = welcomeFrame;
    }

    public Scene getWelcomeScene() {
        return welcomeScene;
    }

    public void setWelcomeScene(Scene welcomeScene) {
        this.welcomeScene = welcomeScene;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public Label[][] getFields() {
        return fields;
    }

    public void setFields(Label[][] fields) {
        this.fields = fields;
    }

    public int[] getSolution() {
        return solution;
    }

    public void setSolution(int[] solution) {
        this.solution = solution;
    }

    public void placeQueen(int row, int col) throws IllegalArgumentException {
        if (row < 0 || row >= Controller.getInstance().getN() || col < 0 || col >= Controller.getInstance().getN()) {
            throw new IllegalArgumentException("Red ili kolona izvan opsega");
        }
        Platform.runLater(() -> {
            fields[row][col].setGraphic(new ImageView("./images/queen.png"));
        });
    }

    public void removeQueen(int row, int col) throws IllegalArgumentException {

        if (row < 0 || row >= Controller.getInstance().getN() || col < 0 || col >= Controller.getInstance().getN()) {
            throw new IllegalArgumentException("Red ili kolona izvan opsega");
        }
        Platform.runLater(() -> {
            Controller.getInstance().getFields()[row][col].setGraphic(null);
        });
    }

}
