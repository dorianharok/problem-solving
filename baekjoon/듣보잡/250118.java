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

        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int count = 0;
        Set<String> answer = new HashSet<>();
        while (M-- > 0) {
            String name = br.readLine();
            if (set.contains(name)) {
                count++;
                answer.add(name);
            }
        }

        System.out.println(count);
        answer.stream().sorted().forEach(System.out::println);
    }
}
