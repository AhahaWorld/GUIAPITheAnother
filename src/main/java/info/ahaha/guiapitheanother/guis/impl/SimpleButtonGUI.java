package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;
import info.ahaha.guiapitheanother.util.ButtonFormBuilder;
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

    @Override
    public Form getForm(Player player) {
        return new ButtonFormBuilder(getButtons(), getTitle()).build(this, player).getForm();
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
