import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        while (N-- > 0) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo)
        );

        list.forEach(System.out::println);
    }
}