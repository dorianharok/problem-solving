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

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int l = 1;
        int r = arr[N-1];
        int result = 0;

        while(l <= r) {
            int m = l + (r - l) / 2;

            long count = 0;
            for(int i=0; i<N; i++) {
                if(m >= arr[i]) continue;

                count += arr[i] - m;
            }

            if(count >= M) {
                l = m + 1;
                result = m;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
