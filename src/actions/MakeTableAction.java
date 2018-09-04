/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import exceptions.emptyString;
import exceptions.unallowedNumber;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 *
 * @author wint4
 */
public class MakeTableAction implements EventHandler<ActionEvent> {
    
    public static int SIZE;
    
    @Override
    public void handle(ActionEvent event) {
        try {
            String str = Controller.getInstance().getMainFrame().getnTextField().getText();
            checkStr(str);
            SIZE = Integer.parseInt(Controller.getInstance().getMainFrame().getnTextField().getText());
            Controller.getInstance().setN(Integer.parseInt(Controller.getInstance().getMainFrame().getnTextField().getText()));
        } catch (emptyString ex) {
            JOptionPane.showMessageDialog(null, "Please enter N!");
        } catch (unallowedNumber ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number!");
        }
        
        makeTable(SIZE);
        Controller.getInstance().getMainFrame().getFindSolutionButton().setDisable(false);
    }
    
    private void makeTable(int n) {
        
        boolean flag = false;
        boolean oldFlag = false;
        String color = "white";
        
        Controller.getInstance().setFields(null);
        Controller.getInstance().getMainFrame().getGridPane().getChildren().clear();
        
        Label[][] fields = new Label[n][n];
        int[] solution = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (j == 0) {
                    flag = oldFlag;
                    oldFlag = (oldFlag) ? false : true;
                }
                
                if (flag) {
                    flag = false;
                    color = "white";
                } else {
                    flag = true;
                    color = "black";
                }
                
                fields[i][j] = new Label();
                fields[i][j].setPrefHeight(50);
                fields[i][j].setPrefWidth(50);
                fields[i][j].setStyle("-fx-background-color: " + color);
                
                Controller.getInstance().getMainFrame().getGridPane().add(fields[i][j], i, j);
            }
            
        }
        for (int i = 0; i < n; i++) {
            solution[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            Controller.getInstance().placeQueen(i, 0);
        }
        Controller.getInstance().setFields(fields);
        Controller.getInstance().setSolution(solution);
    }
    
    private void checkStr(String str) throws emptyString, unallowedNumber {
        if (str.equals("")) {
            throw new emptyString("Please enter N");
        }
        if (!(str != null && str.matches("[-+]?\\d*\\.?\\d+"))) {
            throw new unallowedNumber("Unallowed number!");
        }
        if (str != null && str.matches("[-+]?\\d*\\.?\\d+") && Integer.parseInt(str) <= 3) {
            throw new unallowedNumber("Unallowed number!");
        }
    }
    
}
