package info.ahaha.guiapitheanother.util;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.event.ButtonPushEvent;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.SimpleForm;

import java.util.ArrayList;
import java.util.List;

public class ButtonFormBuilder {
    private List<Button> buttons;
    private String title;

    public ButtonFormBuilder(List<Button> buttons, String title) {
        this.buttons = buttons;
        this.title = title;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public Result build(GUI gui, Player player) {
        SimpleForm.Builder builder = SimpleForm.builder();
        builder.title(getTitle());
        final List<Button> buttons = new ArrayList<>(getButtons());
        for (Button button : buttons) {
            builder.button(button.getTitle());
        }

        return new Result(builder, player, gui);
    }

    public class Result {
        private Form form;
        private final SimpleForm.Builder builder;

        private void attachResponse(GUI gui, Player player) {
            builder.validResultHandler(response -> {
                Button button = buttons.get(response.clickedButtonId());
                gui.call(new ButtonPushEvent(gui, gui.getSessions().get(player), button));
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
