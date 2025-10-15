import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                for (int j=0; j<i; j++) {
                    if (arr[j] > arr[i]) {
                        int height = arr[i];
                        for(int k=i; k>j; k--) {
                            arr[k] = arr[k-1];
                            cnt++;
                        }
                        arr[j] = height;
                    }
                }
            }

            System.out.println(number+" "+cnt);
        }
    }
}