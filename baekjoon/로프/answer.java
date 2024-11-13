import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        int k = N;
        for(int i=0; i<N; i++) {
            int weight = arr[i] * k--;
            max = Math.max(max, weight);
        }

        System.out.println(max);
    }
}