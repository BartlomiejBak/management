package entity.parser;

import entity.enums.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorParserTest {

    @Test
    void parseColor() {
        String color1 = "blue";
        String color2 = "GReeN";
        String color3 = "Pink";

        Color first = ColorParser.parseColor(color1);
        Color second = ColorParser.parseColor(color2);
        Color third = ColorParser.parseColor(color3);

        assertEquals(Color.BLUE, first);
        assertEquals(Color.GREEN, second);
        assertEquals(Color.OTHER, third);
    }

}