package entity.parser;

import entity.enums.SkinType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkinParserTest {

    @Test
    void parseSkinTypeNatural() {
        SkinType skin = SkinParser.parseSkinType("natural");
        assertEquals(skin, SkinType.NATURAL);
    }

    @Test
    void parseSkinTypeArtificial() {
        SkinType skin = SkinParser.parseSkinType("Artificialy");
        assertEquals(skin, SkinType.OTHER);
    }

    @Test
    void parseSkinTypeOther() {
        SkinType skin = SkinParser.parseSkinType("anything");
        assertEquals(skin, SkinType.OTHER);
    }

}