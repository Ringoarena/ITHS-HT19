package controller;

import model.JPAImplementation;
import model.PersonDAO;
import model.JDBCImplementation;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        //PersonDAO dao = new JDBCImplementation();
        PersonDAO dao = new JPAImplementation();
        MainFrame mainFrame = new MainFrame("Person database program");
        Controller controller = new Controller(dao,mainFrame);
        controller.initiateView();
        controller.initiateController();
    }
}
