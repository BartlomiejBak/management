package entity.parser;

import entity.enums.Material;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialParserTest {

    @Test
    void parseMaterialWool() {
        Material wool = MaterialParser.parseMaterial("wOOl");
        assertEquals(wool, Material.WOOL);
    }

    @Test
    void parseMaterialCotton() {
        Material cotton = MaterialParser.parseMaterial("cotton");
        assertEquals(cotton, Material.COTTON);
    }

    @Test
    void parseMaterialLeather() {
        Material llether = MaterialParser.parseMaterial("llether");
        assertNotEquals(llether, Material.LEATHER);
    }

    @Test
    void parseMaterialSomething() {
        Material something = MaterialParser.parseMaterial("something");
        assertEquals(something, Material.OTHER);
    }
}