import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a,b) -> {
            if(a.length() == b.length()) {
                int sumA = 0;
                for(int i=0; i<a.length(); i++) {
                    if(Character.isDigit(a.charAt(i))) {
                        sumA += a.charAt(i) - '0';
                    }
                }

                int sumB = 0;
                for(int i=0; i<b.length(); i++) {
                    if(Character.isDigit(b.charAt(i))) {
                        sumB += b.charAt(i) - '0';
                    }
                }

                if(sumA == sumB) {
                    return a.compareTo(b);
                }

                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a.length(), b.length());
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}