package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.sesson.InventorySession;

public class GUIShiftClickEvent extends GUIClickEvent{
    public GUIShiftClickEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }
}
