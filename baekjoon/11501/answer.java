import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            Long sum = 0L;
            for(int i=N-1; i>=0; i--) {
                max = Math.max(max, arr[i]);
                sum += max - arr[i];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}