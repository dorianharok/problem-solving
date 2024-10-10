import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        while (N > 0) {
            int mod = N % 10;
            if (mod == 6 || mod == 9) {
                arr[6]++;
            } else {
                arr[mod]++;
            }

            N /= 10;
        }

        arr[6] = (int)Math.ceil((arr[6] / 2.0));

        Arrays.stream(arr).max().ifPresent(System.out::println);
    }
}