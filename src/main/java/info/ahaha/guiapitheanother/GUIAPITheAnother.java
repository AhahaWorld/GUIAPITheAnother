package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.cmd.Cmd;
import info.ahaha.guiapitheanother.example.TestButtonListener;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.impl.SimpleButtonGUI;
import info.ahaha.guiapitheanother.listener.InventoryListener;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GUIAPITheAnother extends JavaPlugin {

    public static GUIAPITheAnother plugin;
    public static List<GUI> guiList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        ButtonGUI buttonGUI = new SimpleButtonGUI("test", new ArrayList<>(Arrays.asList(new Button("test", new ItemStack(Material.STRING), null))));
        buttonGUI.getManager().register(new TestButtonListener());
        getServer().getPluginManager().registerEvents(new InventoryListener(),this);
        getCommand("guiapi").setExecutor(new Cmd());
    }

    public boolean isFloodGateEnable() {
        return getServer().getPluginManager().isPluginEnabled("Floodgate");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
