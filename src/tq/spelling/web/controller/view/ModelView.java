package tq.spelling.web.controller.view;

import java.util.HashMap;

public class ModelView {
    private HashMap<String, Object> model;
    private View view;

    public HashMap<String, Object> getModel() {
        return getModel();
    }

    public void addModel(String key, Object object) {
        if (model == null) {
            model = new HashMap<>();
        }
        model.put(key, object);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
