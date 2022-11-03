package info.ahaha.guiapitheanother;

public class GUIEvent {
    protected final GUI gui;
    protected final Session session;
    public GUIEvent(GUI gui, Session session) {
        this.gui = gui;
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public GUI getGUI() {
        return gui;
    }
}
