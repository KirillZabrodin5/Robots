package utils;

import java.awt.*;

public class GameWindowConfig {
    private static final int countOfCellsInLength = 12;
    private static final int countOfCellsInWidth = 12;
    private static final int lengthGameWindow = 740; //длина по горизонтали
    private static final int widthGameWindow = 740;

    public static Point translate(int numberCell) { //из номера клетки в пиксели
        return new Point(numberCell * getCellSizeInLength(), numberCell * getCellSizeInWidth());
    }

    public static int getCountOfCellsInLength() {
        return countOfCellsInLength;
    }

    public static int getCountOfCellsInWidth() {
        return countOfCellsInWidth;
    }

    public static int getLengthGameWindow() {
        return lengthGameWindow;
    }

    public static int getWidthGameWindow() {
        return lengthGameWindow;
    }

    public static int getCellSizeInLength() {
        return lengthGameWindow / countOfCellsInLength;
    }

    public static int getCellSizeInWidth() {
        return widthGameWindow / countOfCellsInWidth;
    }
}
