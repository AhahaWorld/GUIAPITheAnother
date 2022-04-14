package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.session.InventorySession;

public class GUIDragEvent extends GUIClickEvent{
    public GUIDragEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }
}
