package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Session {
    public Session(GUI gui, Player player) {
        this.gui = gui;
        this.player = player;
    }

    private final GUI gui;
    private final Player player;
    private final Map<String, Object> properties = new HashMap<>();
    private Session previous = null, next = null;

    public GUI getGUI() {
        return gui;
    }

    public Player getPlayer() {
        return player;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Session getNext() {
        return next;
    }

    public void setNext(Session next) {
        this.next = next;
    }

    public Session getPrevious() {
        return previous;
    }

    public Session inject(GUI gui) {
        next = gui.show(player);
        return next;
    }

    public Session previous() {
        previous = previous.gui.show(player);
        return previous;
    }

    public Optional<Session> next() {
        if (next == null)
            return Optional.empty();
        next = next.gui.show(player);
        return Optional.ofNullable(next);
    }

    public void close() {
        // for extenders
    }
}
