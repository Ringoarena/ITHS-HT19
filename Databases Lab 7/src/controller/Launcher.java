package controller;

import model.MyEntityManager;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        MyEntityManager myEntityManager = new MyEntityManager();
        MainFrame mainFrame = new MainFrame("School Management System. Ver 2.1, Build 118");
        new Controller(myEntityManager, mainFrame);
    }
}
