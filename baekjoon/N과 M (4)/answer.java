import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        bt(0);

        System.out.println(sb);
    }

    public static void bt(int index) {
        if(index == M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            arr[index] = i;
            if(index != 0 && arr[index-1] > i) {
                continue;
            }
            bt(index+1);
        }
    }
}