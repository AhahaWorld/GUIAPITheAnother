package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.guis.event.attribute.SubcontractSelector;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetPointUsable;
import info.ahaha.guiapitheanother.guis.event.convert.ClickPointConvertable;
import info.ahaha.guiapitheanother.guis.session.InventorySession;
import info.ahaha.guiapitheanother.impl.VirtualInventoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUIClickEvent extends InventoryEvent implements ClickPointConvertable, TargetPointUsable, SubcontractSelector {
    public GUIClickEvent(GUI gui, InventorySession session, Point clickPos) {
        super(gui, session);
        this.clickPos = clickPos;
    }

    protected final Point clickPos;

    @Override
    public ClickPointConvertable convertClickPoint(Point new_origin) {
        return new GUIClickEvent(gui, inventorySession, clickPos.sub(new_origin));
    }

    @Override
    public Point getTargetPoint() {
        return clickPos;
    }

    @Override
    public List<? extends GUIEventCallable> selectSubcontract() {
        VirtualInventory inventory = inventorySession.getVirtualInventory();
        if (!(inventory instanceof VirtualInventoryImpl))
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(inventory.dominion(getTargetPoint())));
    }
}
