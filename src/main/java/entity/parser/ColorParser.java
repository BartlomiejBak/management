package entity.parser;

import entity.enums.Color;

public class ColorParser {

    public static Color parseColor(String str) {
        String color = str.toUpperCase();
        switch (color) {
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            case "BLUE":
                return Color.BLUE;
            case "BLACK":
                return Color.BLACK;
            case "WHITE":
                return Color.WHITE;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return Color.OTHER;
        }
    }
}
