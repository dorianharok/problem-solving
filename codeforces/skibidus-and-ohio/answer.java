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
            sb.append(getMinLength(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static int getMinLength(String s) {
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                return 1;
            }
        }

        return s.length();
    }
}
