package Launcher;

import model.EmployeeManager;
import ui.Menu;

public class Launcher {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Menu menu = new Menu(employeeManager);
        menu.mainMenu();
    }
}