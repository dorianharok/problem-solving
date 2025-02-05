import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new int[N];

        bt(1, 0);
        System.out.println(sb);
    }

    public static void bt(int n, int depth) {
        if(depth == N) {
            for(int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[depth] = i;
            bt(i, depth + 1);
            visited[i] = false;
            arr[depth] = 0;
        }
    }
}
