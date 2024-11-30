import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(search());
    }

    public static long search() {
        long left = 1;
        long right = arr[K - 1];
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return answer;
    }
}
