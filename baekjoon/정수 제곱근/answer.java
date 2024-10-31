import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(binarySearch(n));
    }

    public static long binarySearch(long target) {
        long left = 0L;
        long right = target;

        while (left < right) {
            long mid = (left + right) / 2;

            if(Math.pow(mid,2) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}