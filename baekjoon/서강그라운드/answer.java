import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int INF = (int)1e9;

        int[][] graph = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                graph[i][j] = INF;

                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        while(r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], l);
            graph[b][a] = Math.min(graph[b][a], l);
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j] <= m) {
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
