import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        while (right < N) {
            if (arr[right] == 1) {
                cnt++;
            }

            while (cnt == K) {
                min = Math.min(min, right - left + 1);
                if (arr[left] == 1) {
                    cnt--;
                }

                left++;
            }

            right++;
        }

        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        System.out.println(min);
    }
}
