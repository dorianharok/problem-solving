import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        if(words[0].length() <= 1) {
            return new int[]{1, 1};
        }

        int count = 1;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        String lastWord = words[0];

        for(int i=1; i<words.length; i++) {
            if(words[i].charAt(0) != lastWord.charAt(lastWord.length() - 1) || set.contains(words[i]) || words[i].length() <= 1) {
                answer[0] = count % n + 1;
                answer[1] = (count / n) + 1;

                return answer;
            }

            count++;
            set.add(words[i]);
            lastWord = words[i];
        }

        return answer;
    }
}