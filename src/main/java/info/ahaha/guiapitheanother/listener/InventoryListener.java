package info.ahaha.guiapitheanother.listener;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIAPITheAnother;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.guis.event.GUIClickEvent;
import info.ahaha.guiapitheanother.guis.session.InventorySession;
import info.ahaha.guiapitheanother.util.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        for (GUI gui : GUIAPITheAnother.guiList) {
            Session session = gui.getSessions().get(player);
            if (!(session instanceof InventorySession)) {
                Bukkit.getLogger().info("session isnot inventorySession");
                continue;
            }
            if (!((InventorySession) session).getInventoryView().equals(e.getView())) {
                Bukkit.getLogger().info("InventoryView notequals");
                continue;
            }
            Bukkit.getLogger().info("clickEvent is inventorySession");
            InventorySession inventorySession = (InventorySession) session;
            GUIClickEvent clickEvent = new GUIClickEvent(session.getGUI(), inventorySession, InventoryUtils.convertSlotToPoint(e.getView().getType(), e.getSlot()));
            session.getGUI().call(clickEvent);
            if (clickEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
