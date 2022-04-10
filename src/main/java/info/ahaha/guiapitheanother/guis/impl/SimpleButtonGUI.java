package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;

import java.util.ArrayList;
import java.util.List;

public class SimpleButtonGUI implements ButtonGUI {

    private SessionContainer container;
    private List<Button> buttons = new ArrayList<>();


    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    @Override
    public void bedRockVer() {

    }

    public void addButton(List<String> texts) {

    }

    @Override
    public Form getForm(Player player) {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public SessionContainer getSessions() {
        return this.container;
    }

    @Override
    public List<GUIListener> getListeners() {
        return null;
    }
}
