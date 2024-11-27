import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 덧셈, 뺄셈, 곱셈, 나눗셈
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int n) {
        if (depth == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] == 0) continue;

            operation[i]--;
            switch (i) {
                case 0:
                    dfs(depth + 1, n + arr[depth]);
                    break;
                case 1:
                    dfs(depth + 1, n - arr[depth]);
                    break;
                case 2:
                    dfs(depth + 1, n * arr[depth]);
                    break;
                default:
                    dfs(depth + 1, n / arr[depth]);
                    break;
            }
            operation[i]++;
        }
    }
}