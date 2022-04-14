package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.guis.session.InventorySession;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class SessionEmbeddedInventoryHolder implements InventoryHolder {
    InventorySession session = null;
    Inventory inventory = null;

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public InventorySession getSession() {
        return session;
    }

    public void setSession(InventorySession session) {
        this.session = session;
    }
}
