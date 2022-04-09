package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface GUI {

    String getTitle();

    default void show(Player player) {

    }

    default void call(GUIEvent event) {
        // TODO listen event
    }

    SessionContainer getSessions();
    List<GUIListener> getListeners();

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
