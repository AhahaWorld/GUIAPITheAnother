package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockGUI;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockLayout;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.session.FormSession;
import info.ahaha.guiapitheanother.layout.ButtonsLayout;
import info.ahaha.guiapitheanother.bedrock.impl.SimpleButtonFormConvertor;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleButtonGUI implements ButtonGUI, SupportedBedrockGUI {
    private final GUIEventManager manager = new GUIEventManager();
    private final SessionContainer container = new SessionContainer();
    private List<Button> buttons;
    private String title;
    private final SupportedBedrockLayout layout;

    public SimpleButtonGUI(String title, Button... buttonList) {
        this.buttons = new ArrayList<>();
        Collections.addAll(buttons, buttonList);
        this.title = title;
        this.layout = new ButtonsLayout(new Size(9, 4), buttons);
        init();
    }

    public SimpleButtonGUI(String title, List<Button> buttons) {
        this.buttons = buttons;
        this.title = title;
        this.layout = new ButtonsLayout(new Size(9, 4), buttons);
        init();
    }

    public SimpleButtonGUI(String title, SupportedBedrockLayout layout, Button... buttonList) {
        this.buttons = new ArrayList<>();
        for(Button button : buttons)
            buttons.add(button);
        this.title = title;
        this.layout = layout;
        init();
    }

    public SimpleButtonGUI(String title, SupportedBedrockLayout layout, List<Button> buttons) {
        this.buttons = buttons;
        this.title = title;
        this.layout = layout;
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
        return layout.makeForBE().attachCallable(this).showForBE(player, floodgatePlayer);
    }

    @Override
    public Session showForJE(Player player) {
        return ButtonGUI.super.showInventory(player);
    }
}
