import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int target = commands[i][2] - 1;

            int[] temp = new int[end - start];
            int idx = 0;
            for(int j=start; j < end; j++) {
                temp[idx++] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[target];
        }

        return answer;
    }
}