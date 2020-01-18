package view.listener;

import view.event.TeacherFormEvent;
import java.util.EventListener;

@FunctionalInterface
public interface TeacherFormListener extends EventListener {
    void teacherFormEventOccurred(TeacherFormEvent event);
}