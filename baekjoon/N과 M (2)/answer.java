import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=1; i<=N; i++) {
            arr[i-1] = i;
        }

        answer = new int[M];
        visited = new boolean[N+1];

        bt(0, 1,0);

        System.out.println(sb);
    }

    public static void bt(int idx, int start, int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(answer[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            if(visited[i]) {
                continue;
            }
            answer[idx] = i;
            visited[i] = true;
            bt(idx+1, i+1, depth+1);
            answer[idx] = 0;
            visited[i] = false;
        }
    }
}