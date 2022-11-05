package info.ahaha.guiapitheanother.bedrock;

public class Slider {

    private String title;
    private double min, max;
    private float defaultValue;

    public Slider(String title, double min, double max, float defaultValue) {
        this.title = title;
        this.min = min;
        this.max = max;
        this.defaultValue = defaultValue;
    }

    public String getTitle() {
        return title;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public float getDefaultValue() {
        return defaultValue;
    }
}
