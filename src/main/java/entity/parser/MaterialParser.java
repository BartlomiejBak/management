package entity.parser;

import entity.enums.Material;

public class MaterialParser {

    public static Material parseMaterial(String str) {
        String material = str.toUpperCase();

        switch (material) {
            case "WOOL":
                return Material.WOOL;
            case "FUR":
                return Material.FUR;
            case "COTTON":
                return Material.COTTON;
            case "LEATHER":
                return Material.LEATHER;
            case "POLYESTER":
                return Material.POLYESTER;
            default:
                return Material.OTHER;
        }
    }
}
