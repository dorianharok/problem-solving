import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        while(N-- > 0) {
            String s = br.readLine();
            list.add(s);
        }

        list.sort(Comparator
                .comparingInt(String::length)
                .thenComparingInt(Main::calculateDigit)
                .thenComparing(String::compareTo)
        );

        list.forEach(System.out::println);
    }

    public static int calculateDigit(String s) {
        return s.chars()
                .filter(Character::isDigit)
                .map(c -> c - '0')
                .sum();
    }
}