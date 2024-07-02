import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int cToi(char c) {
        if ('0' <= c && c <= '9')
            return c - '0';
        return c - 'A' + 10;
    }

    static int baseToDecimal(String n, int b) {
        int length = n.length();
        int result = 0;
        int digit = 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = n.charAt(i);
            int number = cToi(c);
            result += number * digit;
            digit *= b;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int result = baseToDecimal(n, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
