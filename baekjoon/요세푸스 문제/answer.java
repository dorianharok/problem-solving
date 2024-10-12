import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int idx = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (idx % K == 0) {
                sb.append(cur).append(", ");
            } else {
                q.offer(cur);
            }

            idx++;
        }

        sb.delete(sb.lastIndexOf(", "), sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}