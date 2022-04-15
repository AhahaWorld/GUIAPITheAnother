package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.session.InventorySession;

public class LayoutHiddenEvent extends InventoryEvent{
    public LayoutHiddenEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }
}
