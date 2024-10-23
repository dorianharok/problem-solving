import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static String[] chars;
    static String[] temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static String[] vowels = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        temp = new String[L];
        chars = new String[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);

        bt(0, 0, 0);

        System.out.println(sb);
    }

    public static void bt(int vowelCount, int index, int start) {
        if (index == L) {
            if(vowelCount >= 1 && L - vowelCount >= 2) {
                for(int i=0; i<L; i++) {
                    sb.append(temp[i]);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            temp[index] = chars[i];
            if (isVowel(chars[i])) {
                bt(vowelCount + 1, index + 1, i+1);
            } else {
                bt(vowelCount, index + 1, i+1);
            }
            visited[i] = false;
            temp[index] = null;
        }
    }

    public static boolean isVowel(String s) {
        for (String v : vowels) {
            if (s.equals(v)) {
                return true;
            }
        }

        return false;
    }
}