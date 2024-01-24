package org.example;

public interface LineWidthChecker {

    default boolean exceedsMaxWidth(String line) {
        return getMaxLineWidth() - getLineWidth(line) < 0;
    }
    double getMaxLineWidth();
    double getLineWidth(String line);
}
