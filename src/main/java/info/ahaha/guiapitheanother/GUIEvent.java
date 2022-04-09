package info.ahaha.guiapitheanother;

public class GUIEvent {
    public GUIEvent(GUI gui, Session session){
        this.gui = gui;
        this.session = session;
    }
    private final GUI gui;
    private final Session session;

    public Session getSession() {
        return session;
    }

    public GUI getGUI() {
        return gui;
    }
}
