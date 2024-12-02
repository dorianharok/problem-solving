import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        int[] a = new int[nA];
        int[] b = new int[nB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int n : a) {
            if(Arrays.binarySearch(b, n) < 0) {
                count++;
                sb.append(n + " ");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
