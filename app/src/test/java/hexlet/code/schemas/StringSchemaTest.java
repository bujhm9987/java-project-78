package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {

    private final Validator v = new Validator();
    private final StringSchema schema = v.string();

    @Test
    public void testRequired() {
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(5)).isFalse();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("hexlet")).isTrue();
    }

    @Test
    public void testMinLength() {
        assertThat(schema.isValid("hexlet")).isTrue();
        schema.minLength(7);
        assertThat(schema.isValid("hexlet")).isFalse();
        assertThat(schema.isValid("hexlet the best")).isTrue();
        assertThat(schema.isValid(null)).isFalse();
    }

    @Test
    public void testContains() {
        assertThat(schema.contains("wh").isValid(null)).isFalse();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();
    }
}
