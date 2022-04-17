package info.ahaha.guiapitheanother.guis;

import info.ahaha.guiapitheanother.Button;
import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.guis.listener.ButtonThrowListener;

import java.util.List;

public interface ButtonGUI extends GUI, LayoutGUI {
    List<Button> getButtons();

    @Override
    default void init() {
        LayoutGUI.super.init();
        getManager().register(new ButtonThrowListener());
    }


}
