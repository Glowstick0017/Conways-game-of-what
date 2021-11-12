package com.example.conway;

import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class HelpController {
    public Text textArea;

    public void glowstickClicked(ActionEvent event) {
        Main.getHS().showDocument("https://github.com/glowstick0017");
    }
}
