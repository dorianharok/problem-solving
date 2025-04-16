import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(pq.contains(sum)) continue;

                pq.offer(sum);
            }
        }

        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }

        return answer;
    }
}