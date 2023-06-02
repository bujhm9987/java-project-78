package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {

    private final Validator v = new Validator();

    @Test
    public void testRequired() {
        NumberSchema schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(10)).isTrue();
    }

    @Test
    public void testPositive() {
        NumberSchema schema = v.number();
        assertThat(schema.isValid(-10)).isTrue();
        assertThat(schema.isValid(0)).isTrue();
        schema.positive();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();
    }

    @Test
    public void testRange() {
        NumberSchema schema = v.number();
        assertThat(schema.isValid(4)).isTrue();
        assertThat(schema.isValid(11)).isTrue();
        schema.range(5, 10);
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();
    }
}
