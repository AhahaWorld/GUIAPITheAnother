package info.ahaha.guiapitheanother.util;

import info.ahaha.guiapitheanother.Point;
import info.ahaha.guiapitheanother.Size;
import org.bukkit.event.inventory.InventoryType;

public class InventoryUtils {
    public static InventoryType fitInventoryType(Size size) {
        if (size.y == 1 && size.x <= 5)
            return InventoryType.HOPPER;
        if (size.y <= 3 && size.x <= 3)
            return InventoryType.DISPENSER;
        return null;
    }

    public static int fitInventorySize(Size size) {
        return size.y * 9;
    }

    public static Point convertSlot(InventoryType type, int slot){
        switch (type){
            case CHEST:
                return new Point(slot % 9, slot / 9);
            case HOPPER:
                return new Point(slot % 3, slot / 4);
            case DISPENSER:
            case DROPPER:
                return new Point(slot, 0);
        }
        return null;
    }
}
