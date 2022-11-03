package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.Layout;
import info.ahaha.guiapitheanother.Session;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public interface SupportedBedrockLayout extends Layout{
    FormConvertor.FormConvertorResult makeForBE();
}
