package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.Layout;
import org.bukkit.entity.Player;

public interface SupportedBedrockLayout extends Layout {
    FormConvertor.FormConvertorResult makeForBE(Player player);
}
