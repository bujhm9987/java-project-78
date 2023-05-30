package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(Number.class);
    }

    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || value instanceof Number && ((Integer) value) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", value -> value != null && ((Integer) value) >= min && ((Integer) value) <= max);
        return this;
    }

}
