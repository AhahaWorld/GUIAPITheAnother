package info.ahaha.guiapitheanother.layout;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.Layout;
import info.ahaha.guiapitheanother.Size;
import info.ahaha.guiapitheanother.VirtualInventory;
import info.ahaha.guiapitheanother.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class CloseLayout implements Layout {
    @Override
    public String name() {
        return "Close";
    }

    @Override
    public Size size() {
        return new Size(0, 0);
    }

    @Override
    public boolean make(VirtualInventory inventory, Player player) {
        inventory.set(0, 0, new ItemBuilder(Material.BARRIER).name(ChatColor.RED + "close").lore("閉じる").build());
        return true;
    }

    @Override
    public List<GUIListener> listeners() {
        return Layout.super.listeners();
    }
}
