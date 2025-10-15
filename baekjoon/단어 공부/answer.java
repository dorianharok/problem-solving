import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        int max = 0;
        char maxAlphabet = '?';

        for(int i=0; i<26; i++) {
            if(count[i] > max) {
                max = count[i];
                maxAlphabet = (char)(i+'A');
            } else if(count[i] == max) {
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);
    }
}
