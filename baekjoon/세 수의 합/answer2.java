import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Long> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                set.add((long)arr[i] + arr[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<N; j++) {
                if(set.contains((long)arr[i] - arr[j])) {
                    max = Math.max(Math.max(arr[i], arr[j]), max);
                }
            }
        }

        System.out.println(max);
    }
}
