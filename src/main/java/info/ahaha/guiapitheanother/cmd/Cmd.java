package info.ahaha.guiapitheanother.cmd;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIAPITheAnother;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.cumulus.form.impl.custom.CustomFormImpl;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.List;

public class Cmd implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (args[0].equals("open")) {
            if (args.length < 2) return true;
            if (args[1] == null) return true;
            for (GUI gui : GUIAPITheAnother.guiList) {
                if (gui.getTitle().equals(args[1])) {
                    gui.show(player);
                    break;
                }
            }
        }
        if (args[0].equals("test")) {
            CustomForm.Builder builder = new CustomFormImpl.Builder();
            builder.toggle("test1");
            builder.toggle("test2");
            FloodgatePlayer floodgatePlayer = FloodgateApi.getInstance().getPlayer(player.getUniqueId());
            floodgatePlayer.sendForm(builder.build());
        }
        if (args[0].equals("list")) {
            player.sendMessage(ChatColor.GRAY + "---------------------------------------------");
            for (GUI gui : GUIAPITheAnother.guiList) {
                player.sendMessage(ChatColor.GREEN + gui.getTitle());
            }
            player.sendMessage(ChatColor.GRAY + "---------------------------------------------");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length >= 1)
            if (args[0].equals("open")) {
                List<String> titles = new ArrayList<>();
                GUIAPITheAnother.guiList.forEach((gui -> {
                    titles.add(gui.getTitle());
                }));
                return titles;
            }
        return null;
    }
}
