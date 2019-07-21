package tq.spelling.web.controller.view;

public class View {
    private String includeName;
    private String name;

    public View(String includeName, String name) {
        this.includeName = includeName;
        this.name = name;
    }

    public String getIncludeName() {
        return includeName;
    }

    public String getName() {
        return name;
    }
}
