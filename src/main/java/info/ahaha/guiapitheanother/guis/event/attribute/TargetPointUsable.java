package info.ahaha.guiapitheanother.guis.event.attribute;

import info.ahaha.guiapitheanother.GUIEventManager;
import info.ahaha.guiapitheanother.Point;
import info.ahaha.guiapitheanother.annotation.TargetPoint;

public interface TargetPointUsable {
    Point getTargetPoint();

    default boolean checkPoint(GUIEventManager.ListenMethod method){
        TargetPoint point = method.method.getAnnotation(TargetPoint.class);
        if(point == null)
            return true;
        return getTargetPoint().equals(new Point(point.x(), point.y()));
    }
}
