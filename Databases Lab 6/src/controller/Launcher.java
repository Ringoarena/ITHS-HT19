package controller;

import model.MyEntityManager;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        MyEntityManager myEntityManager = new MyEntityManager();
        MainFrame mainFrame = new MainFrame("Author/Book Program");
        Controller controller = new Controller(myEntityManager, mainFrame);
        controller.initiateController();
    }
}