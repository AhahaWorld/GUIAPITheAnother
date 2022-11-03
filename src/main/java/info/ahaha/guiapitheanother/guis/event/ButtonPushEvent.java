package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.Session;

public class ButtonPushEvent extends GUIEvent {

    private final Button button;

    public ButtonPushEvent(GUI gui, Session session, Button button) {
        super(gui, session);
        this.button = button;

    }

    public Button getButton() {
        return button;
    }
}
