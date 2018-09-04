/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import actions.HelpAction;
import actions.StartAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author wint4
 */
public class WelcomeFrame extends BorderPane {
    
    private final Label imageLabel = new Label();
    private final Image imageFile = new Image("images/welcome.jpg");
    private final ImageView imageView = new ImageView(imageFile);
    private final HBox hBox = new HBox(10);
    private final Button startButton = new Button("Start");
    private final Button helpButton = new Button("Help");
    
    public WelcomeFrame() {
        
        this.setPadding(new Insets(5, 5, 5, 5));
        
        imageLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        startButton.setMinSize(60, 25);
        helpButton.setMinSize(60, 25);
        imageLabel.setGraphic(imageView);
        
        hBox.getChildren().addAll(helpButton, startButton);
        this.setCenter(imageLabel);
        this.setBottom(hBox);
        
        startButton.setOnAction(new StartAction());
        helpButton.setOnAction(new HelpAction());
        
    }
    
}
