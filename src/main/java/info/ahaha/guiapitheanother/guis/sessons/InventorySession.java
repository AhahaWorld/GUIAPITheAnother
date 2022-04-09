package info.ahaha.guiapitheanother.guis.sessons;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Session;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

public class InventorySession extends Session {
    public InventorySession(GUI gui, Player player, InventoryView inventoryView) {
        super(gui, player);
        this.inventoryView = inventoryView;
    }

    private final InventoryView inventoryView;

    public InventoryView getInventoryView() {
        return inventoryView;
    }
}
