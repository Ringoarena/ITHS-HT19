package view;

import javax.swing.*;
import java.awt.*;

public class SongFormPanel extends JPanel {
    JLabel titleLabel;
    JTextField titleField;
    JLabel artistLabel;
    JTextField idField;
    JButton okButton;

    public SongFormPanel() {
        titleLabel = new JLabel("Title:");
        titleField = new JTextField(10);
        artistLabel = new JLabel("Artist ID:");
        idField = new JTextField(10);
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
        add(titleLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(titleField, gc);

        // Row 2
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = rightPadding;
        add(artistLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(idField, gc);

        // Row 3
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = noPadding;
        add(okButton, gc);
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getOkButton() {
        return okButton;
    }
}