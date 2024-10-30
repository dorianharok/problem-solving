import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long c = (long) a * b;
            System.out.println(c / gcd(a, b));
        }
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}