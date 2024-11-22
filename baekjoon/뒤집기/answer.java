import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] arr = new int[2];
        int prev = -1;
        for(int i=0; i<S.length(); i++) {
            int c = S.charAt(i) - '0';
            if(c != prev) {
                arr[c]++;
            }

            prev = c;
        }

        System.out.println(Math.min(arr[0], arr[1]));
    }
}