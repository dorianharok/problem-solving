import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int result = 0;
            int one = 0;
            int two = 0;
            for(int i=0; i<n; i++) {
                int a = Integer.parseInt(st.nextToken()) % 3;
                if(a == 0) {
                    result++;
                } else if (a == 1) {
                    one++;
                } else {
                    two++;
                }
            }

            int min = Math.min(one, two);
            result += min;
            one -= min;
            two -= min;
            result += one / 3;
            result += two / 3;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}