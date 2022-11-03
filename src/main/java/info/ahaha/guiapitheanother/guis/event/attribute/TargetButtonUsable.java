package info.ahaha.guiapitheanother.guis.event.attribute;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.annotation.TargetButton;

public interface TargetButtonUsable {
    Button getTargetButton();

    default boolean checkButton(GUIEventManager.ListenMethod method) {
        TargetButton button = method.method.getAnnotation(TargetButton.class);
        if (button == null)
            return true;
        return getTargetButton().getTitle().equals(button.name());
    }
}
