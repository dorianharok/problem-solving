import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                pq.offer(i);
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                while(!pq.isEmpty() && pq.peek() <= i) {
                    pq.poll();
                }

                if(pq.isEmpty() || arr[pq.peek()] <= arr[i]) {
                    continue;
                }

                sum += arr[pq.peek()] - arr[i];
            }

            System.out.println(sum);
        }

    }
}