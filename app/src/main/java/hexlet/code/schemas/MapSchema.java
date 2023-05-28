package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        requiredOn = true;
        addCheck("required", value -> value instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        addCheck("sizeof", value -> ((Map<?, ?>) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("shape", value -> schemas.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid(((Map) value).get(entry.getKey()))));
        return this;
    }
}
