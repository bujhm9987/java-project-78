package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TestValidator {
    @Test
    public void test1() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        // Пока на вызван метод required(), null и пустая строка считаются валидным
        assertThat(schema.isValid("")).isTrue(); // true
        assertThat(schema.isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid("")).isFalse(); // false
        assertThat(schema.isValid(5)).isFalse(); // false
        assertThat(schema.isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.isValid("hexlet")).isTrue(); // true

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isTrue(); // false

        assertThat(schema.isValid("what does the fox say")).isFalse(); // false
    }
    @Test
    public void test2() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        assertThat(schema.isValid("hexlet")).isTrue(); // true
    }
}
