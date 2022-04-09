package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrock;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.cumulus.Form;
import org.geysermc.floodgate.api.FloodgateApi;

public interface ButtonGUI extends SupportedBedrock, GUI {

    Form getForm(Player player);

    default void show(Player player) {
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
            FloodgateApi.getInstance().getPlayer(player.getUniqueId()).sendForm(getForm(player));
        }
    }

    public static class Button {
        ItemStack icon;
        String iconUrl;
        String title;

        public Button(ItemStack icon, String iconUrl, String title) {
            this.icon = icon;
            this.iconUrl = iconUrl;
            ItemMeta meta = icon.getItemMeta();
            this.title = title;
            if (meta == null) {

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
