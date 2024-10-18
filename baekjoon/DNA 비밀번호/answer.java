import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[26];

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        int[] target = new int[26];
        st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target['C'-'A'] = Integer.parseInt(st.nextToken());
        target['G'-'A'] = Integer.parseInt(st.nextToken());
        target['T'-'A'] = Integer.parseInt(st.nextToken());

        for(int i=0; i<P; i++) {
            char t = dna.charAt(i);
            arr[t-'A']++;
        }

        int answer = 0;
        if(canUse(arr, target)) {
            answer++;
        }

        for(int i=P; i<S; i++) {
            int right = dna.charAt(i) - 'A';
            int left = dna.charAt(i-P) - 'A';

            arr[right]++;
            arr[left]--;

            if(canUse(arr, target)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean canUse(int[] arr, int[] target) {
        int a = target[0];
        int c = target['C'-'A'];
        int g = target['G'-'A'];
        int t = target['T'-'A'];

        if(arr[0] >= a && arr['C'-'A'] >= c && arr['G'-'A'] >= g && arr['T'-'A'] >= t) {
            return true;
        }

        return false;
    }
}