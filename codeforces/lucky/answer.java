import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String s = br.readLine();
            boolean result = isLucky(s);

            if(result) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isLucky(String s) {
        int sum = 0;

        for(int i=0; i<s.length() / 2; i++) {
            sum += s.charAt(i) - '0';
        }

        for(int i=s.length()-1; i>=s.length() / 2; i--) {
            sum -= s.charAt(i) - '0';
        }

        return sum == 0;
    }
}
