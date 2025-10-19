import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] capacity = new int[3];
        int[] milk = new int[3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            milk[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<100; i++) {
            int bucket1 = i % 3;
            int bucket2 = (i + 1) % 3;

            int amt = Math.min(milk[bucket1], capacity[bucket2] - milk[bucket2]);

            milk[bucket1] -= amt;
            milk[bucket2] += amt;
        }

        for(int m : milk) {
            System.out.println(m);
        }
    }
}