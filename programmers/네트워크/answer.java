import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] v = new boolean[n];

        ArrayDeque<Integer> q = new ArrayDeque<>();

        int answer = 0;
        for(int i=0; i<n; i++) {
            if(v[i]) {
                continue;
            }

            v[i] = true;
            q.add(i);

            while(!q.isEmpty()) {
                int current = q.poll();

                for(int j=0; j<n; j++) {
                    if(v[j] || computers[current][j] != 1) {
                        continue;
                    }

                    v[j] = true;
                    q.offer(j);
                }
            }
            answer++;
        }

        return answer;
    }
}