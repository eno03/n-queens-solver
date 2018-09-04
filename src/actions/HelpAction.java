/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 *
 * @author wint4
 */
public class HelpAction implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        String tekst = new String("\t\t\t\t\t---> N-Queen Problem <--\n"
                + "\n\tProblem N kraljica predstavlja problem postavljanja "
                + "N šahovskih kraljica\nna N x N šahovsku tablu pod uslovom da "
                + "nijedna od njih ne može biti pretnja\nostalim kraljicama po "
                + "standrardnim šahovskim pravilima.\n"
                + "\tDa bi se kraljice pravilo raspodelile na šahovskoj tabli, one ne smeju deliti \nistu kolonu, red ili dijagonalu. ");
        TextArea textArea = new TextArea(tekst);
        textArea.setEditable(false);
        textArea.setStyle("-fx-background-color: coral ");
        Controller.getInstance().getWelcomeFrame().setCenter(textArea);

    }

}
