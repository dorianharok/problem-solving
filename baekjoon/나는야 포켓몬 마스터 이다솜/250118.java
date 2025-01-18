import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> num = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String n = br.readLine();
            name.put(n, i);
            num.put(i, n);
        }

        while(M-- > 0) {
            String s = br.readLine();
            try {
                int i = Integer.parseInt(s);
                System.out.println(num.get(i));
            } catch (NumberFormatException e) {
                System.out.println(name.get(s));
            }
        }
    }
}
