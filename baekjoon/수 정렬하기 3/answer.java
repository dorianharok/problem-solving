import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        while(N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr[n]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++) {
            if(arr[i] == 0) continue;

            while(arr[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}