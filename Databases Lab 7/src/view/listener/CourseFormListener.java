package view.listener;

import view.event.CourseFormEvent;
import java.util.EventListener;

@FunctionalInterface
public interface CourseFormListener extends EventListener {
    void courseFormEventOccurred(CourseFormEvent event);
}