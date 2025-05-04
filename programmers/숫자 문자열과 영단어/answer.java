import java.util.*;

class Solution {
    public int solution(String s) {
        List<String> list = List.of(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for(int i=0; i<10; i++) {
            s = s.replaceAll(list.get(i), i+"");
        }

        return Integer.parseInt(s);
    }
}