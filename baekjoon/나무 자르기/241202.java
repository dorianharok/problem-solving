import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(search());
    }

    public static int search() {
        int left = 1;
        int right = arr[arr.length - 1];
        int max = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            long count = 0;
            for(int n : arr) {
                if(n < mid) {
                    continue;
                }
                count += n - mid;
            }

            if(count >= M) {
                left = mid + 1;
                max = mid;
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
}
