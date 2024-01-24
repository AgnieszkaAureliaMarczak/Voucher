package org.example;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDFDocumentConfiguration {
    private final String FILE_PATH_NAME = "src/main/resources/RethinkSans-VariableFont_wght.ttf";
    private static final int DEFAULT_FONT_SIZE = 12;
    private int fontSize;
    private float maxWidth; // Maksymalna szerokość tekstu
    private float startX; // Początkowa pozycja X
    private float startY; // Początkowa pozycja Y
    private float leading; // Interlinia
    private float lastLine;
    private PDRectangle pageSize;

    public PDFDocumentConfiguration() {
        this(
                DEFAULT_FONT_SIZE,
                540,
                30,
                811,
                31,
                PDRectangle.A4);
    }

    public PDFDocumentConfiguration(int fontSize, float maxWidth, float startX, float startY,
                                    float lastLine, PDRectangle pageSize) {
        this.fontSize = fontSize;
        this.maxWidth = maxWidth;
        this.startX = startX;
        this.startY = startY;
        this.leading = -1.5f * fontSize;
        this.lastLine = lastLine;
        this.pageSize = pageSize;
    }

    public String getFILE_PATH_NAME() {
        return FILE_PATH_NAME;
    }

    public int getFontSize() {
        return fontSize;
    }

    public float getMaxWidth() {
        return maxWidth;
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public float getLeading() {
        return leading;
    }

    public float getLastLine() {
        return lastLine;
    }

    public PDRectangle getPageSize() {
        return pageSize;
    }
}
