import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Long> map = Arrays.stream(arr)
                .filter(s -> !Arrays.asList(banned).contains(s))
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        String answer = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        return answer;
    }
}