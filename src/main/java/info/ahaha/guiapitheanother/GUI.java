package info.ahaha.guiapitheanother;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface GUI extends GUIEventCallable {
    String getTitle();

    GUIEventManager getManager();

    SessionContainer getSessions();

    Session show(Player player);

    @Override
    default GUI getGUI(){
        return this;
    }

    default void call(GUIEvent event) {
        getManager().call(event);
    }

    default void init() {
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
