package hexlet.code.schema;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        requiredOn = true;
        addCheck("required", value -> value instanceof Number);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value instanceof Number && ((Integer) value) > 0 || value == null);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", value -> ((Integer) value) >= min && ((Integer) value) <= max);
        return this;
    }

}
