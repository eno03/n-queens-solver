/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import frames.MainFrame;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author wint4
 */
public class StartAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        if (Controller.getInstance().getMainFrame() == null) {
            Controller.getInstance().setMainFrame(new MainFrame());
        }

        if (Controller.getInstance().getMainScene() == null) {
            Controller.getInstance().setMainScene(new Scene(Controller.getInstance().getMainFrame()));
            Controller.getInstance().getMainFrame().setMinSize(413, 442);
            Controller.getInstance().getPrimaryStage().setResizable(true);
            
        }

        Controller.getInstance().getPrimaryStage().setTitle("N-Queen Solution");
        Controller.getInstance().getPrimaryStage().setScene(Controller.getInstance().getMainScene());
        Controller.getInstance().getMainFrame().setStyle("-fx-background-color: darkgray");

    }

}
