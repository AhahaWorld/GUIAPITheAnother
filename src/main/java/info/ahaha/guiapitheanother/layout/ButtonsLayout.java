package info.ahaha.guiapitheanother.layout;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUIListener;
import info.ahaha.guiapitheanother.Size;
import info.ahaha.guiapitheanother.VirtualInventory;
import info.ahaha.guiapitheanother.bedrock.FormConvertor;
import info.ahaha.guiapitheanother.bedrock.SupportedBedrockLayout;
import info.ahaha.guiapitheanother.bedrock.impl.SimpleButtonFormConvertor;
import info.ahaha.guiapitheanother.layout.listener.ButtonThrowListener;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ButtonsLayout implements SupportedBedrockLayout {

    private Size size;
    private List<Button> buttons;


    public ButtonsLayout(Size size, List<Button> buttons) {
        this.size = size;
        this.buttons = buttons;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    @Override
    public String name() {
        return "Button";
    }

    @Override
    public Size size() {
        return this.size;
    }

    @Override
    public boolean make(VirtualInventory inventory, Player player) {
        for (int i = 0; i < buttons.size(); i++) {
            inventory.set(i % size.x, i / size.x, buttons.get(i).getIcon());
        }
        return true;
    }

    @Override
    public List<GUIListener> listeners() {
        return new ArrayList<>(Arrays.asList(new ButtonThrowListener()));
    }

    @Override
    public FormConvertor.FormConvertorResult makeForBE() {
        return new SimpleButtonFormConvertor(name(), buttons).convert();
    }
}
