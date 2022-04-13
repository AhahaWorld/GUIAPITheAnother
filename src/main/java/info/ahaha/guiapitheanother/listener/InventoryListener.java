package info.ahaha.guiapitheanother.listener;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIAPITheAnother;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.guis.sesson.InventorySession;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        for (GUI gui : GUIAPITheAnother.guiList){
            Session session = gui.getSessions().get(player);
            if (!(session instanceof InventorySession)){
                continue;
            }
            if (!((InventorySession) session).getInventoryView().equals(e.getView())){
                continue;
            }

        }
    }
}
