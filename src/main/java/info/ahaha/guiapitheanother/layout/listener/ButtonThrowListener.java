package info.ahaha.guiapitheanother.layout.listener;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.annotation.GUIEventHandler;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;
import info.ahaha.guiapitheanother.guis.event.GUIClickEvent;
import org.bukkit.Bukkit;

public class ButtonThrowListener implements GUIListener {

    @GUIEventHandler
    public void onThrow(GUIClickEvent e) {
        e.setCancelled(true);
        GUI gui = e.getGUI();
        if (!(gui instanceof ButtonGUI)) return;
        ButtonGUI buttonGUI = (ButtonGUI) gui;
        for (Button button : buttonGUI.getButtons()){
            if (button.getIcon().isSimilar(e.getTargetItem())){
                e.getSession().getGUI().call(new ButtonPushEvent(buttonGUI, e.getSession(), button));
                return;
            }
        }
    }
}
