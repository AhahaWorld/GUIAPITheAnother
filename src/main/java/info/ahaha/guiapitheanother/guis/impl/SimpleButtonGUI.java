package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockGUI;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.session.FormSession;
import info.ahaha.guiapitheanother.layout.ButtonsLayout;
import info.ahaha.guiapitheanother.util.ButtonFormBuilder;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.List;

public class SimpleButtonGUI implements ButtonGUI, SupportedBedrockGUI {
    private final GUIEventManager manager = new GUIEventManager();
    private final SessionContainer container = new SessionContainer();
    private List<Button> buttons;
    private String title = "";
    private Layout layout;

    public SimpleButtonGUI(String title, List<Button> buttons) {
        this.buttons = buttons;
        this.title = title;
        this.layout = new ButtonsLayout(new Size(9, 4), buttons);
        init();
    }

    @Override
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public GUIEventManager getManager() {
        return manager;
    }

    @Override
    public SessionContainer getSessions() {
        return container;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }


    @Override
    public Session showForBE(Player player, FloodgatePlayer floodgatePlayer) {

        ButtonFormBuilder builder = new ButtonFormBuilder(getButtons(), getTitle());
        FormSession session = new FormSession(this, player);
        floodgatePlayer.sendForm(builder.build(this, player).getForm());
        container.add(session);
        return session;
    }

    @Override
    public Session showForJE(Player player) {
        return ButtonGUI.super.showInventory(player);
    }
}
