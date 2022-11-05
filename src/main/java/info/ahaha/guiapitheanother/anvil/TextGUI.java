package info.ahaha.guiapitheanother.anvil;

import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockGUI;
import info.ahaha.guiapitheanother.guis.event.GUITextEvent;
import info.ahaha.guiapitheanother.guis.session.FormSession;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.cumulus.form.impl.custom.CustomFormImpl;
import org.geysermc.cumulus.response.CustomFormResponse;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public class TextGUI implements SupportedBedrockGUI {

    private String title, input, defaultText;
    private GUIEventManager manager;
    private SessionContainer container;

    public TextGUI(String title, String input) {
        this.title = title;
        this.input = input;
    }

    public TextGUI(String title, String input, String defaultText) {
        this.title = title;
        this.input = input;
        this.defaultText = defaultText;
    }


    public String getInput() {
        return input;
    }

    public String getDefaultText() {
        return defaultText;
    }

    @Override
    public String getTitle() {
        return this.title;
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
    public Session showForBE(Player player, FloodgatePlayer floodgatePlayer) {
        CustomForm.Builder builder = new CustomFormImpl.Builder();
        builder.title(getTitle());
        builder.input(getInput());
        builder.closedResultHandler((c)->{

        });
        builder.validResultHandler((f, r) -> {

            if (r.asInput(0) != null) {
                this.call(new GUITextEvent(this, getSessions().get(player), r.asInput(0)));
            }
        });
        floodgatePlayer.sendForm(builder.build());
        FormSession session = new FormSession(this, player);
        container.add(session);
        return session;
    }

    @Override
    public Session showForJE(Player player) {
        return null;
    }
}
