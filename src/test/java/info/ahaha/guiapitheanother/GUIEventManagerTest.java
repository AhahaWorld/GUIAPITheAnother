package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.example.SayYoButtonPushListener;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GUIEventManagerTest {
    GUIEventManager manager = new GUIEventManager();
    SayYoButtonPushListener listener = new SayYoButtonPushListener();

    @Test
    void enumerateListenMethod() {
        SayYoButtonPushListener listener = new SayYoButtonPushListener();
        List<GUIEventManager.ListenMethod> enumerated = GUIEventManager.enumerateListenMethod(listener);
        for(GUIEventManager.ListenMethod m : enumerated)
            System.out.println(m.method.getName() + " : " + m.argEventClass.getName());
        assertTrue(enumerated.size() != 0);
    }

    @Test
    void main(){
        register();
        call();
        unregister();
    }

    void register() {
        List<GUIEventManager.ListenMethod> list = manager.register(listener);
        assertNotNull(list);
        assertTrue(list.size() != 0);
    }

    void call() {
        manager.call(new ButtonPushEvent(null, new Session(null, null), null));
    }

    void unregister() {
        Map.Entry<GUIListener, List<GUIEventManager.ListenMethod>> entry = manager.unregister(listener);
        assertNotNull(entry);
        assertTrue(manager.getListenersMap().size() == 0);
    }
}