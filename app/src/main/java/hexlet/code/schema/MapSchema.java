package hexlet.code.schema;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        requiredOn = true;
        addCheck("required", value -> value instanceof Map<?, ?>);
        return this;
    }
    public MapSchema sizeof(Integer size) {
        addCheck("sizeof", value -> ((Map<?, ?>) value).size() == size);
        return this;
    }
}
