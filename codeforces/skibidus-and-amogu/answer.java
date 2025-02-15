import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            String s = br.readLine();
            sb.append(s.substring(0, s.length()-2)).append("i");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
