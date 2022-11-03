package info.ahaha.guiapitheanother.layout;

import info.ahaha.guiapitheanother.Layout;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.Size;
import info.ahaha.guiapitheanother.VirtualInventory;
import info.ahaha.guiapitheanother.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class PreviousLayout implements Layout {
    @Override
    public String name() {
        return "Previous";
    }

    @Override
    public Size size() {
        return new Size(1, 1);
    }

    @Override
    public boolean make(VirtualInventory inventory, Session session) {
        // TODO inventory.set(0, 0, new ItemBuilder(Material.));
        return false;
    }

    @Override
    public boolean make(VirtualInventory inventory, Player player) {
        return false;
    }
}
