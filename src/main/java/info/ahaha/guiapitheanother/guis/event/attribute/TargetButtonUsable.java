package info.ahaha.guiapitheanother.guis.event.attribute;

import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.annotation.TargetButton;
import info.ahaha.guiapitheanother.guis.ButtonGUI;

public interface TargetButtonUsable {
    ButtonGUI.Button getTargetButton();

    default boolean check(GUIEventManager.ListenMethod method) {
        TargetButton button = method.method.getAnnotation(TargetButton.class);
        if (button == null)
            return true;
        return getTargetButton().getTitle().equals(button.name());
    }
}
