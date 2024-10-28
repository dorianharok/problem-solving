import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, n});
                pq.add(n);
            }
            System.out.println(solve(q, pq, M));
        }
    }

    public static int solve(Queue<int[]> q, PriorityQueue<Integer> pq, int target) {
        int count = 1;
        while (!q.isEmpty() && !pq.isEmpty()) {
            if (q.peek()[1] == pq.peek()) {
                if (q.peek()[0] == target) {
                    return count;
                }
                q.poll();
                pq.poll();
                count++;
            } else {
                q.add(q.poll());
            }
        }

        return -1;
    }
}