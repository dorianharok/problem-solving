import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);
    }

    public static void dfs(int start, int depth) {
        if (depth == N / 2) {
            int left = calculate(true);
            int right = calculate(false);

            min = Math.min(min, Math.abs(left - right));
            return;
        }

        for (int i = start; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static int calculate(boolean flag) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if(visited[i] == flag) continue;
            for (int j = 0; j < N; j++) {
                if(visited[j] == flag) continue;

                sum += arr[i][j];
            }
        }

        return sum;
    }
}