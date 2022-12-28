package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
            Label tfDisplay = null;
            tfDisplay.setText(tfDisplay.getText() + button);
        } else if (button.equals("DEL")) {
            //
        } else {
            //
        }
    }
}
