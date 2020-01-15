package view.table;

import model.Course;
import model.Education;
import model.Student;
import model.Teacher;
import view.event.*;
import view.listener.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MyTablePanel extends JPanel {
    private JTable jTable;
    private EducationTableModel educationTableModel;
    private CourseTableModel courseTableModel;
    private TeacherTableModel teacherTableModel;
    private StudentTableModel studentTableModel;
    private JScrollPane jScrollPane;
    private JLabel headerLabel;
    private JPopupMenu educationMenu, courseMenu, teacherMenu, studentMenu;
    private JMenuItem updateEducationItem, addCourseToEducationItem, addStudentToEducationItem, showEducationCoursesItem, showEducationStudentsItem, deleteEducationItem;
    private JMenuItem updateCourseItem, addTeacherToCourseItem, showCourseTeachersItem, showCourseEducationsItem, deleteCourseItem;
    private JMenuItem updateTeacherItem, showTeacherCoursesItem, deleteTeacherItem;
    private JMenuItem updateStudentItem, showStudentEducationItem, deleteStudentItem;
    private EventListenerList eventListenerList;

    public MyTablePanel() {
        jTable = new JTable();
        educationTableModel = new EducationTableModel();
        courseTableModel = new CourseTableModel();
        teacherTableModel = new TeacherTableModel();
        studentTableModel = new StudentTableModel();
        jScrollPane = new JScrollPane(jTable);
        headerLabel = new JLabel();
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        headerLabel.setBorder(new EmptyBorder(10, 30, 10, 0));
        jScrollPane.setBorder(new EtchedBorder());
        setupJPopupMenus();
        eventListenerList = new EventListenerList();
        setupListeners();
        setLayout(new BorderLayout());
        add(headerLabel, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
    }

    private void setupJPopupMenus() {
        educationMenu = new JPopupMenu();
        updateEducationItem = new JMenuItem("Update education");
        addCourseToEducationItem = new JMenuItem("Add course");
        addStudentToEducationItem = new JMenuItem("Add student");
        showEducationCoursesItem = new JMenuItem("Show courses");
        showEducationCoursesItem.setActionCommand("showCourses");
        showEducationStudentsItem = new JMenuItem("Show students");
        showEducationStudentsItem.setActionCommand("showStudents");
        deleteEducationItem = new JMenuItem("Delete education");
        educationMenu.add(updateEducationItem);
        educationMenu.add(addCourseToEducationItem);
        educationMenu.add(addStudentToEducationItem);
        educationMenu.add(showEducationCoursesItem);
        educationMenu.add(showEducationStudentsItem);
        educationMenu.add(deleteEducationItem);
        courseMenu = new JPopupMenu();
        updateCourseItem = new JMenuItem("Update course");
        addTeacherToCourseItem = new JMenuItem("Add teacher");
        showCourseTeachersItem = new JMenuItem("Show teachers");
        showCourseTeachersItem.setActionCommand("showCourseTeachers");
        showCourseEducationsItem = new JMenuItem("Show educations");
        showCourseEducationsItem.setActionCommand("showCourseEducations");
        deleteCourseItem = new JMenuItem("Delete course");
        courseMenu.add(updateCourseItem);
        courseMenu.add(addTeacherToCourseItem);
        courseMenu.add(showCourseTeachersItem);
        courseMenu.add(showCourseEducationsItem);
        courseMenu.add(deleteCourseItem);
        teacherMenu = new JPopupMenu();
        updateTeacherItem = new JMenuItem("Update teacher");
        showTeacherCoursesItem = new JMenuItem("Show courses");
        showTeacherCoursesItem.setActionCommand("showTeacherCourses");
        deleteTeacherItem = new JMenuItem("Delete teacher");
        teacherMenu.add(updateTeacherItem);
        teacherMenu.add(showTeacherCoursesItem);
        teacherMenu.add(deleteTeacherItem);
        studentMenu = new JPopupMenu();
        updateStudentItem = new JMenuItem("Update student");
        showStudentEducationItem = new JMenuItem("Show education");
        showStudentEducationItem.setActionCommand("showStudentEducation");
        deleteStudentItem = new JMenuItem("Delete student");
        studentMenu.add(updateStudentItem);
        studentMenu.add(showStudentEducationItem);
        studentMenu.add(deleteStudentItem);

        jTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int row = jTable.rowAtPoint(e.getPoint());
                jTable.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (jTable.getModel() instanceof EducationTableModel) {
                        educationMenu.show(jTable, e.getX(), e.getY());
                    } else if (jTable.getModel() instanceof CourseTableModel) {
                        courseMenu.show(jTable, e.getX(), e.getY());
                    } else if (jTable.getModel() instanceof TeacherTableModel) {
                        teacherMenu.show(jTable, e.getX(), e.getY());
                    } else if (jTable.getModel() instanceof StudentTableModel) {
                        studentMenu.show(jTable, e.getX(), e.getY());
                    }
                }
            }
        });
    }

    private void setupListeners() {
        updateEducationItem.addActionListener(e -> fireUpdateEntityEvent(new UpdateEntityEvent(this,
                getIdAtRow(),
                JOptionPane.showInputDialog("Enter new education name:"),
                jTable.getModel().getClass().getSimpleName())));
        updateCourseItem.addActionListener(e -> fireUpdateEntityEvent(new UpdateEntityEvent(this,
                getIdAtRow(),
                JOptionPane.showInputDialog("Enter new course name:"),
                jTable.getModel().getClass().getSimpleName())));
        updateTeacherItem.addActionListener(e -> fireUpdateEntityEvent(new UpdateEntityEvent(this,
                getIdAtRow(),
                JOptionPane.showInputDialog("Enter new teacher name:"),
                jTable.getModel().getClass().getSimpleName())));
        updateStudentItem.addActionListener(e -> fireUpdateEntityEvent(new UpdateEntityEvent(this,
                getIdAtRow(),
                JOptionPane.showInputDialog("Enter new student name:"),
                jTable.getModel().getClass().getSimpleName())));
        addCourseToEducationItem.addActionListener(e -> fireAssociateEntityEvent(new AssociateEntityEvent(this,
                getIdAtRow(),
                Integer.parseInt(JOptionPane.showInputDialog("Enter course id:")),
                true,
                jTable.getModel().getClass().getSimpleName())));
        addStudentToEducationItem.addActionListener(e -> fireAssociateEntityEvent(new AssociateEntityEvent(this,
                getIdAtRow(),
                Integer.parseInt(JOptionPane.showInputDialog("Enter student id:")),
                false,
                jTable.getModel().getClass().getSimpleName())));
        addTeacherToCourseItem.addActionListener(e -> fireAssociateEntityEvent(new AssociateEntityEvent(this,
                getIdAtRow(),
                Integer.parseInt(JOptionPane.showInputDialog("Enter teacher id:")),
                false,
                jTable.getModel().getClass().getSimpleName())));
        showEducationCoursesItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(1);
        });
        showEducationStudentsItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(3);
        });
        showCourseTeachersItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(2);
        });
        showCourseEducationsItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(0);
        });
        showTeacherCoursesItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(1);
        });
        showStudentEducationItem.addActionListener(e -> {
            fireShowAssociatedEntityEvent(new ShowAssociatedEntityEvent(this, getIdAtRow(), jTable.getModel().getClass().getSimpleName(), e.getActionCommand()));
            setTableModel(0);
        });
        deleteEducationItem.addActionListener(e -> fireDeleteEntityEvent(new DeleteEntityEvent(this,
                getIdAtRow(),
                jTable.getModel().getClass().getSimpleName())));
        deleteCourseItem.addActionListener(e -> fireDeleteEntityEvent(new DeleteEntityEvent(this,
                getIdAtRow(),
                jTable.getModel().getClass().getSimpleName())));
        deleteTeacherItem.addActionListener(e -> fireDeleteEntityEvent(new DeleteEntityEvent(this,
                getIdAtRow(),
                jTable.getModel().getClass().getSimpleName())));
        deleteStudentItem.addActionListener(e -> fireDeleteEntityEvent(new DeleteEntityEvent(this,
                getIdAtRow(),
                jTable.getModel().getClass().getSimpleName())));
    }

    public void addUpdateEntityListener(UpdateEntityListener listener) {
        eventListenerList.add(UpdateEntityListener.class, listener);
    }

    public void addAssociateEntityListener(AssociateEntityListener listener) {
        eventListenerList.add(AssociateEntityListener.class, listener);
    }

    public void addShowAssociatedEntityListener(ShowAssociatedEntityListener listener) {
        eventListenerList.add(ShowAssociatedEntityListener.class, listener);
    }

    public void addDeleteEntityListener(DeleteEntityListener listener) {
        eventListenerList.add(DeleteEntityListener.class, listener);
    }

    public void fireUpdateEntityEvent(UpdateEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == UpdateEntityListener.class) {
                ((UpdateEntityListener) listeners[i + 1]).updateEntityEventOccurred(event);
            }
        }
    }

    public void fireAssociateEntityEvent(AssociateEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == AssociateEntityListener.class) {
                ((AssociateEntityListener) listeners[i + 1]).associateEntityEventOccurred(event);
            }
        }
    }

    public void fireShowAssociatedEntityEvent(ShowAssociatedEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ShowAssociatedEntityListener.class) {
                ((ShowAssociatedEntityListener) listeners[i + 1]).showAssociatedEntityEventOccurred(event);
            }
        }
    }

    public void fireDeleteEntityEvent(DeleteEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == DeleteEntityListener.class) {
                ((DeleteEntityListener) listeners[i + 1]).deleteEntityEventOccurred(event);
            }
        }
    }

    private int getIdAtRow() {
        int row = jTable.getSelectedRow();
        return (int) jTable.getModel().getValueAt(row, 0);
    }

    public void setTableModel(int modelTypeIndex) {
        switch (modelTypeIndex) {
            case 0:
                jTable.setModel(educationTableModel);
                headerLabel.setText("Educations");
                break;
            case 1:
                jTable.setModel(courseTableModel);
                headerLabel.setText("Courses");
                break;
            case 2:
                jTable.setModel(teacherTableModel);
                headerLabel.setText("Teachers");
                break;
            case 3:
                jTable.setModel(studentTableModel);
                headerLabel.setText("Students");
                break;
        }
    }

    public void setEducationData(List<Education> educations) {
        educationTableModel.setData(educations);
    }

    public void setCourseData(List<Course> courses) {
        courseTableModel.setData(courses);
    }

    public void setTeacherData(List<Teacher> teachers) {
        teacherTableModel.setData(teachers);
    }

    public void setStudentData(List<Student> students) {
        studentTableModel.setData(students);
    }
}