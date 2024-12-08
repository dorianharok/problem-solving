import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int len = s.length();

        int max = 0;
        int distinctCount = 0;

        for (int l = 0, r = 0; r < len; r++) {
            int rightChar = s.charAt(r) - 'a';
            if (alphabet[rightChar] == 0) {
                distinctCount++;
            }
            alphabet[rightChar]++;

            while (distinctCount > N) {
                int leftChar = s.charAt(l++) - 'a';
                alphabet[leftChar]--;
                if (alphabet[leftChar] == 0) {
                    distinctCount--;
                }
            }

            max = Math.max(max, r - l + 1);
        }

        System.out.println(max);
    }
}
