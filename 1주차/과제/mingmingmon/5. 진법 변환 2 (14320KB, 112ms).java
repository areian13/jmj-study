import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static String reverse(String text) {
        int length = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    static char itoc(int mod) {
        if (mod >= 10)
            return (char)(mod - 10 + 'A');
        return (char) (mod + '0');
    }

    static String DecimalToBase(int n, int b) {
        StringBuilder sb = new StringBuilder();

        // n = 0일 경우 while문이면 반복문 안에 들어갈 수 없어서 sb가 null이 되어버림
        do {
            int mod = n % b;
            sb.append(itoc(mod));
            n /= b;
        } while(n != 0);

        String result = reverse(sb.toString());

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String result = DecimalToBase(n, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(result);
        bw.flush();

        br.close();
        bw.close();
    }

}
