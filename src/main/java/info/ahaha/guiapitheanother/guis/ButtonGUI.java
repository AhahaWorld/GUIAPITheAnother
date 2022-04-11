package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.GUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface ButtonGUI extends GUI {
    List<Button> getButtons();

    public static class Button {
        ItemStack icon;
        String iconUrl;
        String title;

        public Button(ItemStack icon, String iconUrl, String title) {
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

        public ItemStack getIcon() {
            return icon;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setIcon(ItemStack icon) {
            this.icon = icon;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }
    }
}
