/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import actions.FindSolutionAction;
import actions.MakeTableAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author wint4
 */
public class MainFrame extends BorderPane {
    
    private final HBox bottomBox = new HBox(5);
    private final TextField nTextField = new TextField();
    private GridPane gridPane = new GridPane();
    private final Label enterLabel = new Label("Enter N: ");
    private Button makeTableButton = new Button("Problem");
    private Button findSolutionButton = new Button("Solution");
    private final Image imageFile = new Image("images/queen.png");
    private final ImageView imageView = new ImageView(imageFile);
    
    public MainFrame() {
        
        this.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);
        bottomBox.setAlignment(Pos.CENTER);
        
        nTextField.setMinSize(30, 25);
        nTextField.setMaxSize(30, 25);
        makeTableButton.setMinSize(90, 25);
        findSolutionButton.setMinSize(90, 25);
        
        findSolutionButton.setDisable(true);
        bottomBox.getChildren().addAll(enterLabel, nTextField, makeTableButton, findSolutionButton);
        this.setCenter(gridPane);
        this.setBottom(bottomBox);
        makeTableButton.setOnAction(new MakeTableAction());
        findSolutionButton.setOnAction(new FindSolutionAction());
        
    }
    
    public GridPane getGridPane() {
        return gridPane;
    }
    
    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    
    public Button getFindSolutionButton() {
        return findSolutionButton;
    }
    
    public void setFindSolutionButton(Button findSolutionButton) {
        this.findSolutionButton = findSolutionButton;
    }
    
    public HBox getBottomBox() {
        return bottomBox;
    }
    
    public TextField getnTextField() {
        return nTextField;
    }
    
    public Label getEnterLabel() {
        return enterLabel;
    }
    
    public Image getImageFile() {
        return imageFile;
    }
    
    public ImageView getImageView() {
        return imageView;
    }
    
    public Button getMakeTableButton() {
        return makeTableButton;
    }
    
    public void setMakeTableButton(Button makeTableButton) {
        this.makeTableButton = makeTableButton;
    }
    
}
