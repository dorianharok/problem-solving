import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
        }

        System.out.println(sb);
    }
}