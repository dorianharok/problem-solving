import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> nameMap = new HashMap<>();
    static Map<Integer, String> numberMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numberMap.put(i, name);
        }

        while(M-- > 0) {
            String s = br.readLine();
            try {
                int n = Integer.parseInt(s);
                System.out.println(numberMap.get(n));
            } catch (NumberFormatException e) {
                System.out.println(nameMap.get(s));
            }
        }
    }
}