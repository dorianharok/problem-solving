import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] capacity = new int[3];
        int[] state = new int[3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            state[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int cur = 0;
        while(cnt++ <= 100) {
            int next = (cur + 1) % 3;
            if(capacity[next] >= state[cur] + state[next]) {
                state[next] += state[cur];
                state[cur] = 0;
            } else {
                int d = capacity[next] - state[next];
                state[cur] -= d;
                state[next] += d;
            }

            cur += 1;
            cur %= 3;
        }

        for(int i=0; i<3; i++) {
            System.out.println(state[i]);
        }
    }
}