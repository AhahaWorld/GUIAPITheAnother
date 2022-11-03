package info.ahaha.guiapitheanother.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder name(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        meta.setLore(new ArrayList<>(Arrays.asList(lore)));
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }

    public ItemBuilder glow(boolean glow) {
        if (glow) {
            if (this.meta.getEnchants().isEmpty()) {
                meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            }
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    public ItemBuilder enchant(Enchantment ench, int level) {
        meta.addEnchant(ench, level, true);
        return this;
    }

    public ItemStack build() {
        this.item.setItemMeta(this.meta);
        return this.item.clone();
    }


}
