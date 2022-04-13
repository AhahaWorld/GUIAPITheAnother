package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.sesson.InventorySession;

public class GUIClickEvent extends InventoryEvent{


    public GUIClickEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }


}
