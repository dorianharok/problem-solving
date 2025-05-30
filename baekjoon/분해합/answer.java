import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<N; i++) {
            int t = i;
            int sum = t;

            while(t > 0) {
                sum += t % 10;
                t /= 10;
            }

            if(sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
