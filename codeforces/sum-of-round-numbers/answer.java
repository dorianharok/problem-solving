import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            int p = 1;
            while(n > 0) {
                if(n % 10 != 0) {
                    list.add(n % 10 * p);
                }
                n /= 10;
                p *= 10;
            }
            sb.append(list.size()).append("\n");
            for(int l : list) {
                sb.append(l).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
