package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class BookFormPanel extends JPanel {
    private JLabel titleLabel, authorIDLabel;
    private JTextField titleField, authorIDField;
    private JButton okButton, clearButton;
    private Border innerBorder, outerBorder;
    private CompoundBorder compoundBorder;

    public BookFormPanel() {
        titleLabel = new JLabel("Title:");
        titleField = new JTextField(12);
        authorIDLabel = new JLabel("Author ID:");
        authorIDField = new JTextField(12);
        okButton = new JButton("Ok");
        clearButton = new JButton("Clear");
        innerBorder = BorderFactory.createTitledBorder("Add book");
        outerBorder = BorderFactory.createEmptyBorder();
        compoundBorder = new CompoundBorder(innerBorder, outerBorder);
        setBorder(compoundBorder);
        setMinimumSize(new Dimension(250,400));
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
        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.LINE_END;
        add(authorIDLabel, gc);

        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.LINE_START;
        add(authorIDField, gc);

        // Row 3

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

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
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

    public JLabel getAuthorIDLabel() {
        return authorIDLabel;
    }

    public void setAuthorIDLabel(JLabel authorIDLabel) {
        this.authorIDLabel = authorIDLabel;
    }

    public JTextField getAuthorIDField() {
        return authorIDField;
    }

    public void setAuthorIDField(JTextField authorIDField) {
        this.authorIDField = authorIDField;
    }
}
