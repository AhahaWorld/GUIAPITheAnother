package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.Layout;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockGUI;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.List;

public class SimpleButtonGUI implements ButtonGUI, SupportedBedrockGUI {
    private final GUIEventManager manager = new GUIEventManager();
    private final SessionContainer container = new SessionContainer();
    private List<Button> buttons = new ArrayList<>();
    private String title = "";

    @Override
    public List<Button> getButtons() {
        return buttons;
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
        return null;
    }

    @Override
    public Session show(Player player) {
        return ButtonGUI.super.showInventory(player);
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    @Override
    public Session showForBE(Player player, FloodgatePlayer floodgatePlayer) {
        return null; // TODO
    }

    @Override
    public Session showForJE(Player player) {
        return ButtonGUI.super.showInventory(player);
    }
}
