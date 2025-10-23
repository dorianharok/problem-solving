import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N-- > 0) {
            if(check(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean check(String s) {
        int[] count = new int[26];
        char prev = ' ';
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(count[c - 'a'] > 0 && prev != c) {
                return false;
            }

            count[c - 'a']++;
            prev = c;
        }

        return true;
    }
}