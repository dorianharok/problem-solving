import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 정규표현식 수정
        String[] arr = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Optional<String> first = Arrays.stream(arr)
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