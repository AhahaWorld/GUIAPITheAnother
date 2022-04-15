package info.ahaha.guiapitheanother.impl;

import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;
import info.ahaha.guiapitheanother.*;


import static org.junit.jupiter.api.Assertions.*;

class VirtualInventoryImplTest {
    static class LayoutImpl implements Layout{
        public LayoutImpl(Size size) {
            this.size = size;
        }

        Size size;

        @Override
        public Size size() {
            return size;
        }

        @Override
        public boolean make(VirtualInventory inventory, Session session) {
            return false;
        }

        @Override
        public boolean make(VirtualInventory inventory, Player player) {
            return false;
        }
    }

    @Test
    void collision(){
        VirtualInventoryImpl inventory = new VirtualInventoryImpl(new Size(10, 10));
        inventory.adapt("a1", new Point(0, 0), new LayoutImpl(new Size(3, 3)));
        inventory.adapt("a2", new Point(4, 4), new LayoutImpl(new Size(3, 3)));
        LayoutArea area3 = inventory.adapt("a3", new Point(1, 1), new LayoutImpl(new Size(3, 3)));
        inventory.collision(area3);
    }
}