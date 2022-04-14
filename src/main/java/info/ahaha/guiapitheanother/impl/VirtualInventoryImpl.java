package info.ahaha.guiapitheanother.impl;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.exception.VirtualInventoryCollisionException;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class VirtualInventoryImpl implements VirtualInventory {
    public VirtualInventoryImpl(Size size) {
        this.size = size;
        inventory = new ItemStack[size.x][size.y];

        origin = this;
    }

    private final VirtualInventoryImpl origin;
    private ItemStack[][] inventory;
    private final Size size;
    private final List<LayoutArea> areas = new ArrayList<>();

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
        return size.clone();
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
        Size layoutSize = layout.size();
        VirtualInventory cutInventory = cut(point, layoutSize);
        LayoutArea area = new LayoutAreaImpl(name, layout, cutInventory, hidden);
        areas.add(area);
        if (!hidden)
            forceVisible(area);
        return area;
    }

    @Override
    public LayoutArea adapt(String name, Point point, Layout layout, Session session, boolean hidden) {
        Size layoutSize = layout.size();
        VirtualInventory cutInventory = cut(point, layoutSize);
        LayoutArea area = new LayoutAreaImpl(name, layout, cutInventory, hidden);
        areas.add(area);
        if (!hidden)
            forceVisible(area);
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

    @Override
    public List<LayoutArea> collision(LayoutArea layoutArea) {
        if (!(layoutArea.getInventory() instanceof CutVirtualInventory))
            return new ArrayList<>();
        CutVirtualInventory o = (CutVirtualInventory) layoutArea.getInventory();
        List<LayoutArea> list = new ArrayList<>();
        for (LayoutArea area : areas) {
            if (area.isHidden())
                continue;
            if (!(area.getInventory() instanceof CutVirtualInventory))
                continue;
            CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
            int in = 0;
            if (o.leftTop.x < i.rightBottom.x)
                in++;
            if (o.leftTop.x < i.leftTop.x)
                in++;
            if (o.leftTop.y < i.rightBottom.y)
                in++;
            if (o.leftTop.y < i.leftTop.y)
                in++;
            if (o.rightBottom.x > i.rightBottom.x)
                in++;
            if (o.rightBottom.x > i.leftTop.x)
                in++;
            if (o.rightBottom.y > i.rightBottom.y)
                in++;
            if (o.rightBottom.y > i.leftTop.y)
                in++;

            if (6 <= in)
                list.add(area);
        }
        return list;
    }

    @Override
    public List<LayoutArea> collision(String name) {
        for (LayoutArea area : areas)
            if (area.getName().equals(name))
                return collision(area);
        return null;
    }

    @Override
    public List<LayoutArea> overlap(LayoutArea layoutArea) {
        if (!(layoutArea.getInventory() instanceof CutVirtualInventory))
            return new ArrayList<>();
        CutVirtualInventory o = (CutVirtualInventory) layoutArea.getInventory();
        List<LayoutArea> list = new ArrayList<>();
        for (LayoutArea area : areas) {
            if (!(area.getInventory() instanceof CutVirtualInventory))
                continue;
            CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
            int in = 0;
            if (o.leftTop.x < i.rightBottom.x)
                in++;
            if (o.leftTop.x < i.leftTop.x)
                in++;
            if (o.leftTop.y < i.rightBottom.y)
                in++;
            if (o.leftTop.y < i.leftTop.y)
                in++;
            if (o.rightBottom.x > i.rightBottom.x)
                in++;
            if (o.rightBottom.x > i.leftTop.x)
                in++;
            if (o.rightBottom.y > i.rightBottom.y)
                in++;
            if (o.rightBottom.y > i.leftTop.y)
                in++;

            if (6 <= in)
                list.add(area);
        }
        return list;
    }

    @Override
    public List<LayoutArea> overlap(String name) {
        for (LayoutArea area : areas)
            if (area.getName().equals(name))
                return overlap(area);
        return null;
    }

    @Override
    public LayoutArea dominion(Point point) {
        for (LayoutArea area : areas) {
            if (area.isHidden())
                continue;
            if (!(area.getInventory() instanceof CutVirtualInventory))
                continue;
            CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
            if (i.leftTop.x < point.x && point.x < i.rightBottom.x &&
                    i.leftTop.y < point.y && point.y < i.rightBottom.y)
                return area;
        }
        return null;
    }

    @Override
    public void hidden(LayoutArea layoutArea) {
        for (LayoutArea area : areas) {
            if (!(area instanceof LayoutAreaImpl))
                continue;
            if (area == layoutArea) {
                ((LayoutAreaImpl) area).setHidden(true);
                area.getInventory().setInventory(new ItemStack[area.getInventory().getSize().x][area.getInventory().getSize().y]);
            }
        }
    }

    @Override
    public void visible(LayoutArea layoutArea) throws VirtualInventoryCollisionException {
        for (LayoutArea area : areas)
            if (area == layoutArea) {
                if (collision(area).size() != 0)
                    throw new VirtualInventoryCollisionException(this);
                if (!(area instanceof LayoutAreaImpl))
                    continue;
                ((LayoutAreaImpl) area).setHidden(true);
                area.getLayout().make(area.getInventory());
            }
    }

    @Override
    public void forceVisible(LayoutArea layoutArea) {
        for (LayoutArea area : areas)
            if (area == layoutArea) {
                for (LayoutArea col : collision(area))
                    hidden(col);
                if (!(area instanceof LayoutAreaImpl))
                    continue;
                ((LayoutAreaImpl) area).setHidden(false);
                area.getLayout().make(area.getInventory());
            }
    }

    public class CutVirtualInventory implements VirtualInventory {
        public CutVirtualInventory(Point p1, Point p2) {
            leftTop = new Point(Math.min(p1.x, p2.x) , Math.min(p1.y, p2.y));
            rightBottom = new Point(Math.max(p1.x, p2.x) , Math.max(p1.y, p2.y));
            size = new Size(rightBottom.x - leftTop.x, rightBottom.y - leftTop.y);
        }

        public CutVirtualInventory(Point point, Size size) {
            leftTop = point.clone();
            rightBottom = new Point(point.x + size.x, point.y + size.y);
            this.size = size.clone();
        }

        private final Point leftTop, rightBottom;
        private final Size size;
        private final List<LayoutArea> areas = new ArrayList<>();

        @Override
        public List<LayoutArea> getAreas() {
            return areas;
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
            return size.clone();
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
        public LayoutArea adapt(String name, Point point, Layout layout, boolean hidden) {
            Size layoutSize = layout.size();
            VirtualInventory cutInventory = cut(point, layoutSize);
            LayoutArea area = new LayoutAreaImpl(name, layout, cutInventory, hidden);
            areas.add(area);
            if (!hidden)
                forceVisible(area);
            return area;
        }

        @Override
        public LayoutArea adapt(String name, Point point, Layout layout, Session session, boolean hidden) {
            Size layoutSize = layout.size();
            VirtualInventory cutInventory = cut(point, layoutSize);
            LayoutArea area = new LayoutAreaImpl(name, layout, cutInventory, hidden);
            areas.add(area);
            if (!hidden)
                forceVisible(area);
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

        @Override
        public List<LayoutArea> collision(LayoutArea layoutArea) {
            if (!(layoutArea.getInventory() instanceof CutVirtualInventory))
                return new ArrayList<>();
            CutVirtualInventory o = (CutVirtualInventory) layoutArea.getInventory();
            List<LayoutArea> list = new ArrayList<>();
            for (LayoutArea area : areas) {
                if (!area.isHidden())
                    continue;
                if (!(area.getInventory() instanceof CutVirtualInventory))
                    continue;
                CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
                int in = 0;
                if (o.leftTop.x < i.rightBottom.x)
                    in++;
                if (o.leftTop.x < i.leftTop.x)
                    in++;
                if (o.leftTop.y < i.rightBottom.y)
                    in++;
                if (o.leftTop.y < i.leftTop.y)
                    in++;
                if (o.rightBottom.x > i.rightBottom.x)
                    in++;
                if (o.rightBottom.x > i.leftTop.x)
                    in++;
                if (o.rightBottom.y > i.rightBottom.y)
                    in++;
                if (o.rightBottom.y > i.leftTop.y)
                    in++;

                if (6 <= in)
                    list.add(area);
            }
            return list;
        }

        @Override
        public List<LayoutArea> collision(String name) {
            for (LayoutArea area : areas)
                if (area.getName().equals(name))
                    return collision(area);
            return null;
        }

        @Override
        public List<LayoutArea> overlap(LayoutArea layoutArea) {
            if (!(layoutArea.getInventory() instanceof CutVirtualInventory))
                return new ArrayList<>();
            CutVirtualInventory o = (CutVirtualInventory) layoutArea.getInventory();
            List<LayoutArea> list = new ArrayList<>();
            for (LayoutArea area : areas) {
                if (!(area.getInventory() instanceof CutVirtualInventory))
                    continue;
                CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
                int in = 0;
                if (o.leftTop.x < i.rightBottom.x)
                    in++;
                if (o.leftTop.x < i.leftTop.x)
                    in++;
                if (o.leftTop.y < i.rightBottom.y)
                    in++;
                if (o.leftTop.y < i.leftTop.y)
                    in++;
                if (o.rightBottom.x > i.rightBottom.x)
                    in++;
                if (o.rightBottom.x > i.leftTop.x)
                    in++;
                if (o.rightBottom.y > i.rightBottom.y)
                    in++;
                if (o.rightBottom.y > i.leftTop.y)
                    in++;

                if (6 <= in)
                    list.add(area);
            }
            return list;
        }

        @Override
        public List<LayoutArea> overlap(String name) {
            for (LayoutArea area : areas)
                if (area.getName().equals(name))
                    return overlap(area);
            return null;
        }

        @Override
        public LayoutArea dominion(Point point) {
            for (LayoutArea area : areas) {
                if (area.isHidden())
                    continue;
                if (!(area.getInventory() instanceof CutVirtualInventory))
                    continue;
                CutVirtualInventory i = (CutVirtualInventory) area.getInventory();
                if (i.leftTop.x < point.x && point.x < i.rightBottom.x &&
                        i.leftTop.y < point.y && point.y < i.rightBottom.y)
                    return area;
            }
            return null;
        }

        @Override
        public void hidden(LayoutArea layoutArea) {
            for (LayoutArea area : areas)
                if (area == layoutArea) {
                    if (!(area instanceof LayoutAreaImpl))
                        continue;
                    ((LayoutAreaImpl) area).setHidden(true);
                    area.getInventory().setInventory(new ItemStack[area.getInventory().getSize().x][area.getInventory().getSize().y]);
                }
        }

        @Override
        public void visible(LayoutArea layoutArea) throws VirtualInventoryCollisionException {
            for (LayoutArea area : areas)
                if (area == layoutArea) {
                    if (collision(area).size() != 0)
                        throw new VirtualInventoryCollisionException(this);
                    if (!(area instanceof LayoutAreaImpl))
                        continue;
                    ((LayoutAreaImpl) area).setHidden(false);
                    area.getLayout().make(area.getInventory());
                }
        }

        @Override
        public void forceVisible(LayoutArea layoutArea) {
            for (LayoutArea area : areas)
                if (area == layoutArea) {
                    for (LayoutArea col : collision(area))
                        hidden(col);
                    if (!(area instanceof LayoutAreaImpl))
                        continue;
                    ((LayoutAreaImpl) area).setHidden(false);
                    area.getLayout().make(area.getInventory());
                }
        }
    }
}
