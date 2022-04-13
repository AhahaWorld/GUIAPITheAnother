package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.example.SayYoButtonPushListener;
import info.ahaha.guiapitheanother.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class GUIAPITheAnother extends JavaPlugin {

    public static GUIAPITheAnother plugin;
    public static List<GUI>guiList = new ArrayList<>();

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
