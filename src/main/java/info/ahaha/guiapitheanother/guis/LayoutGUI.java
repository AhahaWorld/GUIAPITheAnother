package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.guis.session.InventorySession;
import info.ahaha.guiapitheanother.impl.VirtualInventoryImpl;
import info.ahaha.guiapitheanother.util.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public interface LayoutGUI extends GUI {
    Layout getLayout();

    @Override
    default void init() {
        GUI.super.init();
        if (getLayout().listeners() != null)
            for (GUIListener listener : getLayout().listeners())
                getManager().register(listener);
    }

    default void showInventory(Player player) {
        VirtualInventory vInventory = new VirtualInventoryImpl(getLayout().size());
        getLayout().make(vInventory, player);
        SessionEmbeddedInventoryHolder holder = new SessionEmbeddedInventoryHolder();
        Inventory inventory = null;
        if (InventoryUtils.fitInventoryType(getLayout().size()) != null)
            inventory = Bukkit.createInventory(holder, InventoryUtils.fitInventoryType(getLayout().size()));
        else
            inventory = Bukkit.createInventory(holder, InventoryUtils.fitInventorySize(getLayout().size()));
        holder.setInventory(inventory);
        InventoryView view = player.openInventory(inventory);
        InventorySession session = new InventorySession(this, player, view, vInventory);
        holder.setSession(session);
    }
}
