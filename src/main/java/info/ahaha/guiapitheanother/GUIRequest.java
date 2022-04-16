package info.ahaha.guiapitheanother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GUIRequest<T> {
    ResponseContainer<T> getContainer();

    int getBasePriority();

    default void setResponse(T t, int priority) {
        getContainer().addResponse(t, priority);
    }

    default void setResponse(T t) {
        setResponse(t, getBasePriority());
    }

    class ResponseContainer<T> {
        Map<Integer, List<ResponseData<T>>> container = new HashMap<>();

        GUIListener tmpListener = null;

        public Map<Integer, List<ResponseData<T>>> getContainer() {
            return container;
        }

        public void addResponse(T t, int priority) {
            if (t == null)
                return;
            if (!container.containsKey(priority))
                container.put(priority, new ArrayList<>());
            container.get(priority).add(new ResponseData<>(tmpListener, t));
        }

        public void next(GUIListener listener) {
            tmpListener = listener;
        }

        public T getTop() {
            int priority = -1;
            for (int i : container.keySet())
                if (priority < i)
                    priority = i;
            if (priority == -1)
                return null;
            return container.get(priority).get(0).t;
        }

        public static class ResponseData<T> {
            public ResponseData(GUIListener listener, T t) {
                this.listener = listener;
                this.t = t;
            }

            GUIListener listener;
            T t;
        }
    }
}
