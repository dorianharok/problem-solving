import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] alphabets;
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[L];
        alphabets = new int[26];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alphabets[st.nextToken().charAt(0) - 'a']++;
        }

        bt(0, 0);
        System.out.println(sb);
    }

    public static void bt(int start, int depth) {
        if(depth == L) {
            if(!valid()) {
                return;
            }

            for(int i=0; i<L; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");

            return;
        }

        for(int i=start; i<26; i++) {
            if(alphabets[i] == 0) continue;

            arr[depth] = (char)('a' + i);
            alphabets[i]--;
            bt(i + 1, depth+1);
            arr[depth] = ' ';
            alphabets[i]++;
        }
    }

    public static boolean valid() {
        int vowel = 0;

        for (int i = 0; i < L; i++) {
            switch (arr[i]) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    vowel++;
                    break;
            }
        }

        return vowel > 0 && L - vowel > 1;
    }
}
