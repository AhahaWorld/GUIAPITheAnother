package info.ahaha.guiapitheanother;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Button {
    ItemStack icon;
    String iconUrl;
    String title;

    public Button(String title, ItemStack icon, String iconUrl) {
        this.icon = icon;
        this.iconUrl = iconUrl;
        ItemMeta meta = icon.getItemMeta();

        this.title = title;
        if (!meta.hasDisplayName()) {
            meta.setDisplayName(title);
            this.icon.setItemMeta(meta);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
