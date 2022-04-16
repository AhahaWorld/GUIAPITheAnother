package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Layout {
    Size size();

    boolean make(VirtualInventory inventory, Player player);

    default boolean make(VirtualInventory inventory, Session session){
        return make(inventory, session.getPlayer());
    }

    default List<GUIListener> listeners(){
        return null;
    }
}
