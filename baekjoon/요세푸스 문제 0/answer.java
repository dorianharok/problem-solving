import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = K;

        while(queue.size() != 1) {
            while(count-- > 1) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
            count = K;
        }

        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}
