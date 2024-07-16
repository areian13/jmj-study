package BaekJoon.Silver.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
// S1_1629
    static int aToThePowerOfb(int a, int b, int c) {
        if (b == 1)
            return a % c;

        long result = aToThePowerOfb(a, b / 2, c);
        result *= result;
        result %= c;

        if (b % 2 == 0)
            return (int)result;
        return (int)(result * (a % c) % c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = aToThePowerOfb(a, b, c);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(result));

        bw.flush();

        br.close();
        bw.close();
    }
}
