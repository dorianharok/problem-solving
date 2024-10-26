import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        while (N-- > 0) {
            long n = Long.parseLong(br.readLine());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Integer max = Collections.max(map.values());

        Long result = map.entrySet().stream()
                .filter(e -> e.getValue().equals(max))
                .min(Map.Entry.comparingByKey())
                .get()
                .getKey();

        System.out.println(result);
    }
}