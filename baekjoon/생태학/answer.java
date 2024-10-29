import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            total++;
        }

        int finalTotal = total;
        map.keySet().stream()
                .sorted()
                .map(k -> String.format("%s %.4f", k, (double)map.get(k) / finalTotal * 100.0))
                .forEach(System.out::println);
    }
}