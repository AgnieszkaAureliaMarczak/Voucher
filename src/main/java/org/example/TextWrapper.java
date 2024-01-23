package org.example;

import org.apache.pdfbox.pdmodel.font.PDFont;

import java.util.ArrayList;
import java.util.List;

public class TextWrapper {
    private LineWidthCheckerPDF lineWidthCheckerPDF;

    public TextWrapper(LineWidthCheckerPDF lineWidthCheckerPDF) {
        this.lineWidthCheckerPDF = lineWidthCheckerPDF;
    }

    public List<String> wrapText(String content, PDFont font) {
        String[] words = content.split("\\s+");
        StringBuilder line = new StringBuilder();
        List<String> contentAsLines = new ArrayList<>();
        for (String word : words) {
            lineWidthCheckerPDF.setFont(font);
            if (lineWidthCheckerPDF.exceedsMaxWidth(line + word)) {
                contentAsLines.add(line.toString());
                line.setLength(0);
            }
            line.append(word).append(" ");
        }
        if (!line.isEmpty()) {
            contentAsLines.add(line.toString());
        }
        return contentAsLines;
    }
}
