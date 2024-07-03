import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String reverse(String text) {
        int length = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

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

    static char itoc(int mod) {
        if (mod >= 10)
            return (char)(mod - 10 + 'A');
        return (char) (mod + '0');
    }

    static String decimalToBase(int n, int b) {
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

    static String convertBase(String number, int fromBase, int toBase) {
        String result = decimalToBase(baseToDecimal(number, fromBase), toBase);
        String paddedString = String.format("%7s", result);
        return result.length() > 7 ? "  ERROR" : paddedString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null /*&& !line.isEmpty()*/) {

            String number = (line.substring(0, 7).trim());
            String fromBase = (line.substring(8, 11).trim());
            String toBase = (line.substring(11).trim());
            //System.out.printf("%s %s %s\n", number, fromBase, toBase);
            String result = convertBase(number, Integer.parseInt(fromBase), Integer.parseInt(toBase));
            //System.out.println(result);
            bw.write(result + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

}
