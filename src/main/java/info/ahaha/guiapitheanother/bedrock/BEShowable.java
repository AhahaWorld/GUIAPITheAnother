package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.Session;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public interface BEShowable {
    Session showForBE(Player player, FloodgatePlayer floodgatePlayer);
}
