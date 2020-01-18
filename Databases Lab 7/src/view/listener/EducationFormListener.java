package view.listener;

import view.event.EducationFormEvent;
import java.util.EventListener;

@FunctionalInterface
public interface EducationFormListener extends EventListener {
    void educationFormEventOccurred(EducationFormEvent event);
}