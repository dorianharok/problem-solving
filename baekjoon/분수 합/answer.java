import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nu1 = Integer.parseInt(st.nextToken());
        int de1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nu2 = Integer.parseInt(st.nextToken());
        int de2 = Integer.parseInt(st.nextToken());

        int de = de1 * de2;
        int nu = nu1 * de2 + nu2 * de1;

        int gcd = gcd(nu, de);

        System.out.printf("%d %d", nu / gcd, de / gcd);
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}