import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    static int[] arr;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        answer = S == 0 ? answer - 1 : answer;

        System.out.println(answer);
    }

    public static void bt(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }

            return;
        }

        bt(depth + 1, sum + arr[depth]);
        bt(depth + 1, sum);
    }
}
