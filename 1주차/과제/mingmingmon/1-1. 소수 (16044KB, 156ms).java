import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    final static int SIZE = 10000;

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[SIZE + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= SIZE; i++) {
            if(!isPrime[i])
                continue;
            for (int j = 2; i * j <= SIZE; j++) {
                isPrime[i * j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        for (int i = m; i <= n; i++) {
            if (!isPrime[i])
                continue;
            if (min == 0)
                min = i;
            sum += i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = sum == 0 ? "-1" : sum + "\n" + min;
        bw.write(result);
        bw.flush();

        br.close();
        bw.close();
    }
}
