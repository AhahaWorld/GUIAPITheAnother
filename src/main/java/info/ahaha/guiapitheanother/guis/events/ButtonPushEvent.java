package info.ahaha.guiapitheanother.guis.events;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.guis.ButtonGUI;

public class ButtonPushEvent extends GUIEvent {

    private final ButtonGUI.Button button;

    public ButtonPushEvent(GUI gui, Session session, ButtonGUI.Button button) {
        super(gui, session);
        this.button = button;
        
    }

    public ButtonGUI.Button getButton() {
        return button;
    }


}
