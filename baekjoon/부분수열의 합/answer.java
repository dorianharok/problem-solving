import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int count = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        count = S == 0 ? count -1 : count;

        System.out.println(count);
    }

    public static void bt(int start, int sum) {
        if (start == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        bt(start + 1, sum + arr[start]);
        bt(start + 1, sum);
    }
}