package controller;

import model.Gender;
import model.PersonDAO;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    PersonDAO dao;
    MainFrame mainFrame;

    public Controller(PersonDAO dao, MainFrame mainFrame) {
        this.dao = dao;
        this.mainFrame = mainFrame;
    }

    public void initiateView() {
        mainFrame.getTablePanel().getModel().setData(dao.getAll());
        mainFrame.getTablePanel().getModel().fireTableDataChanged();
    }

    public void initiateController() {
        mainFrame.getFormPanel().getOkButton().addActionListener( e -> addPerson());
        mainFrame.getTablePanel().getDeleteItem().addActionListener(e -> deletePerson());
        mainFrame.getTablePanel().getUpdateItem().addActionListener(e -> updatePerson());
        mainFrame.getTablePanel().getTable().addMouseListener(myMouseAdapter());
    }

    public void addPerson() {
        dao.create(mainFrame.getFormPanel().getNameField().getText(),
                mainFrame.getFormPanel().getDatePicker().getDate(),
                Gender.valueOf(mainFrame.getFormPanel().getGenderCombo().getSelectedItem().toString().toLowerCase()));
        mainFrame.getTablePanel().getModel().setData(dao.getAll());
        mainFrame.getTablePanel().getModel().fireTableDataChanged();
    }

    public void deletePerson() {
        JTable table = mainFrame.getTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        dao.deleteByID(id);
        mainFrame.getTablePanel().getModel().setData(dao.getAll());
        mainFrame.getTablePanel().getModel().fireTableDataChanged();
    }

    public void updatePerson() {
        JTable table = mainFrame.getTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        String newName = JOptionPane.showInputDialog("Enter new name");
        dao.updateNameByID(id, newName);
        mainFrame.getTablePanel().getModel().setData(dao.getAll());
        mainFrame.getTablePanel().getModel().fireTableDataChanged();
    }

    public MouseAdapter myMouseAdapter() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JTable table = mainFrame.getTablePanel().getTable();
                JPopupMenu jPopupMenu = mainFrame.getTablePanel().getjPopupMenu();
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        };
    }
}
