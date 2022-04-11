package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface GUI {

    String getTitle();

    GUIEventManager getManager();

    SessionContainer getSessions();

    Layout getLayout();

    default void show(Player player){

    }

    default void call(GUIEvent event) {
        getManager().call(event);
    }

    class SessionContainer {
        List<Session> sessions = new ArrayList<>();

        public void add(Session session) {
            sessions.add(session);
        }

        public Session get(Player player) {
            for (Session session : sessions)
                if (session.getPlayer().getUniqueId().equals(player.getUniqueId()))
                    return session;
            return null;
        }

        public Session delete(Player player) {
            for (Session session : sessions)
                if (session.getPlayer().getUniqueId().equals(player.getUniqueId())) {
                    sessions.remove(session);
                    return session;
                }
            return null;
        }
    }
}
