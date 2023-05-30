package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected Map<String, Predicate<Object>> allChecked = new HashMap<>();

    public BaseSchema(Class<?> objectClass) {
        addCheck("checkClassType", value -> value == null || objectClass.isAssignableFrom(value.getClass()));
    }

    protected final void addCheck(String nameCheck, Predicate<Object> condition) {
        allChecked.put(nameCheck, condition);
    }

    public final boolean isValid(Object object) {
        return allChecked.values().stream().allMatch(value -> value.test(object));
    }
}
