package info.ahaha.guiapitheanother.example;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;

public class SayYoButtonPushListener implements GUIListener {
    @GUIEventHandler
    public void onPush(ButtonPushEvent e){
        System.out.println("yo!");
    }
}
