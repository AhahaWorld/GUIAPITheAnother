package info.ahaha.guiapitheanother;

public class Size implements Cloneable {
    public int x, y;

    public Size(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int capacity() {
        return x * y;
    }

    public boolean fit(Point point) {
        return point.x < x && point.y < y;
    }

    @Override
    public Size clone() {
        try {
            Size clone = (Size) super.clone();
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
            if (((Size) obj).x == x && ((Size) obj).y == y)
                return true;
        return super.equals(obj);
    }
}
