package info.ahaha.guiapitheanother.cmd;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIAPITheAnother;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.List;

public class Cmd implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (args.length < 1) return true;
        for (GUI gui : GUIAPITheAnother.guiList) {
            if (gui.getTitle().equals(args[0])) {
                gui.show(player);
                break;
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
