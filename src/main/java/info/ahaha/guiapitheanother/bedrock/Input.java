package info.ahaha.guiapitheanother.bedrock;

public class Input {

    private String title;
    private String placeHolder;

    public Input(String title, String placeHolder) {
        this.title = title;
        this.placeHolder = placeHolder;
    }

    public String getTitle() {
        return title;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }
}
