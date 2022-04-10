package info.ahaha.guiapitheanother.example;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class SayYoButtonPushListener implements GUIListener {
    @GUIEventHandler
    public void onPush(ButtonPushEvent e){
        System.out.println("yo!");
    }
}
