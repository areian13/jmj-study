import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
       /*if (num == 2) // 왜 예외처리를 했는가. 1을 더하면서 생긴 문제. 2%2==0이거든.
            return true;*/
        int k = (int)(Math.sqrt(num) + 0.5);
        for (int i = 2; i <= k; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        for (int i = m; i <= n; i++) {
            if (!isPrime(i))
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
