package hexlet.code;

public class StringSchema {

    private boolean constrain = false;
    private boolean lengthConstrain = false;
    private int minLength;
    private boolean stringContain = false;
    private String containsString;

    public StringSchema required() {
        constrain = true;
        return new StringSchema();
    }

    public StringSchema minLength(int length) {
        minLength = length;
        lengthConstrain = true;
        return new StringSchema();
    }

    public StringSchema contains(String string) {
        stringContain = true;
        containsString = string;
        return new StringSchema();
    }

    public boolean isValid(Object object) {
        boolean result = false;
        if (!constrain && (object == null || object.equals(""))) {
            result = true;
        } else if (object instanceof String && !object.equals("")) {
            result = true;
            String string = object.toString();
            if (lengthConstrain) {
                result = string.length() >= minLength;
            }
            if (stringContain) {
                result = string.contains(containsString);
            }
        }
        return result;
    }
}
