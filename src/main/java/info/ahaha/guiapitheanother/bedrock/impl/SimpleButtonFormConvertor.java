package info.ahaha.guiapitheanother.bedrock.impl;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUIEventCallable;
import info.ahaha.guiapitheanother.Session;
import info.ahaha.guiapitheanother.bedrock.FormConvertor;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;
import info.ahaha.guiapitheanother.guis.session.FormSession;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleButtonFormConvertor implements FormConvertor {
    private String title;
    private List<Button> buttons;

    public SimpleButtonFormConvertor(String title, List<Button> buttons) {
        this.title = title;
        this.buttons = buttons;
    }

    public SimpleButtonFormConvertor(String title, Button... buttons) {
        this.title = title;
        this.buttons = new ArrayList<>(Arrays.asList(buttons));
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public FormConvertorResult convert() {
        SimpleForm.Builder builder = SimpleForm.builder();
        builder.title(getTitle());
        final List<Button> buttons = new ArrayList<>(getButtons());
        for (Button button : buttons) {
            builder.button(button.getTitle());
        }
        return new Result(builder);
    }

    public class Result implements FormConvertorResult {
        private final SimpleForm.Builder builder;
        private GUIEventCallable callable;

        public Result(SimpleForm.Builder builder) {
            this.builder = builder;
        }

        @Override
        public FormConvertorResult attachCallable(GUIEventCallable callable) {
            this.callable = callable;
            return this;
        }

        @Override
        public Session showForBE(Player player, FloodgatePlayer floodgatePlayer) {
            if (callable == null)
                return null;
            FormSession session = new FormSession(callable.getGUI(), player);
            callable.getGUI().getSessions().add(session);
            builder.validResultHandler(response -> {
                Button button = buttons.get(response.clickedButtonId());
                callable.call(new ButtonPushEvent(callable.getGUI(), session, button));
            });
            floodgatePlayer.sendForm(builder.build());
            return session;
        }
    }
}
