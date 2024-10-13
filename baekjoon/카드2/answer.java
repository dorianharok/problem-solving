import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++) {
            q.add(i);
        }

        int idx = 0;
        while(q.size() != 1) {
            if(idx % 2 == 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }

            idx++;
        }

        System.out.println(q.poll());
    }
}