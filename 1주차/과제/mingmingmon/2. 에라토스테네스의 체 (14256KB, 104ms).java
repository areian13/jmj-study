import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 문제 자체에서 소수도 '지운다'라고 표현하는데 이건 왜 그런거임. cnt 확인하는 부분 클린코드 궁금

    static int getKthErasedNumber(int n, int k) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(!isPrime[i])
                continue;
            cnt++;
           // System.out.printf("%d번째 지워진 수 %d\n", cnt, i);
            if (cnt == k)
                return i;
            for (int j = i; j * i <= n; j++) {
                if(!isPrime[i * j]) // 이 조건식이 없으면 12의 경우 2의 배수이므로 지워졌는데 3의 배수로 다시 지워짐
                    continue;
                isPrime[i * j] = false;
                cnt++;
               // System.out.printf("%d번째 지워진 수 %d\n", cnt, i * j);
                if (cnt == k)
                    return i * j;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = getKthErasedNumber(n, k);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
