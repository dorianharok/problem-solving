import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(isSameArray(st.nextToken(), st.nextToken()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String isSameArray(String s1, String s2) {
        int[] a1 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            a1[s1.charAt(i)-'a']++;
        }
        int[] a2 = new int[26];
        for(int i=0; i<s2.length(); i++) {
            a2[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(a1[i] != a2[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}