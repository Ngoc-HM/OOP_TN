package hust.soict.hedspi.aims.menu;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.order.Order;

public class AddThresholdsDialog {
    private final JDialog selectDialog = new JDialog();
    public AddThresholdsDialog(Order anOrder) {
    	// Set for Dialog 
        selectDialog.setSize(500,300);
        selectDialog.getContentPane().setLayout(null);
        selectDialog.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500))/2;
        int y = (int) ((dimension.getHeight() - 450))/2;
        selectDialog.setLocation(x, y);
        selectDialog.setModal(true);
        selectDialog.setTitle("Set thresholds");
        selectDialog.setVisible(false);
        JDialog thresholdsDialog = new JDialog();

        // Create thresholds Dialog
        ThresholdsDialog thresh = new ThresholdsDialog(thresholdsDialog);

        // Handler OK button
        thresh.okBtn.addActionListener(e1 -> {
            thresholdsDialog.setVisible(false);
            try {
            	anOrder.setThresholds(thresh.getTotal(), thresh.getItem());
                JOptionPane.showMessageDialog(null,"Set thresholds successfully");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        thresholdsDialog.setVisible(true);

    }
    public static class ThresholdsDialog {

    	// create label and field
        JLabel totalLb = new JLabel("Total thresholds ($)");
        JLabel itemLb = new JLabel("Item thresholds");
        JButton okBtn = new JButton("OK");
        JTextField totalField = new JTextField();
        JTextField itemField = new JTextField();

        public int getItem() {
            return Integer.parseInt(itemField.getText());
        }
        public float getTotal() {
            return Float.parseFloat(totalField.getText());
        }

        public ThresholdsDialog(JDialog threshDialog) {
        	// set for thresholds dialog
        	threshDialog.setTitle("Setting thresholds");
            threshDialog.setSize(500,450);
            threshDialog.setLayout(null);
            threshDialog.setResizable(false);

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - 500))/2;
            int y = (int) ((dimension.getHeight() - 450))/2;
            threshDialog.setLocation(x, y);

            // create total thresholds label
            totalLb.setSize(150,30);
            totalLb.setLocation(90,20);
            threshDialog.add(totalLb);
            totalField.setSize(250, 30);
            totalField.setLocation(220,20);
            threshDialog.add(totalField);

            // create sale thresholds label
            itemLb.setSize(150,30);
            itemLb.setLocation(90,60);
            threshDialog.add(itemLb);
            itemField.setSize(250, 30);
            itemField.setLocation(220,60);
            threshDialog.add(itemField);

            // create ok button
            okBtn.setSize(100,30);
            okBtn.setLocation(200,330);
            okBtn.setFocusPainted(false);
            threshDialog.add(okBtn);

            threshDialog.setVisible(false);
            threshDialog.setModal(true);

        }
    }

}