package info.ahaha.guiapitheanother.util;

import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class ButtonFormBuilder {

    private List<ButtonGUI.Button> buttons;
    private Player player;
    private String title;

    public ButtonFormBuilder(List<ButtonGUI.Button> buttons, Player player, String title) {
        this.buttons = buttons;
        this.player = player;
        this.title = title;
    }

    public Player getPlayer() {
        return player;
    }

    public List<ButtonGUI.Button> getButtons() {
        return buttons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setButtons(List<ButtonGUI.Button> buttons) {
        this.buttons = buttons;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Result build() {
        SimpleForm.Builder form = SimpleForm.builder();
        form.title(getTitle());
        final List<ButtonGUI.Button> buttons = new ArrayList<>(getButtons());

        for (ButtonGUI.Button button : buttons) {
            form.button(button.getTitle());
        }
        form.responseHandler((f, s) -> {
            SimpleFormResponse response = f.parseResponse(s);
            if (response.isCorrect()) {
                ButtonGUI.Button button = buttons.get(response.getClickedButtonId());
                ButtonPushEvent buttonPushEvent = new ButtonPushEvent(this, getSessions().get(player), button);
                this.call(buttonPushEvent);
            }
        });

    }

    public class Result {

        private Form form;
        private ButtonPushEvent pushEvent;

        public Result(Form form, ButtonPushEvent pushEvent) {
            this.form = form;
            this.pushEvent = pushEvent;
        }

        public Form getForm() {
            return form;
        }

        public ButtonPushEvent getPushEvent() {
            return pushEvent;
        }
    }
}
