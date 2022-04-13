package info.ahaha.guiapitheanother;

public class GUIEvent {
    public GUIEvent(GUI gui, Session session){
        this.gui = gui;
        this.session = session;
    }
    protected final GUI gui;
    protected final Session session;

    public Session getSession() {
        return session;
    }

    public GUI getGUI() {
        return gui;
    }
}
