package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCheck("checkClass", value -> value == null || value instanceof String);
    }

    @Override
    public StringSchema required() {
        addCheck("required", value -> value != null && !value.toString().isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> value == null || value.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String string) {
        addCheck("contains", value -> value == null || value.toString().contains(string));
        return this;
    }
}
