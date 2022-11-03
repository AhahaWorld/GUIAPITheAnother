package info.ahaha.guiapitheanother.bedrock;

import info.ahaha.guiapitheanother.GUIEventCallable;

public interface FormConvertor {
    FormConvertorResult convert();
    interface FormConvertorResult extends BEShowable{
        FormConvertorResult attachCallable(GUIEventCallable callable);
    }
}
