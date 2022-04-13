package info.ahaha.guiapitheanother;

import org.bukkit.inventory.ItemStack;

public interface Layout {
    Size size();
    boolean make(VirtualInventory inventory);
    boolean make(VirtualInventory inventory, Session session);
}
