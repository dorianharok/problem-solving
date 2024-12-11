import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        visited = new boolean[N];
        visited[K] = true;
        bt(K, 0, 1);

        System.out.println(min);
    }

    public static void bt(int n, int sum, int count) {
        if(count == N) {
            min = Math.min(min, sum);
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            bt(i, sum + arr[n][i], count+1);
            visited[i] = false;
        }
    }
}
