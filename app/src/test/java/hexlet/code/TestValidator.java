package hexlet.code;

import hexlet.code.schema.MapSchema;
import hexlet.code.schema.NumberSchema;
import hexlet.code.schema.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TestValidator {
    @Test
    public void testStringSchema1() {
        Validator v = new Validator();
        StringSchema schema = v.string();

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
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse(); // false

        assertThat(schema.isValid("what does the fox say")).isFalse(); // false*/
    }
    @Test
    public void testStringSchema2() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        assertThat(schema.isValid("hexlet")).isTrue(); // true
    }

    @Test
    public void testNumberSchema1() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue(); // true
        assertThat(schema.positive().isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid("5")).isFalse(); // false
        assertThat(schema.isValid(10)).isTrue(); // true
        assertThat(schema.isValid(-10)).isFalse(); // false
        assertThat(schema.isValid(0)).isFalse(); // false
        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue(); // true
        assertThat(schema.isValid(10)).isTrue(); // true
        assertThat(schema.isValid(4)).isFalse(); // false
        assertThat(schema.isValid(11)).isFalse(); // false
    }
    @Test
    public void testNumberSchema2() {
        Validator v = new Validator();
        NumberSchema schema = v.number().required().positive().range(-1, 10);
        assertThat(schema.isValid(1)).isTrue(); // true
    }

    @Test
    public void testMapSchema1() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid(new HashMap())).isTrue(); // true

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue(); // true

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();  // false
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue(); // true
    }
    @Test
    public void testMapSchema2() {
        Validator v = new Validator();
        MapSchema schema = v.map().required().sizeof(1);
        assertThat(schema.isValid(Map.of("key1", "value1"))).isTrue(); // true
    }

}
