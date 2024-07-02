import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }

    static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int GCD = getGCD(a,b);
        int LCM = getLCM(a,b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(GCD + "\n" + LCM);
        bw.flush();

        br.close();
        bw.close();
    }
}
