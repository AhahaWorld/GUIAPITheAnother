package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUIAPITheAnother extends JavaPlugin {

    public static GUIAPITheAnother plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

    }

    public boolean isFloodGateEnable(){

        return getServer().getPluginManager().isPluginEnabled("Floodgate");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
