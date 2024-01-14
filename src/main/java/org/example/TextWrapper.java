package org.example;

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
        List<String> lines = new ArrayList<>();
        for (String word : words) {
            if (lineWidthChecker.exceedsMaxWidth(line + word)) {  //wersja bez dodania ostatniego slowa w linijce
                lines.add(line.toString());
                line.setLength(0);
            }
            line.append(word).append(" ");
        }
        if (!line.isEmpty()) {
            lines.add(line.toString());
        }
        return lines;
    }

}
