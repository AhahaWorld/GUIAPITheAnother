package info.ahaha.guiapitheanother;

import org.bukkit.inventory.ItemStack;

public interface Layout {
    Size size();
    ItemStack[][] make();;
    ItemStack[][] make(Session session);
}
