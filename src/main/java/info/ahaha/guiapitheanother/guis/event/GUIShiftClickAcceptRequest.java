package info.ahaha.guiapitheanother.guis.event;

import info.ahaha.guiapitheanother.*;
import info.ahaha.guiapitheanother.guis.event.convert.NestTimingConvertable;

public class GUIShiftClickAcceptRequest extends GUIEvent implements GUIRequest<GUIEventCallable>, NestTimingConvertable {
    public GUIShiftClickAcceptRequest(GUI gui, Session session) {
        super(gui, session);
        container = new ResponseContainer<>();
    }

    public GUIShiftClickAcceptRequest(GUI gui, Session session, ResponseContainer<GUIEventCallable> container, int basePriority) {
        super(gui, session);
        this.container = container;
        this.basePriority = basePriority;
    }

    protected ResponseContainer<GUIEventCallable> container;
    protected int basePriority = 0;

    @Override
    public ResponseContainer<GUIEventCallable> getContainer() {
        return container;
    }

    @Override
    public int getBasePriority() {
        return basePriority;
    }

    @Override
    public NestTimingConvertable convertNestTiming() {
        return new GUIShiftClickAcceptRequest(gui, session, container, basePriority + 1);
    }
}
