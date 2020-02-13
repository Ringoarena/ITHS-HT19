package controller;

import model.*;
import view.MainFrame;

public class Launcher {
    public static void main(String[] args) {
        MyEntityManager myEntityManager = new MyEntityManager();
        myEntityManager.setEducationDAO(new EducationDAO());
        myEntityManager.setCourseDAO(new CourseDAO());
        myEntityManager.setTeacherDAO(new TeacherDAO());
        myEntityManager.setStudentDAO(new StudentDAO());
        MainFrame mainFrame = new MainFrame("School Management System. Ver 2.1, Build 118");
        new Controller(myEntityManager, mainFrame);
    }
}
