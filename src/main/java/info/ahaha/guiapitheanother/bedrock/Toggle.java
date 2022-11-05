package info.ahaha.guiapitheanother.bedrock;

public class Toggle {

    private String title;
    private boolean defaultValue;

    public Toggle(String title, boolean defaultValue) {
        this.title = title;
        this.defaultValue = defaultValue;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }
}
