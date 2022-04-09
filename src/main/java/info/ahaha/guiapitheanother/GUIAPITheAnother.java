package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUIAPITheAnother extends JavaPlugin implements Listener {

    public static GUIAPITheAnother plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        ItemBuilder builder = new ItemBuilder(Material.DIAMOND);
        builder.name("つよつよだいや")
                .lore("つよいよー","つよいんだよー")
                        .glow(true);
        e.getPlayer().getInventory().addItem(builder.build());
    }

    public boolean isFloodGateEnable(){

        return getServer().getPluginManager().isPluginEnabled("Floodgate");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
