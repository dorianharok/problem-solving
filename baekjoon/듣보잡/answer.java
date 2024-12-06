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
        Map<String, Boolean> map = new HashMap<>();
        while(N-- > 0) {
            map.put(br.readLine(), true);
        }

        Map<String, Boolean> result = new HashMap<>();
        while(M-- > 0) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                result.put(name, true);
            }
        }

        System.out.println(result.size());
        result.keySet().stream().sorted().forEach(System.out::println);
    }
}
