package info.ahaha.guiapitheanother.guis.sesson;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Session;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

import java.util.HashMap;
import java.util.Map;

public class InventorySession extends Session {
    public InventorySession(GUI gui, Player player, InventoryView inventoryView) {
        super(gui, player);
        this.inventoryView = inventoryView;
    }

    private final InventoryView inventoryView;
    private final Map<String, Object> property = new HashMap<>();

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public Map<String, Object> getProperty() {
        return property;
    }
}
