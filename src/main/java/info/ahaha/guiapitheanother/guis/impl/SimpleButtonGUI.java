package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.Layout;
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
    public void show(Player player) {
        ButtonGUI.super.show(player);
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    @Override
    public void showForBE(Player player, FloodgatePlayer floodgatePlayer) {

    }

    @Override
    public void showForJE(Player player) {
        ButtonGUI.super.show(player);
    }
}
