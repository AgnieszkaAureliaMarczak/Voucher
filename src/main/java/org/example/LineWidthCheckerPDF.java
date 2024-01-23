package org.example;

import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.IOException;

public class LineWidthCheckerPDF implements LineWidthChecker{
    private double maxLineWidth;
    private PDFont font;
    private int fontSize;

    public LineWidthCheckerPDF(double maxLineWidth, int fontSize) {
        this.maxLineWidth = maxLineWidth;
        this.fontSize = fontSize;
    }

    @Override
    public double getMaxLineWidth() {
        return maxLineWidth;
    }

    @Override
    public double getLineWidth(String line)  {
        try{
            return font.getStringWidth(line) / 1000 * fontSize;
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    public void setFont(PDFont font) {
        this.font = font;
    }
}
