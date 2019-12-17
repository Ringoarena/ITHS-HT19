package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class AuthorFormPanel extends JPanel {
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton okButton, clearButton;
    private Border innerBorder, outerBorder;
    private CompoundBorder compoundBorder;

    public AuthorFormPanel() {
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(12);
        okButton = new JButton("Ok");
        clearButton = new JButton("Clear");
        innerBorder = BorderFactory.createTitledBorder("Add author");
        outerBorder = BorderFactory.createEmptyBorder();
        compoundBorder = new CompoundBorder(innerBorder, outerBorder);
        setBorder(compoundBorder);
        setMinimumSize(new Dimension(250,450));
        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        Insets rightPadding = new Insets(0, 0, 0, 5);
        Insets noPadding = new Insets(0, 0, 0, 0);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1;
        gc.weighty = 1;

        // Row 1
        gc.gridy = 0;

        gc.gridx = 0;
        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        // Row 2

        gc.gridy++;

        gc.gridx = 0;
        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.LINE_END;
        add(okButton, gc);

        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.LINE_START;
        add(clearButton, gc);
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public Border getInnerBorder() {
        return innerBorder;
    }

    public void setInnerBorder(Border innerBorder) {
        this.innerBorder = innerBorder;
    }

    public Border getOuterBorder() {
        return outerBorder;
    }

    public void setOuterBorder(Border outerBorder) {
        this.outerBorder = outerBorder;
    }

    public CompoundBorder getCompoundBorder() {
        return compoundBorder;
    }

    public void setCompoundBorder(CompoundBorder compoundBorder) {
        this.compoundBorder = compoundBorder;
    }
}
