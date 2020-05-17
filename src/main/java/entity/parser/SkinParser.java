package entity.parser;

import entity.enums.SkinType;

public class SkinParser {

    public static SkinType parseSkinType(String str) {
        String skinType = str.toUpperCase();

        switch (skinType) {
            case "NATURAL":
                return SkinType.NATURAL;
            case "ARTIFICIAL":
                return SkinType.ARTIFICIAL;
            default:
                return SkinType.OTHER;
        }
    }
}
