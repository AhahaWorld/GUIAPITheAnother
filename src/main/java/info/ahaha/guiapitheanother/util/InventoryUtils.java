package info.ahaha.guiapitheanother.util;

import info.ahaha.guiapitheanother.Point;
import info.ahaha.guiapitheanother.Size;
import info.ahaha.guiapitheanother.VirtualInventory;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

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

    public static Point convertSlotToPoint(InventoryType type, int slot) {
        switch (type) {
            case CHEST:
                return new Point(slot % 9, slot / 9);
            case HOPPER:
                return new Point(slot, 0);
            case DISPENSER:
            case DROPPER:
                return new Point(slot % 3, slot / 4);
        }
        return null;
    }

    public static int convertPointToSlot(InventoryType type, Point point) {
        switch (type) {
            case CHEST:
                return 9 * point.y + point.x;
            case HOPPER:
                return 5 * point.y + point.x;
            case DISPENSER:
            case DROPPER:
                return 3 * point.y + point.x;
        }
        return -1;
    }

    public static ItemStack[] convertVInventoryToInventory(InventoryType type, int length, VirtualInventory vInventory) {
        ItemStack[] buf = new ItemStack[length];
        Size size = vInventory.getSize();
        for (int x = 0; x < size.x; x++)
            for (int y = 0; y < size.y; y++) {
                switch (type) {
                    case CHEST:
                        buf[9 * y + x] = vInventory.get(x, y);
                    case HOPPER:
                        buf[5 * y + x] = vInventory.get(x, y);
                    case DISPENSER:
                    case DROPPER:
                        buf[3 * y + x] = vInventory.get(x, y);
                }
            }
        return buf;
    }
}
