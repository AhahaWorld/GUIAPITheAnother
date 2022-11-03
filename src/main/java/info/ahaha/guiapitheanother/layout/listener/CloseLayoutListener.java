package info.ahaha.guiapitheanother.layout.listener;

import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.annotation.TargetItemName;
import info.ahaha.guiapitheanother.guis.event.GUIPickUpEvent;

public class CloseLayoutListener {
    @TargetItemName(name = "Close")
    @GUIEventHandler
    public void onPickUp(GUIPickUpEvent event) {
        event.getSession().close();
    }
}
