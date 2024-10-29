import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0 && pq.isEmpty()) {
                sb.append("0").append("\n");
                continue;
            }

            if(n == 0) {
                sb.append(pq.poll()).append("\n");
                continue;
            }

            pq.add(n);
        }

        System.out.println(sb);
    }
}