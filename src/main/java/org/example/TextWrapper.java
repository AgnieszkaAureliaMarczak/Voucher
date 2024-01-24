package org.example;

import org.apache.pdfbox.pdmodel.font.PDFont;

import java.util.ArrayList;
import java.util.List;

public class TextWrapper {
    private LineWidthChecker lineWidthChecker;

    public TextWrapper(LineWidthChecker lineWidthChecker) {
        this.lineWidthChecker = lineWidthChecker;
    }

    public List<String> wrapText(String content) {
        String[] words = content.split("\\s+");
        StringBuilder line = new StringBuilder();
        List<String> contentAsLines = new ArrayList<>();
        for (String word : words) {
            if (lineWidthChecker.exceedsMaxWidth(line + word)) {
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
