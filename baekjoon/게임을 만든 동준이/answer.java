import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int prev = arr[N-1];
        for(int i=N-2; i>=0; i--) {
            if(prev > arr[i]) {
                prev = arr[i];
                continue;
            }

            answer += arr[i] - prev + 1;
            prev = prev - 1;
        }

        System.out.println(answer);
    }
}