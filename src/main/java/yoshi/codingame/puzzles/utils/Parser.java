package yoshi.codingame.puzzles.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parser {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String DEFAULT_ELEMENT_SEPARATOR = " ";

    private final String input;
    private final int totalEntries;
    private String[] lines;

    public Parser(final String input, final int totalEntries) {
        this.input = input;
        this.totalEntries = totalEntries;
    }

    public List<List<String>> parseWithSeparator(final int entry) {
        if (input != null && !input.isEmpty()) {
            lines = input.split(LINE_SEPARATOR);
            int entryValue = Integer.valueOf(lines[entry]);
            int offset = computeOffset(entry);
            return IntStream.range(0, entryValue)
                    .mapToObj(i -> Arrays.asList(lines[i + offset].split(DEFAULT_ELEMENT_SEPARATOR)))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private int computeOffset(final int entry) {
        return totalEntries + (entry > 0 ? IntStream.rangeClosed(0, entry - 1).map(i -> Integer.valueOf(lines[i])).sum() : 0);
    }
}

