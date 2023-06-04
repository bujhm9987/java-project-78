package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCheck("checkClass", value -> value == null || value instanceof Integer);
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || value instanceof Number && ((Integer) value) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", value -> value == null || ((Integer) value) >= min && ((Integer) value) <= max);
        return this;
    }

}
