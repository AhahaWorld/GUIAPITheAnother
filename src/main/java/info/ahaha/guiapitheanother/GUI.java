package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public interface GUI {
    String getTitle();

    GUIEventManager getManager();

    SessionContainer getSessions();

    Session show(Player player);

    default void call(GUIEvent event) {
        getManager().call(event);
    }

    default void init(){
        GUIAPITheAnother.guiList.add(this);
    }

    class SessionContainer {
        Map<UUID, Session> sessions = new HashMap<>();

        public void add(Session session) {
            sessions.put(session.getPlayer().getUniqueId(), session);
        }

        public Session get(Player player) {
            return sessions.get(player.getUniqueId());
        }

        public Session delete(Player player) {
            Session session = sessions.get(player.getUniqueId());
            sessions.remove(player.getUniqueId());
            return session;
        }
    }
}
