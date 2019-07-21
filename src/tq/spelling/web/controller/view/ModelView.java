package tq.spelling.web.controller.view;

import java.util.HashMap;

public class ModelView {
    private HashMap<String, Object> model = new HashMap<>();
    private View view;

    public HashMap<String, Object> getModel() {
        return model;
    }

    public void addModel(String key, Object object) {
        model.put(key, object);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
