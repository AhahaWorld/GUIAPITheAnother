package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.session.InventorySession;

public class GUIPickUpEvent extends GUIClickEvent{
    public GUIPickUpEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }
}
