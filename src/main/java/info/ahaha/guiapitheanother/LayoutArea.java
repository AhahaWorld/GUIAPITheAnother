package info.ahaha.guiapitheanother;

public interface LayoutArea extends GUIEventCallable {
    String getName();

    boolean isHidden();

    Layout getLayout();

    VirtualInventory getInventory();

    GUIEventManager getAreaEventManager();

    GUIEvent convert(GUIEvent guiEvent);

    void call(GUIEvent event);
}
