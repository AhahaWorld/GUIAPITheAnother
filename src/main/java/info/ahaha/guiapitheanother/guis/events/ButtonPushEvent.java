package info.ahaha.guiapitheanother.guis.events;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.Session;

public class ButtonPushEvent extends GUIEvent {

    private final String buttonText;
    private final int buttonId;

    public ButtonPushEvent(GUI gui, Session session, String buttonText,int buttonId) {
        super(gui, session);
        this.buttonText = buttonText;
        this.buttonId = buttonId;
        
    }

    public int getButtonId() {
        return buttonId;
    }

    public String getButtonText() {
        return buttonText;
    }
}
