import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = a + 1; i <= 62; i++) {
            long pow = 1L << i;

            long temp = pow;
            while (temp >= 10) {
                temp /= 10;
            }

            if (temp == b) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}k