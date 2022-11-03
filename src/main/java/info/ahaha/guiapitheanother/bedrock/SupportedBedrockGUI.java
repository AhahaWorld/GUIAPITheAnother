package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Session;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public interface SupportedBedrockGUI extends GUI {
    default Session show(Player player) {
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
            return this.showForBE(player, FloodgateApi.getInstance().getPlayer(player.getUniqueId()));
        }else{
            return this.showForJE(player);
        }
    }

    Session showForBE(Player player, FloodgatePlayer floodgatePlayer);
    Session showForJE(Player player);
}
