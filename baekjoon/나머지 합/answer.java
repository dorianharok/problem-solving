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

        int[] sum = new int[N + 1];
        long[] count = new long[M];
        count[0]++;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = (Integer.parseInt(st.nextToken()) + sum[i - 1]) % M;
            count[sum[i]]++;
        }

        long result = 0;
        for (int i=0; i<M; i++) {
            result += count[i] * (count[i] - 1) / 2;
        }

        System.out.println(result);
    }
}