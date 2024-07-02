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

    static String DecimalToBase(int n, int b) {
        StringBuilder sb = new StringBuilder();

        while(n != 0) {
            int mod = n % b;
            if (mod >= 10){
                sb.append((char)(n % b - 10 + 'A'));
            } else {
                sb.append(n % b);
            }

            n /= b;
        }

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
