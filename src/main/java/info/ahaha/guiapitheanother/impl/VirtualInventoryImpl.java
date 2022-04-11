package info.ahaha.guiapitheanother.impl;

import info.ahaha.guiapitheanother.*;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class VirtualInventoryImpl implements VirtualInventory {
    public VirtualInventoryImpl(Size size) {
        this.size = size;
        inventory = new ItemStack[size.x][size.y];

        origin = this;
    }

    private VirtualInventoryImpl origin;
    private ItemStack[][] inventory;
    private Size size;
    private List<LayoutArea> areas = new ArrayList<>();

    @Override
    public List<LayoutArea> getAreas() {
        return areas;
    }

    @Override
    public ItemStack[][] getInventory() {
        return inventory.clone();
    }

    @Override
    public void setInventory(ItemStack[][] inventory) {
        this.inventory = inventory;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public ItemStack get(Point point) {
        if (!size.fit(point))
            return null;
        return inventory[point.x][point.y];
    }

    @Override
    public ItemStack get(int x, int y) {
        if (size.x <= x || size.y <= y)
            return null;
        return inventory[x][y];
    }

    @Override
    public void set(Point point, ItemStack item) {
        if (!size.fit(point))
            return;
        inventory[point.x][point.y] = item;
    }

    @Override
    public void set(int x, int y, ItemStack item) {
        if (size.x <= x || size.y <= y)
            return;
        inventory[x][y] = item;
    }

    @Override
    public VirtualInventory cut(Point p1, Point p2) {
        return new CutVirtualInventory(p1, p2);
    }

    @Override
    public VirtualInventory cut(Point point, Size size) {
        return new CutVirtualInventory(point, size);
    }

    @Override
    public LayoutArea adapt(String name, Point point, Layout layout, boolean hidden) {
        Size size = layout.size();
        VirtualInventory cutInventory = cut(point, size);
        cutInventory.setInventory(layout.make());
        LayoutArea area = new LayoutArea(name, layout, cutInventory, hidden);
        return area;
    }

    @Override
    public LayoutArea adapt(String name, Point point, Layout layout, Session session, boolean hidden) {
        Size size = layout.size();
        VirtualInventory cutInventory = cut(point, size);
        cutInventory.setInventory(layout.make(session));
        LayoutArea area = new LayoutArea(name, layout, cutInventory, hidden);
        return area;
    }

    @Override
    public LayoutArea adapt(String name, Point point, Layout layout) {
        return adapt(name, point, layout, false);
    }

    @Override
    public LayoutArea adapt(String name, Point point, Layout layout, Session session) {
        return adapt(name, point, layout, session, false);
    }

    public class CutVirtualInventory implements VirtualInventory {
        public CutVirtualInventory(Point p1, Point p2) {
            leftTop = new Point(p1.x < p2.x ? p1.x : p2.x, p1.y < p2.y ? p1.y : p2.y);
            rightBottom = new Point(p1.x > p2.x ? p1.x : p2.x, p1.y > p2.y ? p1.y : p2.y);
            size = new Size(rightBottom.x - leftTop.x, rightBottom.y - leftTop.y);
        }

        public CutVirtualInventory(Point point, Size size) {
            leftTop = point.clone();
            rightBottom = new Point(point.x + size.x, point.y + size.y);
            size = size.clone();
        }

        Point leftTop, rightBottom;
        Size size;

        @Override
        public List<LayoutArea> getAreas() {
            return null;
        }

        @Override
        public ItemStack[][] getInventory() {
            ItemStack[][] cut = new ItemStack[size.x][size.y];
            for (int x = 0; x < rightBottom.x - leftTop.x; x++)
                for (int y = 0; y < rightBottom.y - leftTop.y; x++)
                    cut[x][y] = inventory[leftTop.x + x][leftTop.y + y];
            return cut;
        }

        @Override
        public void setInventory(ItemStack[][] cut) {
            for (int x = 0; x < rightBottom.x - leftTop.x && x < cut.length; x++)
                for (int y = 0; y < rightBottom.y - leftTop.y && y < cut[y].length; y++)
                    inventory[leftTop.x + x][leftTop.y + y] = cut[x][y];
        }

        @Override
        public Size getSize() {
            return size;
        }

        @Override
        public ItemStack get(Point point) {
            return inventory[leftTop.x + point.x][leftTop.y + point.y];
        }

        @Override
        public ItemStack get(int x, int y) {
            return inventory[leftTop.x + x][leftTop.y + y];
        }

        @Override
        public void set(Point point, ItemStack item) {
            inventory[leftTop.x + point.x][leftTop.y + point.y] = item;
        }

        @Override
        public void set(int x, int y, ItemStack item) {
            inventory[leftTop.x + x][leftTop.y + y] = item;
        }

        @Override
        public VirtualInventory cut(Point p1, Point p2) {
            return new CutVirtualInventory(p1.add(leftTop), p2.add(leftTop));
        }

        @Override
        public VirtualInventory cut(Point point, Size size) {
            return new CutVirtualInventory(point.add(leftTop), size);
        }

        @Override
        public LayoutArea adapt(String name, Point point, Layout layout) {
            return origin.adapt(name, point.add(leftTop), layout);
        }

        @Override
        public LayoutArea adapt(String name, Point point, Layout layout, Session session) {
            return origin.adapt(name, point.add(leftTop), layout, session);
        }

        @Override
        public LayoutArea adapt(String name, Point point, Layout layout, boolean hidden) {
            return origin.adapt(name, point.add(leftTop), layout, hidden);
        }

        @Override
        public LayoutArea adapt(String name, Point point, Layout layout, Session session, boolean hidden) {
            return origin.adapt(name, point.add(leftTop), layout, session, hidden);
        }
    }
}
