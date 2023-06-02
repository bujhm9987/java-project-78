package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCheck("checkClass", value -> value == null || value instanceof Map<?, ?>);
    }

    public MapSchema sizeof(Integer size) {
        addCheck("sizeof", value -> value != null && ((Map<?, ?>) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("shape", value -> value != null && schemas.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) value).get(entry.getKey()))));
        return this;
    }
}
