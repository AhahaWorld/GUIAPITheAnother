package info.ahaha.guiapitheanother;

public interface LayoutArea {
    String getName();

    boolean isHidden();

    Layout getLayout();

    VirtualInventory getInventory();

    GUIEventManager getAreaEventManager();
}
