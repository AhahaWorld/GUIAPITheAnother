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

    public Result build() {
        SimpleForm.Builder builder = SimpleForm.builder();
        builder.title(getTitle());
        final List<ButtonGUI.Button> buttons = new ArrayList<>(getButtons());
        for (ButtonGUI.Button button : buttons) {
            builder.button(button.getTitle());
        }

        return null; // TODO
    }

    public class Result {

        private Form form;
        private final SimpleForm.Builder builder;

        private void attachResponse(GUI gui){
            builder.responseHandler((f, s) -> {
                SimpleFormResponse response = f.parseResponse(s);
                if (response.isCorrect()) {
                    ButtonGUI.Button button = buttons.get(response.getClickedButtonId());
                    gui.call(new ButtonPushEvent(gui, gui.getSessions().get(null /*TODO*/ ), button));
                }
            });
        }

        public Result(Form form, SimpleForm.Builder builder) {
            this.form = form;
            this.builder = builder;
        }

        public Form getForm() {
            return form;
        }
    }
}
