import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split("-");
        String[] firstNum = split[0].split("\\+");
        int first = 0;
        for(String f : firstNum) {
            first += Integer.parseInt(f);
        }

        for(int i=1; i<split.length; i++) {
            int temp = 0;
            String[] next = split[i].split("\\+");
            for(String n : next) {
                temp += Integer.parseInt(n);
            }
            first -= temp;
        }

        System.out.println(first);
    }
}