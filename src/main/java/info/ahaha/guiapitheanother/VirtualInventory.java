package info.ahaha.guiapitheanother;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public interface VirtualInventory {
    List<LayoutArea> getAreas();

    ItemStack[][] getInventory();

    void setInventory(ItemStack[][] inventory);

    Size getSize();

    ItemStack get(Point point);

    ItemStack get(int x, int y);

    void set(Point point, ItemStack item);

    void set(int x, int y, ItemStack item);

    VirtualInventory cut(Point p1, Point p2);

    VirtualInventory cut(Point point, Size size);
    LayoutArea adapt(String name, Point point, Layout layout);
    LayoutArea adapt(String name, Point point, Layout layout, Session session);

    LayoutArea adapt(String name, Point point, Layout layout, boolean hidden);
    LayoutArea adapt(String name, Point point, Layout layout, Session session, boolean hidden);

    class LayoutArea{
        public LayoutArea(String name, Layout layout, VirtualInventory inventory, boolean hidden) {
            this.name = name;
            this.layout = layout;
            this.inventory = inventory;
            this.hidden = hidden;
        }

        public String name;
        public Layout layout;
        public VirtualInventory inventory;
        public boolean hidden;
    }
}
