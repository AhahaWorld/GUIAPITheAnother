package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.GUI;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public interface SupportedBedrockGUI extends GUI {
    default void show(Player player) {
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId()) && this instanceof SupportedBedrockGUI) {
            this.showForBE(player, FloodgateApi.getInstance().getPlayer(player.getUniqueId()));
        }else{
            this.showForJE(player);
        }
    }

    void showForBE(Player player, FloodgatePlayer floodgatePlayer);
    void showForJE(Player player);
}
