import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] answer;
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

        bt(0);

        System.out.println(sb);
    }

    public static void bt(int index) {
        if(index == M) {
            for(int i=0; i<M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            answer[index] = arr[i];
            bt(index+1);
            answer[index] = 0;
        }
    }
}