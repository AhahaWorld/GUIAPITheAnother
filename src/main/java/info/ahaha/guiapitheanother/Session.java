package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;

public class Session {
    public Session(GUI gui, Player player){
        this.gui = gui;
        this.player = player;
    }

    private final GUI gui;
    private final Player player;

    public GUI getGUI() {
        return gui;
    }

    public Player getPlayer() {
        return player;
    }
}
