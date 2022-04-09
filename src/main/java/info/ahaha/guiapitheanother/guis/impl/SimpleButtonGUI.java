package info.ahaha.guiapitheanother.guis.impl;

import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.guis.ButtonGUI;
import info.ahaha.guiapitheanother.guis.events.ButtonPushEvent;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;

import java.util.List;

public class SimpleButtonGUI implements ButtonGUI {

    private SessionContainer container;

    @Override
    public void bedRockVer() {

    }

    public void addButton(List<String> texts){

    }

    @Override
    public Form getForm(Player player) {
        SimpleForm.Builder form = SimpleForm.builder();
        form.title(getTitle());
        form.button("test1");
        form.button("test2");
        form.responseHandler((f,s)->{
            SimpleFormResponse response = f.parseResponse(s);
            if (response.isCorrect()){
                ButtonPushEvent buttonPushEvent = new ButtonPushEvent(this,getSessions().get(player), response.getClickedButton().getText(),response.getClickedButtonId());
                this.call(buttonPushEvent);
            }
        });
        return form.build();
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public SessionContainer getSessions() {
        return this.container;
    }

    @Override
    public List<GUIListener> getListeners() {
        return null;
    }
}
