package tq.spelling.web.resources;

import java.util.HashMap;

public class ResourcesMapper {
    private HashMap< String, String > resourcesKeyToPath = new HashMap<>();
    public void registerPath(String key, String path) {
        resourcesKeyToPath.put(key, path);
    }

    public String getPath(String key) {
        return resourcesKeyToPath.get(key);
    }
}
