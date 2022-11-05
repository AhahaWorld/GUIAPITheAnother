package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.bedrock.Button;

import java.util.List;

public interface ButtonGUI extends LayoutGUI {
    List<Button> getButtons();

    @Override
    default void init() {
        LayoutGUI.super.init();
    }
}
