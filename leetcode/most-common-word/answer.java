import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[.\\,]", " ");

        Optional<String> first = Arrays.stream(paragraph.split(" "))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .map(s -> s.replaceAll("[^A-Za-z]", "").toLowerCase())
                .filter(s -> !Arrays.asList(banned).contains(s))
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst();

        return first.get();
    }
}