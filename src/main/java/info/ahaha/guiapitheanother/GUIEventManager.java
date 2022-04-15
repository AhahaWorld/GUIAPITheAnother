package info.ahaha.guiapitheanother;

import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetButtonUsable;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetPointUsable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class GUIEventManager implements GUIEventCallable {
    private final Map<GUIListener, List<ListenMethod>> guiListenerMethodMap = new HashMap<>();

    public static List<ListenMethod> enumerateListenMethod(GUIListener listener) {
        List<ListenMethod> list = new ArrayList<>();
        Class<?> clazz = listener.getClass();
        for (Method method : clazz.getMethods()) {
            if (!method.isAnnotationPresent(GUIEventHandler.class))
                continue;
            if (method.getParameterCount() != 1)
                continue;
            if (!method.getParameterTypes()[0].getGenericSuperclass().equals(GUIEvent.class))
                continue;
            list.add(new ListenMethod(method, method.getParameterTypes()[0]));
        }
        return list;
    }

    public List<ListenMethod> register(GUIListener listener) {
        List<ListenMethod> enumerated = enumerateListenMethod(listener);
        guiListenerMethodMap.put(listener, enumerated);
        return enumerated;
    }

    public Map.Entry<GUIListener, List<ListenMethod>> unregister(GUIListener listener) {
        Map.Entry<GUIListener, List<ListenMethod>> entry = new AbstractMap.SimpleEntry<>(listener, guiListenerMethodMap.get(listener));
        guiListenerMethodMap.remove(listener);
        return entry;
    }

    public void call(GUIEvent e) {
        for (GUIListener listener : guiListenerMethodMap.keySet())
            for (ListenMethod m : guiListenerMethodMap.get(listener))
                if (m.argEventClass.equals(e.getClass())) {
                    if(e instanceof TargetPointUsable)
                        if(!((TargetPointUsable) e).check(m))
                            return;
                    if(e instanceof TargetButtonUsable)
                        if(!((TargetButtonUsable) e).check(m))
                            return;
                    try {
                        m.method.invoke(listener, e);
                    } catch (IllegalAccessException | InvocationTargetException ex) {
                        ex.printStackTrace();
                    }
                }
    }

    public Map<GUIListener, List<ListenMethod>> getListenersMap() {
        return guiListenerMethodMap;
    }

    public static class ListenMethod {
        public ListenMethod(Method method, Class<?> argEventClass) {
            this.method = method;
            this.argEventClass = argEventClass;
        }

        public Method method;
        public Class<?> argEventClass;
    }
}
