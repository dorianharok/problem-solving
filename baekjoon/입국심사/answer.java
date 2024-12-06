import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        long max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(max));
    }

    public static long binarySearch(long max) {
        long left = 1;
        long right = max * M;
        long result = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;

            if(isPossible(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(long n) {
        long cnt = 0;

        for(int i=0; i<N; i++) {
            cnt += n / arr[i];
            if(cnt > M) break;
        }

        return cnt >= M;
    }
}
