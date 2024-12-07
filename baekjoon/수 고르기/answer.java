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

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        while(right < N && left <= right) {
            int c = Math.abs(arr[right] - arr[left]);

            if(c >= M) {
                min = Math.min(min, c);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(min);
    }
}
