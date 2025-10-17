import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

        int l = 0;
        int r = 0;
        int max = 0;
        int maxKey = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(l <= r && r < N) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            if(map.get(arr[r]) > max) {
                max = map.get(arr[r]);
                maxKey = arr[r];
            }

            while(max > K) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if(arr[l] == maxKey) {
                    l++;
                    max -= 1;
                    break;
                }
                l++;
            }

            r++;
            maxLen = Math.max(maxLen, r - l);
        }

        System.out.println(maxLen);
    }
}