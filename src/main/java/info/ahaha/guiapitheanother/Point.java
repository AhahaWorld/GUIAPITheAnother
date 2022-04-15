package info.ahaha.guiapitheanother;

public class Point implements Cloneable{
    public int x, y;

    public Point add(Point point){
        return new Point(x + point.x, y + point.y);
    }

    public Point sub(Point point){
        return new Point(x - point.x, y - point.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point clone() {
        try {
            Point clone = (Point) super.clone();
            clone.x = x;
            clone.y = y;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Size)
            if(((Size) obj).x == x && ((Size) obj).y == y)
                return true;
        return super.equals(obj);
    }
}
