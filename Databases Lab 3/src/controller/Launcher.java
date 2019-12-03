package controller;

import model.PersonDAO;
import model.JDBCImplementation;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        PersonDAO dao = new JDBCImplementation();
        MainFrame mainFrame = new MainFrame("Person database program");
        Controller controller = new Controller(dao,mainFrame);
        controller.initiateView();
        controller.initiateController();
    }
}
