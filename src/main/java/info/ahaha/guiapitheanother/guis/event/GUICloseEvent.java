package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.LayoutArea;
import info.ahaha.guiapitheanother.guis.event.attribute.SubcontractAccessor;
import info.ahaha.guiapitheanother.guis.session.InventorySession;

import java.util.List;

public class GUICloseEvent extends InventoryEvent implements SubcontractAccessor {
    public GUICloseEvent(GUI gui, InventorySession session) {
        super(gui, session);
    }

    @Override
    public List<LayoutArea> getSubcontract() {
        return inventorySession.getVirtualInventory().getAreas();
    }
}
