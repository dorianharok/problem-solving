import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());

        System.out.println(binarySearch());
    }

    public static long binarySearch() {
        long left = 1;
        long right = arr[N-1];
        long result = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;

            for(long a : arr) {
                long target = Math.min(a, mid);
                sum += target;
            }

            if(sum <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}