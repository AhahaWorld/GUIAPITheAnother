package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Session {
    public Session(GUI gui, Player player){
        this.gui = gui;
        this.player = player;
    }

    private final GUI gui;
    private final Player player;
    private final Map<String, Object> properties = new HashMap<>();

    public GUI getGUI() {
        return gui;
    }

    public Player getPlayer() {
        return player;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
}
