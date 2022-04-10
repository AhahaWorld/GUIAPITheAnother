package info.ahaha.guiapitheanother.util;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEvent;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.cumulus.util.FormBuilder;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class ButtonFormBuilder {
    private List<ButtonGUI.Button> buttons;
    private String title;

    public ButtonFormBuilder(List<ButtonGUI.Button> buttons, String title) {
        this.buttons = buttons;
        this.title = title;
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

    public Result build(GUI gui,Player player) {
        SimpleForm.Builder builder = SimpleForm.builder();
        builder.title(getTitle());
        final List<ButtonGUI.Button> buttons = new ArrayList<>(getButtons());
        for (ButtonGUI.Button button : buttons) {
            builder.button(button.getTitle());
        }

        return new Result(builder,player,gui);
    }

    public class Result {

        private Form form;
        private final SimpleForm.Builder builder;

        private void attachResponse(GUI gui, Player player) {
            builder.responseHandler((f, s) -> {
                SimpleFormResponse response = f.parseResponse(s);
                if (response.isCorrect()) {
                    ButtonGUI.Button button = buttons.get(response.getClickedButtonId());
                    gui.call(new ButtonPushEvent(gui, gui.getSessions().get(player), button));
                }
            });
        }

        public Result(SimpleForm.Builder builder, Player player, GUI gui) {
            this.builder = builder;
            attachResponse(gui, player);
            this.form = builder.build();

        }

        public Form getForm() {
            return form;
        }
    }
}
