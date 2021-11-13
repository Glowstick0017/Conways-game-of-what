package com.example.conway;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HelpController {
    public Text aboutText;
    public Text rulesText;
    public Text controlsText;
    public ScrollPane aboutPane;
    public ScrollPane rulesPane;
    public ScrollPane controlPane;
    public MenuButton menuButton;
    public Hyperlink lexiconLink;

    public void glowstickClicked(ActionEvent event) {
        Main.getHS().showDocument("https://github.com/glowstick0017");
    }

    public void onAboutClick(ActionEvent event) {
        menuButton.setText("About");
        aboutPane.setVisible(true);
        rulesPane.setVisible(false);
        controlPane.setVisible(false);
        lexiconLink.setVisible(false);
    }

    public void onRulesClick(ActionEvent event) {
        menuButton.setText("Rules");
        aboutPane.setVisible(false);
        rulesPane.setVisible(true);
        controlPane.setVisible(false);
        lexiconLink.setVisible(false);
    }

    public void onControlsClick(ActionEvent event) {
        menuButton.setText("Controls");
        aboutPane.setVisible(false);
        rulesPane.setVisible(false);
        controlPane.setVisible(true);
        lexiconLink.setVisible(true);
    }

    public void lexiconClick(MouseEvent mouseEvent) {
        Main.getHS().showDocument("https://bitstorm.org/gameoflife/lexicon/");
    }
}
