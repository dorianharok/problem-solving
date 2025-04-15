import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        int i = 0;
        while(budget > 0 && i < d.length) {
            if(budget < d[i]) {
                break;
            }

            answer++;
            budget -= d[i++];
        }

        return answer;
    }
}