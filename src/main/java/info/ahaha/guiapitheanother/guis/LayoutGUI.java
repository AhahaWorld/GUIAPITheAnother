package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.guis.event.attribute.SubcontractAccessor;
import info.ahaha.guiapitheanother.guis.event.attribute.SubcontractSelector;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetPointUsable;
import info.ahaha.guiapitheanother.guis.session.InventorySession;
import info.ahaha.guiapitheanother.impl.VirtualInventoryImpl;
import info.ahaha.guiapitheanother.util.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.List;

public interface LayoutGUI extends GUI {
    Layout getLayout();

    @Override
    default void init() {
        GUI.super.init();
        if (getLayout().listeners() != null)
            for (GUIListener listener : getLayout().listeners())
                getManager().register(listener);
    }

    @Override
    default void call(GUIEvent event) {
        GUI.super.call(event);
        List<? extends GUIEventCallable> areas = null;
        if(event instanceof SubcontractSelector)
            areas = ((SubcontractSelector) event).selectSubcontract();
        else if(event instanceof SubcontractAccessor)
            areas = ((SubcontractAccessor) event).getSubcontract();
        if(areas == null)
            return;
        for(GUIEventCallable area : areas){
            area.call(event);
        }
    }

    default Session showInventory(Player player) {
        VirtualInventoryImpl vInventory = new VirtualInventoryImpl(getLayout().size());
        getLayout().make(vInventory, player);
        SessionEmbeddedInventoryHolder holder = new SessionEmbeddedInventoryHolder();
        Inventory inventory = null;
        if (InventoryUtils.fitInventoryType(getLayout().size()) != null)
            inventory = Bukkit.createInventory(holder, InventoryUtils.fitInventoryType(getLayout().size()));
        else
            inventory = Bukkit.createInventory(holder, InventoryUtils.fitInventorySize(getLayout().size()));
        inventory.setContents(InventoryUtils.convertVInventoryToInventory(inventory.getType(), inventory.getContents().length, vInventory));
        holder.setInventory(inventory);
        InventoryView view = player.openInventory(inventory);
        InventorySession session = new InventorySession(this, player, view, vInventory);
        holder.setSession(session);
        vInventory.setSession(session);
        return session;
    }
}
