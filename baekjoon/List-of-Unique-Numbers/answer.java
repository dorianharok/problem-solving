import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[100001];

        long cnt = 0;

        for(int l=0, r=0; l<N; l++) {
            while(r < N && count[arr[r]] == 0) {
                count[arr[r++]]++;
            }

            cnt += r - l;

            count[arr[l]]--;
        }

        System.out.println(cnt);
    }
}
