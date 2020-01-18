package view.listener;

import java.util.EventListener;
import view.event.UpdateEntityEvent;

@FunctionalInterface
public interface UpdateEntityListener extends EventListener{
    void updateEntityEventOccurred(UpdateEntityEvent event);
}