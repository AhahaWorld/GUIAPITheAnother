package info.ahaha.guiapitheanother.example;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;

public class TestButtonListener implements GUIListener {

    @GUIEventHandler
    public void onTest(ButtonPushEvent e) {
        if (e.getButton().getTitle().equals("test")) {
            e.getSession().getPlayer().sendMessage("TestOk!");
        }
    }
}
