package view.listener;

import view.event.ShowAssociatedEntityEvent;
import java.util.EventListener;

@FunctionalInterface
public interface ShowAssociatedEntityListener extends EventListener {
    void showAssociatedEntityEventOccurred(ShowAssociatedEntityEvent event);
}