package info.ahaha.guiapitheanother.guis.event.attribute;

import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.annotation.TargetItemName;
import org.bukkit.inventory.ItemStack;

public interface TargetItemNameUsable {
    ItemStack getTargetItem();

    default boolean checkItemName(GUIEventManager.ListenMethod method) {
        if (getTargetItem() == null)
            return false;
        if (!getTargetItem().hasItemMeta())
            return false;
        if (!getTargetItem().getItemMeta().hasDisplayName())
            return false;
        TargetItemName button = method.method.getAnnotation(TargetItemName.class);
        if (button == null)
            return true;
        return getTargetItem().getItemMeta().getDisplayName().equals(button.name());
    }
}
