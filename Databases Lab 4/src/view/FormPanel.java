package view;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class FormPanel extends JPanel {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel genderLabel;
    private JComboBox genderCombo;
    private JLabel dateOfBirthLabel;
    private DatePicker datePicker;
    private JButton okButton;

    public FormPanel() {
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        genderLabel = new JLabel("Gender:");
        genderCombo = new JComboBox();
        dateOfBirthLabel = new JLabel("Date of birth:");
        datePicker = new DatePicker();
        okButton = new JButton("Ok");

        DefaultComboBoxModel genderModel = new DefaultComboBoxModel();
        genderModel.addElement("Male");
        genderModel.addElement("Female");
        genderCombo.setModel(genderModel);
        genderCombo.setSelectedIndex(0);

        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder();
        setBorder(new CompoundBorder(innerBorder,outerBorder));
        setMinimumSize(new Dimension(250,10));

        layoutComponents();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        Insets rightPadding = new Insets(0, 0, 0, 5);
        Insets noPadding = new Insets(0, 0, 0, 0);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1;
        gc.weighty = 1;

        // Row 1 ///////////////////
        gc.gridy = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = rightPadding;
        add(nameLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(nameField, gc);

        // Row 2 ///////////////////
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = rightPadding;
        add(genderLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(genderCombo, gc);

        // Row 3 ///////////////////
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = rightPadding;
        add(dateOfBirthLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noPadding;
        add(datePicker, gc);

        // Row 4 //////////
        gc.gridy++;
        gc.weighty = 5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(okButton, gc);
    }

    public JComboBox getGenderCombo() {
        return genderCombo;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JButton getOkButton() {
        return okButton;
    }
}
