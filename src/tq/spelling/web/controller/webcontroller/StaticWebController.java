package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.session.AppSession;
import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.Map;

public class StaticWebController implements WebController {

    private final String jspPageName;
    private final String pageIncludeName;

    public static StaticWebController fromJspPageName(String jspPageName ) {
        return new StaticWebController(jspPageName, jspPageName);
    }
    public static StaticWebController fromPageAndNameIclude(String pageIncludeName, String jspPageName ) {
        return new StaticWebController(jspPageName, pageIncludeName);
    }
     private StaticWebController(String jspPageName, String pageIncludeName) {
        this.jspPageName = jspPageName;
         this.pageIncludeName = pageIncludeName;
     }

    @Override
    public void process(String action, Map<String, String[]> parameters, AppSession appSession, ModelView modelView) {
        modelView.setView(new View(pageIncludeName, "/" + jspPageName +".jsp"));
    }
}
