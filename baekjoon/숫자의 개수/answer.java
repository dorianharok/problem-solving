import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;
        int[] arr = new int[10];
        while(result > 0) {
            int mod = result % 10;
            arr[mod]++;
            result = result / 10;
        }

        for(int i=0; i<=9; i++) {
            System.out.println(arr[i]);
        }
    }
}