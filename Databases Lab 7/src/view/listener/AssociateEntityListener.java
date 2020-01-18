package view.listener;

import view.event.AssociateEntityEvent;
import java.util.EventListener;

@FunctionalInterface
public interface AssociateEntityListener extends EventListener {
    void associateEntityEventOccurred(AssociateEntityEvent event);
}