package hexlet.code.schema;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        requiredOn = true;
        addCheck("required", value -> value instanceof String && !value.toString().isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> value.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String string) {
        addCheck("contains", value -> value.toString().contains(string));
        return this;
    }
}
