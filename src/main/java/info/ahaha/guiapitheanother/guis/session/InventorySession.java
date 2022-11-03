package info.ahaha.guiapitheanother.guis.session;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.VirtualInventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

public class InventorySession extends Session {
    private final InventoryView inventoryView;
    private final VirtualInventory virtualInventory;
    public InventorySession(GUI gui, Player player, InventoryView inventoryView, VirtualInventory virtualInventory) {
        super(gui, player);
        this.inventoryView = inventoryView;
        this.virtualInventory = virtualInventory;
    }

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public VirtualInventory getVirtualInventory() {
        return virtualInventory;
    }

    @Override
    public void close() {
        inventoryView.close();
    }
}
