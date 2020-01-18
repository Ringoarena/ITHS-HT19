package view.listener;

import view.event.ListEntityEvent;
import java.util.EventListener;

@FunctionalInterface
public interface ListEntityListener extends EventListener {
    void listEntityEventOccurred(ListEntityEvent event);
}