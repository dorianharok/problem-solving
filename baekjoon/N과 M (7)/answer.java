import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bt(0);

        System.out.println(sb);
    }

    public static void bt(int index) {
        if(index == M) {
            for(int i=0; i<M; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        for(int i=0; i<N; i++) {
            temp[index] = arr[i];
            bt(index + 1);
            temp[index] = 0;
        }
    }
}