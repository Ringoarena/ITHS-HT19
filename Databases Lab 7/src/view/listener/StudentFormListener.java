package view.listener;

import view.event.StudentFormEvent;
import java.util.EventListener;

@FunctionalInterface
public interface StudentFormListener extends EventListener{
    void studentFormEventOccurred(StudentFormEvent event);
}