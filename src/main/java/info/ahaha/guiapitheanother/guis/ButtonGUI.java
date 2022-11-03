package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUI;

import java.util.List;

public interface ButtonGUI extends LayoutGUI {
    List<Button> getButtons();

    @Override
    default void init() {
        LayoutGUI.super.init();
    }
}
