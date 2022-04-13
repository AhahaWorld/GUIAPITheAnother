package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.sesson.InventorySession;

public class GUIDragEvent extends GUIClickEvent{
    public GUIDragEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }
}
