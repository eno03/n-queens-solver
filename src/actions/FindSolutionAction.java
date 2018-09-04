/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author nikol
 */
public class FindSolutionAction implements EventHandler<ActionEvent> {

    private int i = 0;
    private int sda = 0;

    @Override
    public void handle(ActionEvent event) {

        search();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Controller.getInstance().removeQueen(i, 0);
                        Controller.getInstance().placeQueen(i, Controller.getInstance().getSolution()[i]);
                        i++;
                        if (i == Controller.getInstance().getN()) {
                            timer.cancel();
                            JOptionPane.showMessageDialog(null, Controller.getInstance().getN() + " queens problem is solved!(:");
                            i = 0;
                        }
                    }
                });
            }
        }, 0, 1000);

    }

    private void search() {

        int col = 0;
        while (col >= 0 && col < Controller.getInstance().getN()) {
            int row = findPosition(col);
            if (row < 0) {
                Controller.getInstance().getSolution()[col] = -1;
                col--;
            } else {
                Controller.getInstance().getSolution()[col] = row;
                col++;
            }
        }

    }

    public int findPosition(int col) {

        int start = Controller.getInstance().getSolution()[col] + 1;
        for (int row = start; row < Controller.getInstance().getN(); row++) {
            if (isValid(col, row)) {
                return row;
            }
        }
        return -1;
    }

    public boolean isValid(int col, int row) {
        for (int i = 1; i <= col; i++) {
            System.out.println(sda);
            sda++;
            if (Controller.getInstance().getSolution()[col - i] == row
                    || Controller.getInstance().getSolution()[col - i] == row - i
                    || Controller.getInstance().getSolution()[col - i] == row + i) {
                return false;
            }
        }
        return true;
    }

}
