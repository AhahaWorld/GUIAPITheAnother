package info.ahaha.guiapitheanother.guis.sesson;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.VirtualInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryView;

import java.util.HashMap;
import java.util.Map;

public class InventorySession extends Session {
    public InventorySession(GUI gui, Player player, InventoryView inventoryView,VirtualInventory virtualInventory) {
        super(gui, player);
        this.inventoryView = inventoryView;
        this.virtualInventory = virtualInventory;
    }

    private final InventoryView inventoryView;
    private final VirtualInventory virtualInventory;

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public VirtualInventory getVirtualInventory() {
        return virtualInventory;
    }
}
