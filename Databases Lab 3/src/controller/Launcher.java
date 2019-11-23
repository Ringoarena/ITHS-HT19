package controller;

import model.PersonDAOImplementation;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        PersonDAOImplementation dao = new PersonDAOImplementation();
        MainFrame mainFrame = new MainFrame("MVC with Rick");
        Controller controller = new Controller(dao,mainFrame);
        controller.initiateView();
        controller.initiateController();
    }
}
