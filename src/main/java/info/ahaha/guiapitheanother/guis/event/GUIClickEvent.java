package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.GUI;
import info.ahaha.guiapitheanother.GUIEventCallable;
import info.ahaha.guiapitheanother.Point;
import info.ahaha.guiapitheanother.VirtualInventory;
import info.ahaha.guiapitheanother.guis.event.attribute.SubcontractSelector;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetItemNameUsable;
import info.ahaha.guiapitheanother.guis.event.attribute.TargetPointUsable;
import info.ahaha.guiapitheanother.guis.event.convert.ClickPointConvertable;
import info.ahaha.guiapitheanother.guis.session.InventorySession;
import info.ahaha.guiapitheanother.impl.VirtualInventoryImpl;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUIClickEvent extends InventoryEvent implements ClickPointConvertable, TargetPointUsable, SubcontractSelector, TargetItemNameUsable, Cancellable {


    protected final Point clickPos;
    private boolean cancelled = false;
    public GUIClickEvent(GUI gui, InventorySession session, Point clickPos) {
        super(gui, session);
        this.clickPos = clickPos;
    }

    @Override
    public ClickPointConvertable convertClickPoint(Point new_origin) {
        return new GUIClickEvent(gui, inventorySession, clickPos.sub(new_origin));
    }

    @Override
    public Point getTargetPoint() {
        return clickPos;
    }

    @Override
    public ItemStack getTargetItem() {
        return inventorySession.getVirtualInventory().get(clickPos);
    }

    @Override
    public List<? extends GUIEventCallable> selectSubcontract() {
        VirtualInventory inventory = inventorySession.getVirtualInventory();
        if (!(inventory instanceof VirtualInventoryImpl))
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(inventory.dominion(getTargetPoint())));
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
