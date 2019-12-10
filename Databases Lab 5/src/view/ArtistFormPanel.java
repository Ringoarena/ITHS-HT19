package view;

import javax.swing.*;
import java.awt.*;

public class ArtistFormPanel extends JPanel {
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton okButton;

    public ArtistFormPanel() {
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        okButton = new JButton("Ok");

        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        Insets rightPadding = new Insets(0, 0, 0, 5);
        Insets noPadding = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1;
        gc.weighty = 1;

        // Row 1
        gc.gridy = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = rightPadding;
        add(nameLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(nameField, gc);

        // Row 2
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = noPadding;
        add(okButton, gc);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JButton getOkButton() {
        return okButton;
    }
}
