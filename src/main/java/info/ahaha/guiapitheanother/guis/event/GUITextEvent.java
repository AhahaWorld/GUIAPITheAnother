package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.Session;

public class GUITextEvent extends GUIEvent {

    private String text;

    public GUITextEvent(GUI gui, Session session,String text) {
        super(gui, session);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
