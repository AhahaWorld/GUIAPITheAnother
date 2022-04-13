package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.guis.sesson.InventorySession;

public class InventoryEvent extends GUIEvent {

    protected InventorySession inventorySession;

    public InventoryEvent(GUI gui, InventorySession session) {
        super(gui, session);
        this.inventorySession = session;
    }

    public InventorySession getInventorySession() {
        return inventorySession;
    }

    public void setInventorySession(InventorySession inventorySession) {
        this.inventorySession = inventorySession;
    }

}
