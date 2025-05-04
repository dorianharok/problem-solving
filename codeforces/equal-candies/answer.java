import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            while(n-- > 0) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int min = pq.poll();
            int sum = 0;
            while(!pq.isEmpty()) {
                sum += pq.poll() - min;
            }

            System.out.println(sum);
        }
    }
}
