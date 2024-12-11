import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int INF = (int)1e9;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = INF;

                if(i == j) {
                    map[i][j] = 0;
                }
            }
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], t);
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][k] != INF && map[k][j] != INF) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] city = new int[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=K; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N+1];
        for(int i=1; i<=N; i++) {
            int max = 0;
            for(int j : city) {
                if(map[i][j] == INF || map[j][i] == INF) continue;

                max = Math.max(max, map[i][j] + map[j][i]);
            }
            D[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            min = Math.min(D[i], min);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            if(D[i] == min) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
